
package pl.wiktordolecki;

import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Write a function that for an argument int n returns a list of positive
 * numbers lesser or equal to n which are divisible by 3 or 5. List should be
 * sorted in ascending order without repetitions. For value 0 and all negative
 * values of n return empty list.
 */
public class Excercise01 {
	/**
	 * Your solution should be implemented in this method. Corresponding test
	 * class contains few examples of correct input, output pairs.
	 *
	 * @param n
	 *            Nonegative integer for inclusive upper bound of list contents
	 * @return List object containing positive integers lesser or equal to n
	 *         that are divisible by 3 or 5
	 */
	public static List<Integer> divisibleBy3OR5(int n) {
		return divisibleBy(n, asList(3,5));
	}

	/**
	 * BONUS: List of divisors can be passed as additional parameter.
	 */
	public static List<Integer> divisibleBy(int n, List<Integer> divisors) {

		if (n < 1 || divisors == null || divisors.size() == 0) {
			return Collections.emptyList();
		}

		LinkedHashSet<Integer> list = new LinkedHashSet<Integer>();
		for (Integer i = 1; i <= n; i++) {
			for (Integer divisor : divisors) {
				if (i % divisor == 0) {
					list.add(i);
				}
			}
		}

		return new ArrayList<Integer>(list);
	}
}
