package by.andd3dfx.common;

import org.junit.jupiter.api.Test;

import static by.andd3dfx.common.BracketsExpressionValidator.validate;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BracketsExpressionValidatorTest {

    @Test
    public void testValidate() {
        assertTrue(validate("()"));
        assertTrue(validate("([{}])"));
        assertTrue(validate("()[]{}<>"));
        assertTrue(validate("([()<[]>]<{}(())>)"));

        assertFalse(validate("><"));
        assertFalse(validate("(][)"));
        assertFalse(validate(")"));
        assertFalse(validate("{})"));
        assertFalse(validate("([]"));
        assertFalse(validate("([)]"));
        assertFalse(validate("([)()<}{(){>]"));
    }
}
