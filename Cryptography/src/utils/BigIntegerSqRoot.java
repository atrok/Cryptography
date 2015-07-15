package utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BigIntegerSqRoot {

public static BigInteger bigIntSqRootFloor(BigInteger x)
        throws IllegalArgumentException {
    if (x.compareTo(BigInteger.ZERO) < 0) {
        throw new IllegalArgumentException("Negative argument.");
    }
    // square roots of 0 and 1 are trivial and
    // y == 0 will cause a divide-by-zero exception
    if (x .equals(BigInteger.ZERO) || x.equals(BigInteger.ONE)) {
        return x;
    } // end if
    BigInteger two = BigInteger.valueOf(2L);
    BigInteger y;
    // starting with y = x / 2 avoids magnitude issues with x squared
    for (y = x.divide(two);
            y.compareTo(x.divide(y)) > 0;
            y = ((x.divide(y)).add(y)).divide(two));
    return y;
} // end bigIntSqRootFloor

public static BigInteger bigIntSqRootCeil(BigInteger x)
        throws IllegalArgumentException {
    if (x.compareTo(BigInteger.ZERO) < 0) {
        throw new IllegalArgumentException("Negative argument.");
    }
    // square roots of 0 and 1 are trivial and
    // y == 0 will cause a divide-by-zero exception
    if (x == BigInteger.ZERO || x == BigInteger.ONE) {
        return x;
    } // end if
    BigInteger two = BigInteger.valueOf(2L);
    BigInteger y;
    // starting with y = x / 2 avoids magnitude issues with x squared
    for (y = x.divide(two);
            y.compareTo(x.divide(y)) > 0;
            y = ((x.divide(y)).add(y)).divide(two));
    if (x.compareTo(y.multiply(y)) == 0) {
        return y;
    } else {
        return y.add(BigInteger.ONE);
    }
} // end bigIntSqRootCeil

public static BigInteger sqrt(BigInteger x) {// taken from here http://stackoverflow.com/questions/4407839/how-can-i-find-the-square-root-of-a-java-biginteger
    BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
    BigInteger div2 = div;
    // Loop until we hit the same value twice in a row, or wind
    // up alternating.
    for(;;) {
        BigInteger y = div.add(x.divide(div)).shiftRight(1);
        if (y.equals(div) || y.equals(div2))
            return y;
        div2 = div;
        div = y;
    }
}

public static BigInteger sqrtN(BigInteger in) {
    final BigInteger TWO = BigInteger.valueOf(2);
    int c;

    // Significantly speed-up algorithm by proper select of initial approximation
    // As square root has 2 times less digits as original value
    // we can start with 2^(length of N1 / 2)
    BigInteger n0 = TWO.pow(in.bitLength() / 2);
    // Value of approximate value on previous step
    BigInteger np = in;

    do {
        // next approximation step: n0 = (n0 + in/n0) / 2
        n0 = n0.add(in.divide(n0)).divide(TWO);

        // compare current approximation with previous step
        c = np.compareTo(n0);

        // save value as previous approximation
        np = n0;

        // finish when previous step is equal to current
    }  while (c != 0);

    return n0;
}

public static BigDecimal sqrtDecimal(BigDecimal in, int scale){
    BigDecimal sqrt = new BigDecimal(1);
    sqrt.setScale(scale + 3, RoundingMode.FLOOR);
    BigDecimal store = new BigDecimal(in.toString());
    boolean first = true;
    do{
        if (!first){
            store = new BigDecimal(sqrt.toString());
        }
        else first = false;
        store.setScale(scale + 3, RoundingMode.FLOOR);
        sqrt = in.divide(store, scale + 3, RoundingMode.FLOOR).add(store).divide(
                BigDecimal.valueOf(2), scale + 3, RoundingMode.FLOOR);
    }while (!store.equals(sqrt));
    return sqrt.setScale(scale, RoundingMode.FLOOR);
}
} // end class bigIntSqRoot