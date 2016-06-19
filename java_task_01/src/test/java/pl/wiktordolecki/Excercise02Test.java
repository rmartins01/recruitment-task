package pl.wiktordolecki;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.is;

import static pl.wiktordolecki.Excercise02.reverseRecursive;
import static pl.wiktordolecki.Excercise02.reverseNonRecursive;

import static pl.wiktordolecki.Excercise02.cons;
import static pl.wiktordolecki.Excercise02.head;
import static pl.wiktordolecki.Excercise02.tail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Excercise02Test {

    @Test
    public void headReturnsFirstElement() throws Exception {
        List<String> list = asList("head", "gives", "first", "element", "of", "a", "list");

        assertThat(head(list), is("head"));
    }

    @Test
    public void tailReturnsRemainingElements() throws Exception {
        List<String> list = asList("head", "gives", "first", "element", "of", "a", "list");

        assertThat(tail(list), contains("gives", "first", "element", "of", "a", "list"));
    }

    @Test
    public void tailOfOneElementListIsEmpty() throws Exception {
        List<String> list = asList("head");

        assertThat(tail(list), emptyCollectionOf(String.class));
    }

    @Test
    public void consCreatesCorrectList() throws Exception {
        String head = "head";
        List<String> tail = asList("added", "correctly", "to", "the", "list");

        List<String> result = cons(head, tail);

        assertThat(result, contains("added", "correctly", "to", "the", "list", "head"));
    }

    @Test
    public void reverseRecursiveTest() throws Exception {
    	
    	List<String> tail = new ArrayList<String>(asList("added", "correctly", "to", "the", "list"));
    	List<String> result = reverseRecursive(tail);
    	
    	assertThat(result, contains("list", "the", "to", "correctly", "added"));
    	assertThat(tail, contains("added", "correctly", "to", "the", "list"));
    }

    @Test
    public void reverseNonRecursiveTest() throws Exception {
    	
    	List<String> tail = new ArrayList<String>(asList("added", "correctly", "to", "the", "list"));
    	List<String> result = reverseNonRecursive(tail);
    	
    	assertThat(result, contains("list", "the", "to", "correctly", "added"));
    	assertThat(tail, contains("added", "correctly", "to", "the", "list"));
    }

}