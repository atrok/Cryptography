package NumbersTheoryApplications;

import java.math.BigInteger;

import utils.BigIntegerSqRoot;

public class Condition2 extends PrimeFactoring{

	BigInteger a;
	public Condition2(String N) {
		super(N);
		a=BigIntegerSqRoot.bigIntSqRootCeil(this.N);
		// TODO Auto-generated constructor stub
	}
	
	public BigInteger getA(){
		return a=a.add(BigInteger.ONE);
	}
	
	public BigInteger getX(){
	return BigIntegerSqRoot.sqrt(A.pow(2).subtract(N));
	}
}
