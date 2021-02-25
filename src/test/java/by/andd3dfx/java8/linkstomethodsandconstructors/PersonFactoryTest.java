package by.andd3dfx.java8.linkstomethodsandconstructors;

import org.junit.Test;

public class PersonFactoryTest {

    @Test
    public void create() throws Exception {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
    }
}
