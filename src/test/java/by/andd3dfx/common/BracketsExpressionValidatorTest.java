package by.andd3dfx.common;

import org.junit.Test;

import static by.andd3dfx.common.BracketsExpressionValidator.validate;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        assertFalse(validate("([)]"));
        assertFalse(validate("([)()<}{(){>]"));
    }
}
