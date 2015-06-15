package xordecryption;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import readfilehash.ReadFile;

public class Test {

	@org.junit.Test
	public void test() {
		System.out.println(NormalizedString.addHexString("5245465F535649")
				.getString());

		System.out.println(NormalizedString.addHexString(
				"50726F73376F30303034636631373333").getString());
	}

	@org.junit.Test
	public void test2() {



		NormalizedString fB = NormalizedString.addString("From: the cycle");
		NormalizedString fE = NormalizedString.addString("From: probably");
		NormalizedString XORf = NormalizedString.addHexString(decrypt
				.toXORArray(fE.getBytes(), fB.getBytes()));


		System.out.println(XORf.getString());
		System.out.println(NormalizedString.addHexString(
				decrypt.toXORArray(NormalizedString.addString("the").getBytes(),
						XORf.getBytes())).getString());
		
		//System.out.println(NormalizedString.addHexString(NormalizedString.toHexString(runDecryptCycle(fB.getBytes(),fE.getBytes()))).getString());
		

		NormalizedString[] cyphers = {
				NormalizedString
						.addString("315c4eeaa8b5f8aaf9174145bf43e1784b8fa00dc71d885a804e5ee9fa40b16349c146fb778cdf2d3aff021dfff5b403b510d0d0455468aeb98622b137dae857553ccd8883a7bc37520e06e515d22c954eba5025b8cc57ee59418ce7dc6bc41556bdb36bbca3e8774301fbcaa3b83b220809560987815f65286764703de0f3d524400a19b159610b11ef3e"),
				NormalizedString
						.addString("234c02ecbbfbafa3ed18510abd11fa724fcda2018a1a8342cf064bbde548b12b07df44ba7191d9606ef4081ffde5ad46a5069d9f7f543bedb9c861bf29c7e205132eda9382b0bc2c5c4b45f919cf3a9f1cb74151f6d551f4480c82b2cb24cc5b028aa76eb7b4ab24171ab3cdadb8356f"),
				NormalizedString
						.addString("32510ba9a7b2bba9b8005d43a304b5714cc0bb0c8a34884dd91304b8ad40b62b07df44ba6e9d8a2368e51d04e0e7b207b70b9b8261112bacb6c866a232dfe257527dc29398f5f3251a0d47e503c66e935de81230b59b7afb5f41afa8d661cb"),
				NormalizedString
						.addString("32510ba9aab2a8a4fd06414fb517b5605cc0aa0dc91a8908c2064ba8ad5ea06a029056f47a8ad3306ef5021eafe1ac01a81197847a5c68a1b78769a37bc8f4575432c198ccb4ef63590256e305cd3a9544ee4160ead45aef520489e7da7d835402bca670bda8eb775200b8dabbba246b130f040d8ec6447e2c767f3d30ed81ea2e4c1404e1315a1010e7229be6636aaa"),
				NormalizedString
						.addString("3f561ba9adb4b6ebec54424ba317b564418fac0dd35f8c08d31a1fe9e24fe56808c213f17c81d9607cee021dafe1e001b21ade877a5e68bea88d61b93ac5ee0d562e8e9582f5ef375f0a4ae20ed86e935de81230b59b73fb4302cd95d770c65b40aaa065f2a5e33a5a0bb5dcaba43722130f042f8ec85b7c2070"),
				NormalizedString
						.addString("32510bfbacfbb9befd54415da243e1695ecabd58c519cd4bd2061bbde24eb76a19d84aba34d8de287be84d07e7e9a30ee714979c7e1123a8bd9822a33ecaf512472e8e8f8db3f9635c1949e640c621854eba0d79eccf52ff111284b4cc61d11902aebc66f2b2e436434eacc0aba938220b084800c2ca4e693522643573b2c4ce35050b0cf774201f0fe52ac9f26d71b6cf61a711cc229f77ace7aa88a2f19983122b11be87a59c355d25f8e4"),
				NormalizedString
						.addString("32510bfbacfbb9befd54415da243e1695ecabd58c519cd4bd90f1fa6ea5ba47b01c909ba7696cf606ef40c04afe1ac0aa8148dd066592ded9f8774b529c7ea125d298e8883f5e9305f4b44f915cb2bd05af51373fd9b4af511039fa2d96f83414aaaf261bda2e97b170fb5cce2a53e675c154c0d9681596934777e2275b381ce2e40582afe67650b13e72287ff2270abcf73bb028932836fbdecfecee0a3b894473c1bbeb6b4913a536ce4f9b13f1efff71ea313c8661dd9a4ce"),
				NormalizedString
						.addString("315c4eeaa8b5f8bffd11155ea506b56041c6a00c8a08854dd21a4bbde54ce56801d943ba708b8a3574f40c00fff9e00fa1439fd0654327a3bfc860b92f89ee04132ecb9298f5fd2d5e4b45e40ecc3b9d59e9417df7c95bba410e9aa2ca24c5474da2f276baa3ac325918b2daada43d6712150441c2e04f6565517f317da9d3"),
				NormalizedString
						.addString("271946f9bbb2aeadec111841a81abc300ecaa01bd8069d5cc91005e9fe4aad6e04d513e96d99de2569bc5e50eeeca709b50a8a987f4264edb6896fb537d0a716132ddc938fb0f836480e06ed0fcd6e9759f40462f9cf57f4564186a2c1778f1543efa270bda5e933421cbe88a4a52222190f471e9bd15f652b653b7071aec59a2705081ffe72651d08f822c9ed6d76e48b63ab15d0208573a7eef027"),
				NormalizedString
						.addString("466d06ece998b7a2fb1d464fed2ced7641ddaa3cc31c9941cf110abbf409ed39598005b3399ccfafb61d0315fca0a314be138a9f32503bedac8067f03adbf3575c3b8edc9ba7f537530541ab0f9f3cd04ff50d66f1d559ba520e89a2cb2a83"),
				NormalizedString
						.addString("32510ba9babebbbefd001547a810e67149caee11d945cd7fc81a05e9f85aac650e9052ba6a8cd8257bf14d13e6f0a803b54fde9e77472dbff89d71b57bddef121336cb85ccb8f3315f4b52e301d16e9f52f904"), };

		NormalizedString[] res = new NormalizedString[cyphers.length - 1];

		for (int i = 0; i < cyphers.length - 1; i++) { // c1^c2=m1^m2=res
														// resulting bitset
														// could be used to try
														// to reveal word
														// patterns
			//res[i] =NormalizedString.addHexString(NormalizedString.toHexString(runDecryptCycle(cyphers[i].getBytes(), cyphers[i + 1].getBytes())));
			
			// res[i]=NormalizedString.addHexString(decrypt.toXORArray(res[i].getBytes(),XORalhabet.getBytes()));
			//System.out.println("res[" + i + "]: " + res[i].getHexString());

		}
		
		NormalizedString word=NormalizedString.addString("i");
		String key = "015501550150045A0306045603";
				//decrypt.toXORArray(cyphers[1].getBytes(),cyphers[4].getBytes());
		
		
		//byte[] decypher = runDecryptCycle(word.getBytes(), NormalizedString.addHexString(key).getBytes());
		HashMap<Integer,Map<Integer,Integer>> decypher = (HashMap)runDecryptCycle(cyphers[10].getBytes(), cyphers[8].getBytes());
		
		System.out.println("CYP1 :"+cyphers[1].getHexString());
		System.out.println("CYP2 :"+cyphers[4].getHexString());
		System.out.println("WORD :"+word.getHexString());
		System.out.println("XOR  :"+key);
		
		//for (int l=0;l<decypher.length;l++){
		for (Integer k: decypher.keySet()){
			byte[] achar=new byte[decypher.size()];
			byte[] xorchar=new byte[decypher.size()];
				System.out.println("position "+k);		
			for(Integer cypChar1:decypher.get(k).keySet()){
				

		
		System.out.print(" "+NormalizedString.addHexString(Integer.toHexString(cypChar1)).getString());
			}
			System.out.println("\n");
			for(Integer cypChar1:decypher.get(k).keySet()){
				
			
			System.out.print(" "+NormalizedString.addHexString(Integer.toHexString(decypher.get(k).get(cypChar1))).getString());
			}
			System.out.println("\n-------");		

		}
		
	}

	
	
