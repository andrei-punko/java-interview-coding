package by.andd3dfx.digitalsignature;

import org.junit.Before;
import org.junit.Test;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DigitalSignatureUtilTest {

    DigitalSignatureUtil digitalSignatureUtil;

    @Before
    public void setup() {
        digitalSignatureUtil = new DigitalSignatureUtil();
    }

    @Test
    public void verifyStringSigning() throws Exception {

        KeyPair keyPair = digitalSignatureUtil.generateKeysPair("EC", 256);
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        String stringToSign = "This is string to sign";
        byte[] signature = digitalSignatureUtil.signString("SHA256withECDSA", privateKey, stringToSign);
        boolean result = digitalSignatureUtil.verifyStringSignature("SHA256withECDSA", publicKey, stringToSign, signature);

        assertThat("Valid signature expected", result, is(true));
    }

    @Test
    public void verifyFileSigning() throws Exception {
        KeyPair keyPair = digitalSignatureUtil.generateKeysPair("EC", 256);
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        String nameOfFileToSign = "target/test-classes/file-to-sign.xml";
        byte[] signature = digitalSignatureUtil.signFile("SHA256withECDSA", privateKey, nameOfFileToSign);
        boolean result = digitalSignatureUtil.verifyFileSignature("SHA256withECDSA", publicKey, nameOfFileToSign, signature);

        assertThat("Valid signature expected", result, is(true));
    }
}
