package NumbersTheoryApplications;
import java.math.BigInteger;
import java.util.Hashtable;

public class DiscreteModuloPrimeFast {


			        public static final BigInteger p = new BigInteger(
			                        "13407807929942597099574024998205846127479365820592393377723561443721764030073546976801874298166903427690031858186486050853753882811946569946433649006084171");
			        public static final BigInteger g = new BigInteger(
			                        "11717829880366207009516117596335367088558084999998952205599979459063929499736583746670572176471460312928594829675428279466566527115212748467589894601965568");
			        public static final BigInteger h = new BigInteger(
			                        "3239475104050450443565264378728065788649097520952449527834792452971981976143292558073856937958553180532878928001494706097394108577585732452307673444020333");
			        public static final int capitalB = 1048576;
			        public static final BigInteger B = new BigInteger("1048576");
			        public static final BigInteger gPowerB = g.modPow(B, p);
			        public static final BigInteger gInverse = g.modInverse(p);
			        public static BigInteger x0;
			        public static BigInteger x1;
			        public static BigInteger x;
			        public static final Hashtable<BigInteger, Integer> leftSide = new Hashtable<BigInteger, Integer>();

			        public static void calculateDiscreteModuloPrimeFast() {
			                long start = System.currentTimeMillis();

			                // build hashtable
			                for (int i = 0; i <= capitalB; i++) {

			                        // TODO: compute h/g^i
			                        BigInteger key = h.multiply(
			                                        gInverse.modPow(new BigInteger(String.valueOf(i)), p)).mod(p);

			                        // put in Hashtable
			                        leftSide.put(key, i);
			                }

			                long hashtableDone = System.currentTimeMillis();

			                for (int j = 0; j <= capitalB; j++) {

			                        // compute gPowerB^j
			                        BigInteger key = gPowerB.modPow(new BigInteger(String.valueOf(j)),p);
			                        // lookup
			                        if (leftSide.containsKey(key)) {
			                                x0 = new BigInteger(String.valueOf(j));
			                                x1 = new BigInteger(String.valueOf(leftSide.get(
			key)));
			                                System.out.println("GOT IT");
			                                break;
			                        }

			                }

			                x = x0.multiply(B).add(x1);

			                long stop = System.currentTimeMillis();
			                System.out.println("Hashtable build: " + (hashtableDone - start)

			                                / 1000.0 + " seconds");
			                System.out.println("Lookup: " + (stop - hashtableDone) / 1000.0
			                                + " seconds");
			                System.out.println("Total: " + (stop - start) / 1000.0 + " seconds");

			                System.out.println("x0:");
			                System.out.println(x0);
			                System.out.println("x1:");
			                System.out.println(x1);
			                System.out.println("x:");
			                System.out.println(x);
			        }

			

			
}
