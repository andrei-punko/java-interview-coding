package by.andd3dfx.java8.optional;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OptionalTest {

    @Test
    public void test() {
        Optional<String> optional = Optional.of("bam");

        assertThat("True expected", optional.isPresent(), is(true));
        assertThat("bam expected", optional.get(), is("bam"));
        assertThat("bam expected", optional.orElse("fallback"), is("bam"));

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
    }
}
