/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author atrok
 */
public class ArrayComparator implements Comparator<byte[]>{
    @Override
    public int compare(byte[] o1, byte[] o2) {  
      if (o1.length > o2.length) {
         return 1;
      } else if (o1.length < o2.length) {
         return -1;
      }
      return Arrays.toString(o1).compareTo(Arrays.toString(o2));
    }    
}
