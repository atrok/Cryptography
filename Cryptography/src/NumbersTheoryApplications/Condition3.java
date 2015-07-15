package NumbersTheoryApplications;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

import utils.BigIntegerSqRoot;

public class Condition3 extends PrimeFactoring{

	BigInteger a=BigInteger.ONE;
	BigInteger sixN;
	BigInteger x=BigInteger.ZERO;
	double t;
	public Condition3(String N) {
		super(N);
		sixN=new BigInteger(N).multiply(new BigInteger("3")).divide(new BigInteger("2"));
		a=BigIntegerSqRoot.sqrtN(sixN);//(sixN,N.length()); //q
		//a=a.setScale(0, RoundingMode.CEILING);
		//x=BigIntegerSqRoot.sqrtDecimal((a.pow(2).subtract(sixN)).abs(), N.length());
		x=new BigInteger(N).divide(a);//.setScale(0,RoundingMode.CEILING); //p
		//x=x.setScale(0,RoundingMode.CEILING);
		t=(double) (1/(8*Math.sqrt(6)));
		// TODO Auto-generated constructor stub
	}
	
	public BigInteger getA(){
		return a;//.toBigInteger();
	}
	
	public BigInteger getX(){
		return x;//.toBigInteger();
	}
	
	public void populatePQ(){
		if (a.subtract(x).multiply(a.add(x).add(BigInteger.ONE)).equals(sixN))
			System.out.println("Gotcha!");
		BigInteger p;
		BigInteger q;
		//a=a.add(new BigDecimal(Double.toString(t)));
		//a=a.setScale(0, RoundingMode.FLOOR);
		//x=x.setScale(0,RoundingMode.FLOOR);
		p=a;
		q=x;
		result[0]=p;
		result[1]=q;
		
		System.out.println("A.pow2:"+a.pow(2).toString());
		System.out.println("sixN  :"+sixN.toString());		
		System.out.println("res[0]:"+p.toString());
		System.out.println("res[1]:"+q.toString());
		System.out.println("p*q   :"+p.multiply(q).toString());
		System.out.println("N     :"+N.toString());

	}

	@Override
	public boolean exitCondition() {
		if(result[0].multiply(result[1]).equals(N))
			return true;
		System.out.println("Prime Factoring failed");
		
		return true;
	}

}