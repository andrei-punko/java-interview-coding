package by.andd3dfx.string;

import org.junit.Test;

import static by.andd3dfx.string.StringTransformation.couldTransform;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTransformationTest {

    @Test
    public void couldTransform_changeOneChar() {
        assertThat(couldTransform("a", "b")).isTrue();      // change one char, 1-char string
        assertThat(couldTransform("a1b", "c1b")).isTrue();  // change one (first) char
        assertThat(couldTransform("a1b", "a1d")).isTrue();  // change one (last) char
    }

    @Test
    public void couldTransform_removeOneChar() {
        assertThat(couldTransform("abcd", "bcd")).isTrue(); // remove one (first) char
        assertThat(couldTransform("abcd", "acd")).isTrue(); // remove one (inner) char
        assertThat(couldTransform("abcd", "abc")).isTrue(); // remove one (last) char
    }

    @Test
    public void couldTransform_addOneChar() {
        assertThat(couldTransform("bcd", "abcd")).isTrue(); // add one (first) char
        assertThat(couldTransform("abd", "abcd")).isTrue(); // add one (inner) char
        assertThat(couldTransform("abc", "abcd")).isTrue(); // add one (last) char
    }

    @Test
    public void couldTransform_significantlyDifferentLengths() {
        assertThat(couldTransform("abcd", "ab")).isFalse();
        assertThat(couldTransform("bc", "abcd")).isFalse();
    }

    @Test
    public void couldTransform_transformIsNotPossible() {
        assertThat(couldTransform("ab", "ba")).isFalse();       // same lengths
        assertThat(couldTransform("abcde", "abdm")).isFalse();  // different lengths
        assertThat(couldTransform("abdm", "abcde")).isFalse();  // different lengths
    }
}