package utils;

import java.util.Iterator;
import java.util.List;

public class ArrayUtils {

	public static byte[][] cloneArray(byte[][] src) {
	    int length = src.length;
	    byte[][] target = new byte[length][src[0].length];
	    for (int i = 0; i < length; i++) {
	        System.arraycopy(src[i], 0, target[i], 0, src[i].length);
	    }
	    return target;
	}
	

    
    public static int[] toIntArray(List<Integer> integers)
{
    int[] ret = new int[integers.size()];
    Iterator<Integer> iterator = integers.iterator();
    for (int i = 0; i < ret.length; i++)
    {
        ret[i] = iterator.next().intValue();
    }
    return ret;
}

    public static byte[] toByteArray(List<Byte> in) {
    final int n = in.size();
    byte ret[] = new byte[n];
    for (int i = 0; i < n; i++) {
        ret[i] = in.get(i);
    }
    return ret;
}
    public static int indexOf(byte[] array, byte key){
    
        for (int i=0;i<array.length;i++){
//            System.out.println("array["+i+"]:"+Integer.toBinaryString(array[i])+" key: "+Integer.toBinaryString(key));
            if (key==array[i])
                return i;
        }
        return -1;
    }
    
    public static byte[] stringToBytesUTFCustom(String str) {
    	    	 char[] buffer = str.toCharArray();
    	 byte[] b = new byte[buffer.length << 1];
    	 for(int i = 0; i < buffer.length; i++) {
    	  int bpos = i << 1;
    	  b[bpos] = (byte) ((buffer[i]&0xFF00)>>8);
    	  b[bpos + 1] = (byte) (buffer[i]&0x00FF);
    	 }
    	 return b;
    	}
    
    
    public static String bytesToStringUTFCustom(byte[] bytes) {
    	 char[] buffer = new char[bytes.length >> 1];
    	 for(int i = 0; i < buffer.length; i++) {
    	  int bpos = i << 1;
    	  char c = (char)(((bytes[bpos]&0x00FF)<<8) + (bytes[bpos+1]&0x00FF));
    	  buffer[i] = c;
    	 }
    	 return new String(buffer);
    	}

    

}
