package by.andd3dfx.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInputTest {

    @Test
    public void testTextInput() {
        UserInput.TextInput input = new UserInput.TextInput();
        input.add('1');
        input.add('a');
        input.add('0');

        assertThat(input.getValue()).isEqualTo("1a0");
    }

    @Test
    public void testNumericInput() {
        UserInput.TextInput input = new UserInput.NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');

        assertThat(input.getValue()).isEqualTo("10");
    }
}
