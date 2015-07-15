package NumbersTheoryApplications;

import java.math.BigInteger;

import utils.BigIntegerSqRoot;

public class Condition1 extends PrimeFactoring{

	public Condition1(String N) {
		super(N);
		// TODO Auto-generated constructor stub
	}
	
	public BigInteger getA(){
		return BigIntegerSqRoot.bigIntSqRootCeil(N);
	}
	
	public BigInteger getX(){
		return BigIntegerSqRoot.sqrt(A.pow(2).subtract(N));
	}

	@Override
	public boolean exitCondition() {
		if(result[0].multiply(result[1]).equals(N))
			return true;
		return false;
	}
	
}
