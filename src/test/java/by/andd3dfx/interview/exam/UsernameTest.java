package by.andd3dfx.interview.exam;

import org.junit.Test;

import static by.andd3dfx.interview.exam.Username.validate;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UsernameTest {

    @Test
    public void testValidate() {
        assertTrue("Valid name", validate("Mike-Standish"));
        assertTrue("Valid name with digits", validate("Mike-Standish78"));

        assertFalse("Invalid: start from digit", validate("4Mike-Standish"));
        assertFalse("Invalid: 2 hyphens", validate("Mike--Standish"));
        assertFalse("Invalid: too short", validate("Mike"));
        assertFalse("Invalid: too long", validate("Mike-sdfsdddvsdfsdfsdfsdcsd"));
        assertFalse("Invalid: contains space", validate("Mike Standish"));
        assertFalse("Invalid: `-` at the end", validate("MikeStandish-"));
    }
}