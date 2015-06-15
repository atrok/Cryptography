package NumbersTheoryApplications;

import java.math.BigInteger;

import utils.BigIntegerSqRoot;

abstract public class PrimeFactoring {
	
	BigInteger N;
	BigInteger x;
	BigInteger A;
	BigInteger[] result=new BigInteger[]{BigInteger.ONE,BigInteger.ONE};
	
	public PrimeFactoring(String N){
			
		this.N=new BigInteger(N);
		
	}

	private void factor(BigInteger A){
			
			this.A=A;
			x=getX();
			
	//		BigInteger[] result=new BigInteger[2];
			populatePQ();

	}
	
	private boolean checkResult(){
		
		if (result[0].multiply(result[1]).equals(N))
			return true;
		return false;

	}
	
	public void populatePQ(){
		result[0]=A.add(x);
		result[1]=A.subtract(x);
	}
	
	public BigInteger[] getPrimes(){
		BigInteger i=new BigInteger("0");
		while (!checkResult()&!N.equals(i)){
			i.add(BigInteger.ONE);
			factor(getA());
		}
		if (i.equals(N))
			return null;
		
		return result;
			
	}
	abstract public BigInteger getA();
	abstract public BigInteger getX();
	
}


