package by.andd3dfx.common;

import org.junit.Test;

import static by.andd3dfx.common.ValidAnagram.isAnagram;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidAnagramTest {

    @Test
    public void testIsAnagram() {
        assertTrue(isAnagram("anagram", "nagaram"));
        assertFalse(isAnagram("rat", "cat"));
        assertFalse(isAnagram("ab", "a"));
    }
}
