package xordecryption;

import java.util.Arrays;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.xml.bind.DatatypeConverter;

public class decrypt {



	

	private static NormalizedString encodedString=NormalizedString.addHexString("6c73d5240a948c86981bc294814d");
	private static NormalizedString message=NormalizedString.addString("attack at dawn");
	private static NormalizedString message2 = NormalizedString.addString("attack at dusk");
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String reencodedString = encodedString.getHexString();

		test(encodedString.getString(), reencodedString);

		test(message.getString(), message.getString());

		//String messageHex=toHexString(toByteString(message));
		
		String key = toXORArray(encodedString.getBytes(), message.getBytes());

		if (null != key) {
			String encryptedString = toXORArray(NormalizedString.toByteArray(key),message2.getBytes());
			System.out.println("result of encrypting:" + message2.getString()+" hex:"+message2.getHexString() + "\nis:"
					+ encryptedString);

		}

	}

*/
	public static String toXORArray(byte[] key, byte[] message) {
		NormalizedString alphabet = NormalizedString
				.addString("abcdefghijklmnopqrstuvwxyz");//+"abcdefghijklmnopqrstuvwxyz".toUpperCase()+" ,.?/:;'{[]}\\|!@#$%^&*()_-+=1234567890");

		byte[] alphabetBytes=alphabet.getBytes();
		
		int length=0;
		byte[] k;
		byte[] m;
		
		if (key.length<message.length) {
			length=message.length;
			k=Arrays.copyOf(key, length);
			m=Arrays.copyOf(message, length);
		}else{
			length=key.length;
			k=Arrays.copyOf(message, length);
			m=Arrays.copyOf(key, length);
		}
		
		//byte[] key = toByteArray(encodedString);
		//byte[] message = toByteArray(messageString);
		
		if (key.length != message.length) {
			int dif = Math.abs(key.length - message.length);
			int a=0;	
			for (int i = length - dif; i < length; i++) {

				k[i] = key[a];
				a++;
					// k[i]=key[0];
					if (a==(length - dif)) 
						a=0;
					


				}
			
			// key=Arrays.copyOf(k, message.length);
		}
		

			byte[] encrypted = new byte[length];
			for (int i = 0; i < length; i++) {
				byte encryp = (byte) (k[i] ^ m[i]);

				if (Arrays.binarySearch(alphabetBytes, encryp) < alphabetBytes.length)
					encrypted[i] = encryp;
				else 
					encrypted[i]=32;// HEX 20 or SPACE;
				
				/* check if key can be XOR back to message
				if (m[i] != (byte) (encrypted[i] ^ k[i])) {
					System.out.println("XOR failed");
					return null;
				}
				*/
			}
			return NormalizedString.toHexString(encrypted);
		
		
	}
	
	
	 
	 private static void test(String encodedString, String reencodedString){
		 
		 
		 if (!encodedString.toUpperCase().equals(reencodedString.toUpperCase())){
			 System.out.println("encodedStrings doesn't match after being processed to bytearray back and forth");
			 System.out.println("givenString:"+encodedString);
			 System.out.println("reencString:"+reencodedString);
			 
		 }

	 }
}


