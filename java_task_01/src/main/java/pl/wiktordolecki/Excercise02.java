package pl.wiktordolecki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Using given bellow restricted list API write function that creates NEW
 * Reversed list from input list. Original list should not be altered.
 *
 * Limit used list operations only to given: head, tail, cons and isEmpty() of
 * java.util.List
 *
 * 1. using recursion 2. without using recursion
 */
public class Excercise02<T> {

	/**
	 * First element of a list
	 */
	public static <T> T head(List<T> list) {
		if (list.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return list.get(0);
		}
	}

	/**
	 * All elements of a list except first
	 */
	public static <T> List<T> tail(List<T> list) {
		if (list.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return list.subList(1, list.size());
		}
	}

	/**
	 * Construct new list from element and given tail
	 */
	public static <T> List<T> cons(T elem, List<T> tail) {

		/*
		 * Robson Martins's comments When it's used List<T> list = asList(elem);
		 * list.addAll(tail) java.lang.UnsupportedOperationException is thrown
		 * Not every List implementation supports the add() method;
		 * Arrays.asList() not support any structural modification
		 */
		List<T> list = new ArrayList<T>();
		list.addAll(tail);
		list.add(elem);

		return list;
	}

	/**
	 * Recursive implementation of list reversing
	 *
	 * @param list
	 *            List to be reverted
	 * @param <T>
	 *            list type
	 * @return Reverted contents of input list
	 */
	public static <T> List<T> reverseRecursive(List<T> list) {
		if (list.isEmpty())
			return list;

		return cons(head(list), reverseRecursive(tail(list)));
	}

	/**
	 * Non-Recursive implementation of list reversing
	 *
	 * @param list
	 *            List to be reverted
	 * @param <T>
	 *            list type
	 * @return Reverted contents of input list
	 */
	public static <T> List<T> reverseNonRecursive(List<T> list) {
		// Collections.reverse(list);

		if (list.isEmpty())
			return Collections.emptyList();

		T head = head(list);
		List<T> newListReturn = new ArrayList<T>();
		List<T> tailList = cons(head, tail(list));
		int count = 0;
		while (true) {
			tailList = tail(tailList);
			if (tailList.isEmpty())
				break;
			count++;
		}

		T headLoop = null;
		for (int i = 0; i <= count; i++) {
			tailList = cons(head, tail(list));
			for (int x = count; x > 0; x--) {
				headLoop = head(tailList);
				tailList = tail(tailList);
				if (x == i) {
					newListReturn = cons(headLoop, newListReturn);
					break;
				}
			}
		}

		return cons(head, newListReturn);
	}
}
