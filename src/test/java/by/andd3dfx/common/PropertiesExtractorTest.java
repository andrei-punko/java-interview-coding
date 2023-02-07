package by.andd3dfx.common;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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

    public static class Person {

        private String name;
        private Card card;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Card getCard() {
            return card;
        }

        public void setCard(Card card) {
            this.card = card;
        }
    }

    public static class Card {

        private String vendor;
        private String number;

        public Card(String vendor, String number) {
            this.vendor = vendor;
            this.number = number;
        }

        public String getVendor() {
            return vendor;
        }

        public String getNumber() {
            return number;
        }
    }
}
