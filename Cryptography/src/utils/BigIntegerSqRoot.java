package utils;

import java.math.BigInteger;

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

} // end class bigIntSqRoot