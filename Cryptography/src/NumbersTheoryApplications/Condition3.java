package NumbersTheoryApplications;

import java.math.BigInteger;

import utils.BigIntegerSqRoot;

public class Condition3 extends PrimeFactoring{

	BigInteger a=BigInteger.ONE;
	BigInteger sixN;
	BigInteger x=BigInteger.ZERO;
	public Condition3(String N) {
		super(N);
		sixN=this.N.multiply(new BigInteger("6"));
		
		// TODO Auto-generated constructor stub
	}
	
	public BigInteger getA(){
		return a=BigIntegerSqRoot.bigIntSqRootCeil(sixN);
	}
	
	public BigInteger getX(){
		return x=BigIntegerSqRoot.sqrt(a.pow(2).subtract(N));
	}
	
	public void populatePQ(){
		if (A.subtract(x).multiply(A.add(x).add(BigInteger.ONE)).equals(sixN)){
			System.out.println("Gotcha!");
			result[0]=A.subtract(x).divide(new BigInteger("3"));
			result[1]=A.add(x).add(BigInteger.ONE).divide(new BigInteger("2"));
		}
		
	}

}