package pl.wiktordolecki;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static pl.wiktordolecki.Excercise03.printFibonacciSequence;

import org.junit.Test;

public class Excercise03Test {

    @Test
    public void fibo10() throws Exception {
        assertThat(printFibonacciSequence(10), is("(1):1	(2):1	(3):2	(4):3	(5):5	(6):8	(7):13	(8):21	(9):34	(10):55	"));
    }


}