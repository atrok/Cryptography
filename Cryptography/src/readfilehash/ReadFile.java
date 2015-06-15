package readfilehash;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.Arrays;

import xordecryption.NormalizedString;
public class ReadFile {
	
	int offset=256/8;
	
  public static void main(String[] args) {
    try {
      new ReadFile().test();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public byte[] test() throws Exception {
	  //System.out.println(Arrays.toString(new File(".").listFiles()));
	  
    File aFile = new File("C:\\Users\\atrok\\workspace2\\Cryptography\\src\\resources\\VideoFileWithUnknownHash.mp4");
    FileInputStream inFile = new FileInputStream(aFile);
    FileChannel inChannel = inFile.getChannel();
    ByteBuffer buf = ByteBuffer.allocate(1024);
    //buf.position(buf.limit());
    
    double remainder= Math.IEEEremainder(inChannel.size(),1024);
    int blocksNum=Math.round(inChannel.size()/1024);
    
    if (remainder!=0)
    	blocksNum++;
    
    
    System.out.println("File size:"+(inChannel.size()/1024)/1024+", blocksNum:"+blocksNum+", remainder:"+remainder);
    
    byte[][] fileToBytes=new byte[blocksNum][];
    byte[][] shaFileToBytes=new byte[blocksNum][];
    
    int bytesRead = inChannel.read(buf); //read into buffer.
    int blockNum=0;
    
    MessageDigest sha = MessageDigest.getInstance("SHA-256");
    while (bytesRead!=-1) {
    	
    	buf.flip();
    
    	fileToBytes[blockNum] = new byte[buf.limit()];
    
    	
    	buf.get(fileToBytes[blockNum]);
   //     System.out.println("blockNum:"+blockNum+", buf.remaining(): "+buf.remaining()+", buf.position(): "+buf.position()+", strChars.length:"+fileToBytes[blockNum].length);
    	blockNum++;
   		buf.flip();
      
  ///  	System.out.println();
      // 	System.out.println(NormalizedString.toHexString(strChars));
       	//System.out.println(buf.getLong());
       	bytesRead=inChannel.read(buf);
    }
 //   System.out.println("File size:"+(inChannel.size()/1024)/1024+", blocksNum:"+blocksNum+", remainder:"+remainder);
    inFile.close();
    
    // Calculating SHA
    
    // as per algorithm, the last block is kept unchanged
    shaFileToBytes[shaFileToBytes.length-1]=fileToBytes[fileToBytes.length-1];
    
    for (int i=fileToBytes.length-2;i>=0;i--){
    	byte[] shaEncrypted=sha.digest(shaFileToBytes[i+1]);//<-- sha is taken from n-block
    	shaFileToBytes[i]=concat(fileToBytes[i],shaEncrypted); // <--- and appended to n-1 block
    }
 
    byte[]  b=sha.digest(shaFileToBytes[0]);
    System.out.println("SHA:"+NormalizedString.toHexString(b));
    return b; /// return sha of very first block of file 
    
  }
  
  public byte[] concat(byte[] a, byte[] b) {
	   int aLen = a.length;
	   int bLen = b.length;
	   byte[] c= new byte[aLen+bLen];
	   System.arraycopy(a, 0, c, 0, aLen);
	   System.arraycopy(b, 0, c, aLen, bLen);
	   return c;
	}
}