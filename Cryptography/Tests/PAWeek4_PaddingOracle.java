import static org.junit.Assert.*;

import org.junit.Test;

import paddingOracleAttack.HttpCodes;
import paddingOracleAttack.HttpRequestor;
import paddingOracleAttack.PaddingOracle;
import xordecryption.NormalizedString;


public class PAWeek4_PaddingOracle {

	@Test
	public void testHttpRequestor() {
		
		if(HttpCodes.check(Integer.parseInt(HttpRequestor.execute("http://crypto-class.appspot.com/po?er=f20bdba6ff29eed7b046d1df9fb7000058b1ffb4210a580f748b4ac714c001bd4a61044426fb515dad3f21f18aa577c0bdf302936266926ff37dbf7035d5eeb1", null)))== -1)
			fail();
	}

	@Test
	public void testPaddingOracle() {
		
		PaddingOracle po=new PaddingOracle("http://crypto-class.appspot.com/po?er=","f20bdba6ff29eed7b046d1df9fb7000058b1ffb4210a580f748b4ac714c001bd4a61044426fb515dad3f21f18aa577c0bdf302936266926ff37dbf7035d5eeb4");
	}
}
