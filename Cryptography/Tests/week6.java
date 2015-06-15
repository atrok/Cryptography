import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.Test;

import NumbersTheoryApplications.Condition1;
import NumbersTheoryApplications.Condition2;
import NumbersTheoryApplications.Condition3;
import NumbersTheoryApplications.PrimeFactoring;
import NumbersTheoryApplications.PrimeFactoring.*;
import utils.BigIntegerSqRoot;


public class week6 {
	
	@Test
	public void testNUms(){
		
	String n="179769313486231590772930519078902473361797697894230657273430081157732675805505620686985379449212982959585501387537164015710139858647833778606925583497541085196591615128057575940752635007475935288710823649949940771895617054361149474865046711015101563940680527540071584560878577663743040086340742855278549092581";
	BigInteger N=new BigInteger(n);
	
	BigInteger A=BigIntegerSqRoot.bigIntSqRootFloor(N);
	System.out.println("A:"+A.toString());
	
	
	}
	
	@Test
	public void test1(){
		String n="179769313486231590772930519078902473361797697894230657273430081157732675805505620686985379449212982959585501387537164015710139858647833778606925583497541085196591615128057575940752635007475935288710823649949940771895617054361149474865046711015101563940680527540071584560878577663743040086340742855278549092581";
		PrimeFactoring p=new Condition1(n);
		System.out.println("---- test1 ----");
		testCondition(p,n);
	}

	@Test
	public void test3(){
		String n="72006226374735042527956443552558373833808445147399984182665305798196355690188337790423408664187663938485175264994017897083524079135686877441155132015188279331812309091996246361896836573643119174094961348524639707885238799396839230364676670221627018353299443241192173812729276147530748597302192751375739387929";
		PrimeFactoring p=new Condition3(n);
		System.out.println("---- test3 ----");
		testCondition(p,n);
	}
	public void testCondition(PrimeFactoring p, String n){

		BigInteger N=new BigInteger(n);
		
		
		
		BigInteger[] res=p.getPrimes();
		Arrays.sort(res);
		
		assertEquals(-1,res[0].compareTo(res[1]));
		
		assertEquals(N, res[0].multiply(res[1]));
		System.out.println("Prime factorization of N:"+N);
		System.out.println("p:"+res[0].toString());
		System.out.println("q:"+res[1].toString());
	}

	@Test
	public void test2(){
		String n="648455842808071669662824265346772278726343720706976263060439070378797308618081116462714015276061417569195587321840254520655424906719892428844841839353281972988531310511738648965962582821502504990264452100885281673303711142296421027840289307657458645233683357077834689715838646088239640236866252211790085787877";

		PrimeFactoring p=new Condition2(n);
		System.out.println("---- test2 ----");
		testCondition(p,n);
		
	}
}
