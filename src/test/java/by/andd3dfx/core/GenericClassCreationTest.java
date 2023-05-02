package by.andd3dfx.core;

import by.andd3dfx.core.GenericClassCreation.CreatorUsingDeclaredConstructor;
import by.andd3dfx.core.GenericClassCreation.CreatorUsingSupplier;
import lombok.AllArgsConstructor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThrows;

public class GenericClassCreationTest {

    @Test
    public void createStringBy_CreatorUsingDeclaredConstructor() {
        CreatorUsingDeclaredConstructor<String> container = new CreatorUsingDeclaredConstructor<>();

        assertThat(container.createObject(String.class), is(""));
    }

    @Test
    public void createStringBy_CreatorUsingSupplier() {
        CreatorUsingSupplier<String> container = new CreatorUsingSupplier<>(String::new);

        assertThat(container.createObject(), is(""));
    }

    @Test
    public void createClassWithoutFieldsBy_CreatorUsingDeclaredConstructor() {
        CreatorUsingDeclaredConstructor<CustomClassWithoutFields> container = new CreatorUsingDeclaredConstructor<>();

        assertThat(container.createObject(CustomClassWithoutFields.class), instanceOf(CustomClassWithoutFields.class));
    }

    @Test
    public void createClassWithoutFieldsBy_CreatorUsingSupplier() {
        CreatorUsingSupplier<CustomClassWithoutFields> container = new CreatorUsingSupplier<>(CustomClassWithoutFields::new);

        assertThat(container.createObject(), instanceOf(CustomClassWithoutFields.class));
    }

    @Test
    public void createClassWithFieldBy_CreatorUsingDeclaredConstructor() {
        CreatorUsingDeclaredConstructor<CustomClassWithField> container = new CreatorUsingDeclaredConstructor<>();

        assertThrows(NoSuchMethodException.class, () -> {
            container.createObject(CustomClassWithField.class);
        });
    }

    @Test
    public void createClassWithFieldBy_CreatorUsingSupplier() {
        CreatorUsingSupplier<CustomClassWithField> container = new CreatorUsingSupplier<>(() -> new CustomClassWithField(0));

        assertThat(container.createObject(), instanceOf(CustomClassWithField.class));
    }

    public static class CustomClassWithoutFields {
    }

    @AllArgsConstructor
    public static class CustomClassWithField {
        private int value;
    }
}
