package by.andd3dfx.java8.linkstomethodsandconstructors;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonFactoryTest {

    @Test
    public void testPersonCreation() {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");

        assertThat(person).isInstanceOf(Person.class);
        assertThat(person.getFirstName()).isEqualTo("Peter");
        assertThat(person.getLastName()).isEqualTo("Parker");
    }
}
