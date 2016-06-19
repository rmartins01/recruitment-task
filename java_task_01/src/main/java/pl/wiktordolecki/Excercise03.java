package pl.wiktordolecki;

import java.math.BigInteger;

/**
 * Fibonnaci sequence is given by recursive relation
 *
 * F[n+2] = F[n+1] + F[n]
 * with
 * F[0] = 0
 * F[1] = 1
 *
 * Implement function returning n-th element of Fibonnaci Sequence.
 *
 * 1. Implementation working in O(n) memory and time
 *
 * 2. Bonus task - Can you make it to have performance should be in O(log n) memory and time?
 */
public class Excercise03 {

	/**
	 * This is a clever algorithm for computing the Fibonacci numbers in a
	 * logarithmic number of steps ... This exercise was suggested by Joe
	 * Stoy, based on an example in Kaldewaij, Anne. 1990. Programming: The
	 * Derivation of Algorithms.
	 * 
	 * reference: http://aaron.niskin.org/book/sicp/index.html
	 * excercise: 1.19
	 */
	public static BigInteger fibonnaci(int n) {

		int count = n;
		BigInteger tmpA, tmpP;
		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ZERO;
		BigInteger p = BigInteger.ZERO;
		BigInteger q = BigInteger.ONE;
		BigInteger two = new BigInteger("2");

		while (count != 0) {

			if ((count & 1) == 0) {
				tmpP = p.multiply(p).add(q.multiply(q));
				q = two.multiply(p.multiply(q)).add(q.multiply(q));
				p = tmpP;
				count >>= 1;
			} else {
				tmpA = b.multiply(q).add(a.multiply(q).add(a.multiply(p)));
				b = b.multiply(p).add(a.multiply(q));
				a = tmpA;
				count--;
			}
		}

		return b;
	}

	public static String printFibonacciSequence(int n){
		StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append("(" + i + "):" + fibonnaci(i) + "\t");
        }
        return sb.toString();
	}

}
