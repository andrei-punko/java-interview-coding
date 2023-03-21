package by.andd3dfx.java8.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaTest {

    private Lambda lambda;

    @Before
    public void setUp() throws Exception {
        lambda = new Lambda();
    }

    @Test
    public void usualApproach() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        lambda.usualApproach(names);

        assertThat(names).isEqualTo(List.of("anna", "mike", "peter", "xenia"));
    }

    @Test
    public void lambda1() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        lambda.lambda1(names);

        assertThat(names).isEqualTo(List.of("anna", "mike", "peter", "xenia"));
    }

    @Test
    public void lambda2() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        lambda.lambda2(names);

        assertThat(names).isEqualTo(List.of("anna", "mike", "peter", "xenia"));
    }

    @Test
    public void lambda3() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        lambda.lambda3(names);

        assertThat(names).isEqualTo(List.of("anna", "mike", "peter", "xenia"));
    }
}
