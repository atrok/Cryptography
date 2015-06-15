import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.Test;

import paddingOracleAttack.HttpCodes;
import paddingOracleAttack.HttpRequestor;
import paddingOracleAttack.PaddingOracle;
import xordecryption.NormalizedString;
import NumbersTheoryApplications.DiscreteLogModuloPrime;
import NumbersTheoryApplications.DiscreteModuloPrimeFast;
import NumbersTheoryApplications.EuclidAlgorithm;


public class week5 {

	
	@Test
	public void testGCD(){
		
		assertEquals(2,EuclidAlgorithm.gcd(240, 46));
		assertEquals(1,EuclidAlgorithm.gcd(2, 35));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testInvertableSet(){
		System.out.println(EuclidAlgorithm.getInvertibleSet(1, 35).toString());
		assertEquals(24, EuclidAlgorithm.phi(35));
		
		
		Integer[] arr=new Integer[]{1,3,2,6,4,5};
		Integer[] cyc=(Integer[]) EuclidAlgorithm.getCyclicgroup(3, 7).toArray(new Integer[6]);
		assertEquals(arr,cyc);
		
		EuclidAlgorithm.getOrder(2,35);
		
		EuclidAlgorithm.getCyclicgroup(2,13);
		EuclidAlgorithm.getCyclicgroup(7,13);
		
		
	}
	
	@Test
	public void testExtendedEuclid(){
		int[] i=new int[]{2,23,-120};
		int[] res=EuclidAlgorithm.extendedEuclid(240,46);
		assertTrue(Arrays.equals(i, res));
		
	}
	
	@Test
	public void testInverse(){
		EuclidAlgorithm.gcd(7, 23);
		assertEquals(10,EuclidAlgorithm.getInverse(7, 23));
	}
	
	@Test
	public void testtDiscreteModulo(){
		

		int B=(int) Math.pow(2, 10);
		int B1=(int) Math.pow(2, 20);
		
		String p="1073676287";//
		String p1="13407807929942597099574024998205846127479365820592393377723561443721764030073546976801874298166903427690031858186486050853753882811946569946433649006084171"; 
		String g="1010343267";//
		String g1="11717829880366207009516117596335367088558084999998952205599979459063929499736583746670572176471460312928594829675428279466566527115212748467589894601965568";
		String h="857348958";//
		String h1="3239475104050450443565264378728065788649097520952449527834792452971981976143292558073856937958553180532878928001494706097394108577585732452307673444020333";
		
		BigInteger BB=new BigInteger(Integer.toString(B));
		BigInteger GG=new BigInteger(g);
		BigInteger n=BB.multiply(new BigInteger(Integer.toString(B-1))).mod(new BigInteger(p).subtract(BigInteger.ONE));
		BigInteger res=GG.modPow(n, new BigInteger(p));
		
		new DiscreteLogModuloPrime(B1,p1,g1,h1);
	}
	
	@Test
	public void testDiscreteModuloFast(){
		DiscreteModuloPrimeFast.calculateDiscreteModuloPrimeFast();
	}
}
