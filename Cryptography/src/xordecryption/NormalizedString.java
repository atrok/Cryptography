package xordecryption;

import javax.xml.bind.DatatypeConverter;

public class NormalizedString{
	
	private String strHex;
	private byte[] bytes;
	private String str;
	NormalizedString n;
	
	public static String toHexString(byte[] array) {// it takes bytes and represent it as its hex values as String
	    return DatatypeConverter.printHexBinary(array);
	    
	}

	public static byte[] toByteArray(String s) { //it takes string of hex values and represent it as Bytes array
	    return DatatypeConverter.parseHexBinary(s);
	}

	 public String bytesToString (byte[] bytes){ // it takes Bytes and represent String (US_ASCII)
		 return  new String(bytes);
	 }

	public static NormalizedString addHexString(String str){//it takes hex as a string, in opposite case it would throw exception
		NormalizedString n=NormalizedString.getInstance();
		n.bytes=NormalizedString.toByteArray(str);
		n.strHex=NormalizedString.toHexString(n.bytes);
		n.str=new String(n.bytes);
		return n;
	}
	
	public String getHexString(){
		return strHex;
	}
	
	public byte[] getBytes(){
		return bytes;
	}
	
	private static NormalizedString getInstance(){return new NormalizedString();}



	
	///NormalizedString norm=new NormalizedString();
	
	 public static byte[] stringToBytes(String str){
		 byte[] bytes=str.getBytes();
		 return  bytes;
	 }
	 
 
	 public static NormalizedString addString(String str){
		 NormalizedString n =NormalizedString.getInstance();
		 n.str=str;
		 n.bytes=n.stringToBytes(str);
		 n.strHex=n.toHexString(n.bytes);
		 return n;
	 }
	 
	 public String getString(){return str;}
	 
	 
}
