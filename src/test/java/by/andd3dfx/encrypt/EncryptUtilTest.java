package by.andd3dfx.encrypt;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class EncryptUtilTest {

    @Test
    public void encryptAndDecrypt() {
        final String initialString = "SomeString";
        final String encryptedString = EncryptUtil.encrypt(initialString);
        final String decryptedString = EncryptUtil.decrypt(encryptedString);

        assertThat("Encrypted string should be differ from initial string",
            encryptedString, is(not(initialString)));

        assertThat("Decrypted string should be the same as initial string",
            decryptedString, is(initialString));
    }
}
