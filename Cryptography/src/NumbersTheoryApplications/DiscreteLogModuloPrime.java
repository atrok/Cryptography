package NumbersTheoryApplications;

import java.math.BigInteger;
import java.math.BigInteger.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;



public class DiscreteLogModuloPrime {

	int B=0;
	BigInteger p,g,h;

	HashMap<BigInteger,Integer> hashTable=new HashMap<BigInteger,Integer>();

	public DiscreteLogModuloPrime(int B, String p, String g, String h){
		this.B=B;

		this.p=new BigInteger(p);
		this.g=new BigInteger(g);
		this.h=new BigInteger(h);

		calculateHashTable();
		System.out.println(lookup().toString());
	}

	private void calculateHashTable(){

		System.out.println("HashTable calculation starts");
		long start=System.currentTimeMillis();
		BigInteger x0=h;
		
			
			BigInteger gI=g.modInverse(p);

			for (int i=0;i<B;i++){
				//long start1=System.nanoTime();
				
				hashTable.put(x0,i);
				x0=x0.multiply(gI).mod(p);
				//System.out.println("calculation took:"+TimeUnit.SECONDS.convert((System.nanoTime()-start), TimeUnit.NANOSECONDS));
			}
		System.out.println("HashTable calculation ends in:"+(System.currentTimeMillis()-start));

	}

	private BigInteger lookup(){
		System.out.println("lookup starts");
		long start=System.currentTimeMillis();
		BigInteger result=BigInteger.ONE;

		BigInteger BB=new BigInteger(Integer.toString(B));
		BigInteger gBN=g.modPow(BB, p);
		
		for (int i=0;i<B;i++){

			Integer x1=hashTable.get(result);

			if(x1!=null){
				System.out.println("lookup succesfully ends in:"+(System.currentTimeMillis()-start));
				System.out.println("x0="+i+" x1="+x1);
				return new BigInteger(Integer.toString(i)).multiply(BB).add(new BigInteger(Integer.toString(x1)));
			}
			
			result=gBN.multiply(result).mod(p);
			
		}

		System.out.println("lookup with no results ends in:"+(System.currentTimeMillis()-start));
		return BigInteger.ZERO;
	}
}
