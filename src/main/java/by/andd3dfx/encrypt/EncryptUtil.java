package by.andd3dfx.encrypt;

import org.jasypt.util.text.BasicTextEncryptor;

public final class EncryptUtil {

    private static BasicTextEncryptor encryptor = new BasicTextEncryptor();

    static {
        // define secret cipher
        encryptor.setPassword("determined");
    }

    public static String encrypt(String plainText) {
        return encryptor.encrypt(plainText);
    }

    public static String decrypt(String encryptedString) {
        return encryptor.decrypt(encryptedString);
    }

    private EncryptUtil() {

    }
}
