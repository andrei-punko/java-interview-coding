package by.andd3dfx.interview.goldmansachs;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class PropertiesExtractorTest {

    @Test
    public void extractForPlanObject() throws IllegalAccessException {
        Person person = new Person("Andrei");
        assertThat(PropertiesExtractor.extract(person), is("Andrei"));
    }

    @Test
    public void extractForComplexObject() throws IllegalAccessException {
        Person person = new Person("Andrei");
        person.setCard(new Card("VISA", "123546"));
        assertThat(PropertiesExtractor.extract(person), is("Andrei VISA 123546"));
    }
}
