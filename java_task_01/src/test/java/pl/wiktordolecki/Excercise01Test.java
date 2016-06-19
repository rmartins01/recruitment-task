package pl.wiktordolecki;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static pl.wiktordolecki.Excercise01.divisibleBy3OR5;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * Examples of expected behavior
 */
public class Excercise01Test
{
    @Test
    public void emptyList() {
        List<Integer> integers = divisibleBy3OR5(1);
        assertThat(integers, is(Collections.<Integer>emptyList()));
    }

    @Test
    public void listForN3() {
        List<Integer> integers = divisibleBy3OR5(3);
        assertThat(integers, contains(3));
    }

    @Test
    public void listForN5() {
        List<Integer> integers = divisibleBy3OR5(5);
        assertThat(integers, contains(3,5));
    }


    @Test
    public void listForN6() {
        List<Integer> integers = divisibleBy3OR5(6);
        assertThat(integers, contains(3,5,6));
    }

    @Test
    public void listForN23() {
    	List<Integer> integers = divisibleBy3OR5(23);
    	assertThat(integers, contains(3, 5, 6, 9, 10, 12, 15, 18, 20, 21));
    }

    @Test
    public void listForN150() {
    	List<Integer> integers = divisibleBy3OR5(150);
    	assertThat(integers, contains(3, 5, 6, 9, 10, 12, 15, 18, 20, 21, 24, 25, 27, 30, 33, 35, 36, 39, 40, 42, 45, 48, 50, 51, 54, 55, 57, 60, 63, 65, 66, 69, 70, 72, 75, 78, 80, 81, 84, 85, 87, 90, 93, 95, 96, 99, 100, 102, 105, 108, 110, 111, 114, 115, 117, 120, 123, 125, 126, 129, 130, 132, 135, 138, 140, 141, 144, 145, 147, 150));
    }

    @Test
    public void listForNNegative() {
    	List<Integer> integers = divisibleBy3OR5(-3);
    	assertThat(integers, hasSize(0));
    }
    
}
