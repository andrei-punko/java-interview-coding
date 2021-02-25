package by.andd3dfx.java8.predicates;

import org.junit.Test;

import java.util.Objects;
import java.util.function.Predicate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PredicatesTest {

    @Test
    public void lengthPredicateTest() {
        Predicate<String> predicate = (s) -> s.length() > 0;
        assertThat("True expected", predicate.test("foo"), is(true));
        assertThat("False expected", predicate.negate().test("foo"), is(false));
    }

    @Test
    public void nonNullPredicateTest() {
        Predicate<Boolean> nonNull = Objects::nonNull;
        assertThat("True expected", nonNull.test(Boolean.TRUE), is(true));
        assertThat("False expected", nonNull.test(null), is(false));
    }

    @Test
    public void isNullPredicateTest() {
        Predicate<Boolean> isNull = Objects::isNull;
        assertThat("True expected", isNull.test(null), is(true));
        assertThat("False expected", isNull.test(Boolean.TRUE), is(false));
    }

    @Test
    public void isEmptyPredicateTest() {
        Predicate<String> isEmpty = String::isEmpty;
        assertThat("True expected", isEmpty.test(""), is(true));
        assertThat("False expected", isEmpty.test("Something"), is(false));
    }

    @Test
    public void isNotEmptyPredicateTest() {
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
        assertThat("True expected", isNotEmpty.test("Something"), is(true));
        assertThat("False expected", isNotEmpty.test(""), is(false));
    }
}
