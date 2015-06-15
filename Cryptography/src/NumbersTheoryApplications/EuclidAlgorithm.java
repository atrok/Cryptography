package NumbersTheoryApplications;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import paddingOracleAttack.HttpRequestor;

public class EuclidAlgorithm {

	public static Logger log=Logger.getLogger(HttpRequestor.class.getName());
	public static int gcd(int a, int b){
		int t;
		int aa=a,bb=b;

		/*
		if (a>b){
			aa=b;
			bb=a;
		}
		*/
		
		log.info("A="+aa+" B="+bb);
		
		int[] remainders=new int[bb];
		int i=0;
		while (bb!=0){
			remainders[i]=bb;
			t=bb;
			System.out.print(aa+" mod("+bb+")");
			bb= aa%bb;
			System.out.print("="+bb+"\n");
			aa=t;
			i++;
		
		}
		log.info(Arrays.toString(remainders));
		return aa;
	}
	
	public static int[] extendedEuclid(int A, int B){
		int r0=A, r1=B;
		if(A<B){
			r0=B;
			r1=A;
		}
		
		int s0=1,s1=0,t0=0,t1=1;
		int q=0,s=0,t=0;
		int r=1,rem;
		
		while(r1!=0){
			
			r=r1;
			System.out.print("r0/r1="+r0+"/"+r1);
			q=Math.round(r0/r1);
			System.out.println("="+q);
			rem=r0-q*r1;
			System.out.println("r0-q*r1="+r0+"-"+q+"*"+r1+"="+rem);
			r1=rem;
			r0=r;

			s=s1;
			System.out.print("s0-r1*s1="+s0+"-"+q+"*"+s1);
			s1=s0-q*s1;
			System.out.println("="+s1);
			s0=s;
			
			t=t1;
			System.out.print("t0-r1*t1="+t0+"-"+r1+"*"+t1);
			t1=t0-q*t1;
			System.out.println("="+t1);
			t0=t;	
		}
		
		return new int[]{r0,s1,t1};
	}
	
	public static int getInverse(int a,int N){
		// http://en.wikipedia.org/wiki/Extended_Euclidean_algorithm
		
		int t=0,newt=1;
		int r=N,newr=a;
		int quotient;
		while (newr!=0){
			quotient=Math.round(r/newr);
			newt=t-quotient*newt;t=newt; 
			
			newr=r-quotient*newr;r=newr; 
			
		}
		if (r>1){
			System.out.println("a is not invertible");
			return -1;
		}
		if (t<0) t=t+N;
		return t;
			
	}
	public static List getInvertibleSet(int a,int b){

		int aa=a,bb=b;

		if (a>b){
			aa=b;
			bb=a;
		}
		List inv=new ArrayList();
		for (int i=0;i<bb;i++)
		if (gcd(i,bb)==1) inv.add(i);
		
		return inv;
		
	}
	
	public static int EulerPhiFunction(int a,int b){
		
		return getInvertibleSet(a,b).toArray().length;
	}
	
	public static int phi(int n){
		
		//int n;  //this is the number you want to find the totient of
		int tot = n; //this will be the totient at the end of the sample
		for (int p = 2; p*p <= n; p++)
		{
		    if (n%p==0)
		    {
		        tot /= p;
		        tot *= (p-1);
		        while ( n % p == 0 ) 
		            n /= p;
		    }
		}
		if ( n > 1 ) { // now n is the largest prime divisor
		    tot /= n;
		    tot *= (n-1);
		}
		
		return tot;
	}
	
	public static BigInteger etfBig(BigInteger n) {

	    BigInteger result = n;
	    BigInteger i;

	    for(i = new BigInteger("2"); (i.multiply(i)).compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
	         if((n.mod(i)).compareTo(BigInteger.ZERO) == 0) 
	         result = result.divide(i);
	         while(n.mod(i).compareTo(BigInteger.ZERO)== 0 ) 
	             n = n.divide(i);
	     }      
	 if(n.compareTo(BigInteger.ONE) > 0)
	 result = result.subtract((result.divide(n)));
	 return result;
	}
	
	public static List getCyclicgroup(int x,int N){
		
		int i=0;
		
		ArrayList kk=new ArrayList();
		
		if (x<N){
		int mod;
		while(true){
			mod=(int) ((Math.pow(x, i))%N);
			if (mod==1&&i!=0)
				break;
			System.out.println("Math.pow("+x+","+i+"))%"+N+")="+mod);
			kk.add(mod);
			i++;
			
		}
		}
		System.out.println("Cyclic group "+x+" in Z"+N+" : "+kk.toString());
		return kk;
	}
	
	public static int getOrder(int x,int N){
		int n=getCyclicgroup(x,N).size();
		System.out.println("Order of "+x+" in Z"+N+" : "+n);
		return n;
	}
}