	@SuppressWarnings("unchecked")
	private Map runDecryptCycle(byte[] c1,byte[] c2) {

		NormalizedString alphabet = NormalizedString
				.addString("abcdefghijklmnopqrstuvwxyz ");// +"abcdefghijklmnopqrstuvwxyz".toUpperCase());
						//+ "+" ,.?/:;'{[]}\\|!@#$%^&*()_-+=1234567890");
		System.out.println("Alphabet as BYTE: "
				+ Arrays.toString(alphabet.getBytes())+"\nAlphabet as HEX : "+alphabet.getHexString());
		NormalizedString space = NormalizedString.addHexString("20");
		NormalizedString XORalhabet = NormalizedString.addString(decrypt
				.toXORArray(space.getBytes(), alphabet.getBytes()));

		System.out.println("\nXORalhabet: " + alphabet.getHexString());

		

		//for (int i = 0; i < cyphers.length - 1; i++) { // c1^c2=m1^m2=res
			// resulting bitset
			// could be used to try
			// to reveal word
			// patterns
			NormalizedString res = NormalizedString.addHexString(decrypt.toXORArray(
					c1, c2));
			// res[i]=NormalizedString.addHexString(decrypt.toXORArray(res[i].getBytes(),XORalhabet.getBytes()));
			System.out.println("res: " + res.getHexString());

			byte[] alphabetBytes = alphabet.getBytes();
			Arrays.sort(alphabetBytes);
				
			Map<Integer,Map<Integer,Integer>> asciibytes=new HashMap();
			// Map[] asciibytes = new Map[res.getBytes().length]; // create
			// array of
			// length of
			// message
			// to put
			// resolved
			// ascii
			// bytecodes
			// in there
			for (Integer b=0;b<res.getBytes().length;b++) {
				Map<Integer,Integer> m=new HashMap();
			for (int a = 0; a < alphabetBytes.length; a++)// XOR res bytes with
			// each byte
			// representing
			// ASCII
			{

					
					byte xor = (byte)(alphabetBytes[a]^res.getBytes()[b]);
					int r=Arrays.binarySearch(alphabetBytes, xor);
					if (r < alphabetBytes.length&&r>0){
						//System.out.println("binarySearch returned:"+r+" ");
						Integer freq=(int)alphabetBytes[a];//autoboxing from int toInteger
						Integer intxor=(int)xor;
						m.put(freq, intxor);
						asciibytes.put(b,m);
						
					}
				}

			}
			///System.out.println((NormalizedString.addHexString(NormalizedString.toHexString((asciibytes))).getString()));

		return asciibytes;
	}
	
