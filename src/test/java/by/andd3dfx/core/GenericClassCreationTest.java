package by.andd3dfx.core;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import by.andd3dfx.core.GenericClassCreation.SomeContainer1;
import by.andd3dfx.core.GenericClassCreation.SomeContainer2;
import java.lang.reflect.InvocationTargetException;
import org.junit.Test;

public class GenericClassCreationTest {

    @Test
    public void createObject1()
        throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        SomeContainer1<String> someContainer1 = new SomeContainer1<>();

        String createdObject = someContainer1.createObject(String.class);

        assertThat("Empty string expected", createdObject, is(""));
    }

    @Test
    public void createObject2() {
        SomeContainer2<String> someContainer2 = new SomeContainer2<>(String::new);

        String createdObject = someContainer2.createObject();

        assertThat("Empty string expected", createdObject, is(""));
    }
}