	@org.junit.Test
	public void test3() {
		double aeskey=Math.pow(2, 128);
		double machinetime=4*Math.pow(10,12)/200;
		double year=3600*24*365;
		
		double res=aeskey/(machinetime*year);
		
		System.out.println("res :"+res);
	}
	
	@org.junit.Test
	public void test4(){
		
		NormalizedString[][] a={
				{NormalizedString.addHexString("9f970f4e932330e4"),NormalizedString.addHexString("6068f0b1b645c008")},
				{NormalizedString.addHexString("4af532671351e2e1"),NormalizedString.addHexString("87a40cfa8dd39154")},
				{NormalizedString.addHexString("7b50baab07640c3d"),NormalizedString.addHexString("ac343a22cea46d60")},
				{NormalizedString.addHexString("5f67abaf5210722b"),NormalizedString.addHexString("bbe033c00bc9330e")}
		};
		for (NormalizedString[] n: a){
			System.out.println(n[0].getHexString()+" xor "+n[1].getHexString()+": "+decrypt.toXORArray(n[0].getBytes(), n[1].getBytes()));
		}
		
	}
	
	@org.junit.Test
	public void test5(){
		NormalizedString[] a={
				NormalizedString.addString("If qualified opinions incline to believe in the exponential conjecture, then I think we cannot afford not to make use of it."),
				NormalizedString.addString("In this letter I make some remarks on a general principle relevant to enciphering in general and my machine."),
				NormalizedString.addString("The most direct computation would be for the enemy to try all 2^r possible keys, one by one."),
				NormalizedString.addString("The significance of this general conjecture, assuming its truth, is easy to see. It means that it may be feasible to design ciphers that are effectively unbreakable.")
		};
		
		for (NormalizedString n: a){
			System.out.println(n.getString()+": "+n.getBytes().length+" "+n.getBytes().length/16);
		}
	}
	
	@org.junit.Test
	public void test6(){
		
		NormalizedString a=NormalizedString.addHexString("66e94bd4ef8a2c3b884cfa59ca342b2e");
		NormalizedString v=NormalizedString.addHexString("a17e9f69e4f25a8b8620b4af78eefd6f");
		System.out.println("Q8: "+decrypt.toXORArray(a.getBytes(), v.getBytes()));
	}
	
	@org.junit.Test
	public void test7(){ // calculate sha of file
		
		ReadFile rf=new ReadFile();
		
		try {
			assertEquals("03c08f4ee0b576fe319338139c045c89c3e8e9409633bea29442e21425006ea8", NormalizedString.toHexString(rf.test()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@org.junit.Test
	public void test8(){ // substitute content of encrypted text data (CPA attack on CBC with random IV)
		NormalizedString a=NormalizedString.addHexString("20814804c1767293b99f1d9cab3bc3e7");// IV ac1e37bfb15599e5f40eef805488281d  
		NormalizedString b=NormalizedString.addHexString("ac1e37bfb15599e5f40eef805488281d");//the plaintext is the ASCII encoding of the message "Pay Bob 100$" (excluding the quotes).
		NormalizedString plaintext=NormalizedString.addString("Pay Bob 100$");
		NormalizedString tamperedText=NormalizedString.addString("Pay Bob 500$");
		System.out.println(a.getHexString());
		System.out.println(decrypt.toXORArray(NormalizedString.addHexString(decrypt.toXORArray(plaintext.getBytes(), tamperedText.getBytes())).getBytes(), a.getBytes()));
		
	}
	
}
