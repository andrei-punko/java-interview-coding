package by.andd3dfx.digitalsignature;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class DigitalSignatureUtil {

    /**
     * According to documentation - https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#KeyPairGenerator
     * possible cases for algorithm are next: DiffieHellman, DSA, RSA, EC
     */
    public KeyPair generateKeysPair(String algorithm, int keysize) throws Exception {
        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance(algorithm);
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        keyGenerator.initialize(keysize, random);
        return keyGenerator.generateKeyPair();
    }

    /**
     * Store private & public keys from keys pair to files
     */
    public void storeKeysToFiles(KeyPair keyPair, String privateKeyFilename, String publicKeyFilename) throws IOException {
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        saveToFile(privateKeyFilename, privateKey.getEncoded());
        saveToFile(publicKeyFilename, publicKey.getEncoded());
    }

    private void saveToFile(String filename, byte[] data) throws IOException {
        FileOutputStream publicKeyFileOutputStream = new FileOutputStream(filename);
        publicKeyFileOutputStream.write(data);
        publicKeyFileOutputStream.close();
    }

    private byte[] loadFromFile(String filename) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        byte[] result = new byte[fileInputStream.available()];
        fileInputStream.read(result);
        fileInputStream.close();
        return result;
    }

    public PrivateKey loadPrivateKeyFromFile(String algorithm, String privateKeyFilename) throws Exception {
        byte[] encKey = loadFromFile(privateKeyFilename);
        PKCS8EncodedKeySpec encodedKeySpec = new PKCS8EncodedKeySpec(encKey);

        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        return keyFactory.generatePrivate(encodedKeySpec);
    }

    public PublicKey loadPublicKeyFromFile(String algorithm, String publicKeyFilename) throws Exception {
        byte[] encKey = loadFromFile(publicKeyFilename);
        X509EncodedKeySpec encodedKeySpec = new X509EncodedKeySpec(encKey);

        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        return keyFactory.generatePublic(encodedKeySpec);
    }

    /**
     * Sign string with definite algorithm and privateKey.
     * Usage: signString("SHA256withECDSA", privateKey, "Some string ...")
     */
    public byte[] signString(String algorithm, PrivateKey privateKey, String stringTiSign) throws Exception {
        Signature dsa = Signature.getInstance(algorithm);
        dsa.initSign(privateKey);

        byte[] strByte = stringTiSign.getBytes("UTF-8");
        dsa.update(strByte);

        return dsa.sign();
    }

    /**
     * Sign file with definite algorithm and privateKey.
     * Usage: signFile("SHA256withECDSA", privateKey, "d:/some-filename.txt")
     */
    public byte[] signFile(String algorithm, PrivateKey privateKey, String nameOfFileToSign) throws Exception {
        Signature dsa = Signature.getInstance(algorithm);
        dsa.initSign(privateKey);

        FileInputStream fis = new FileInputStream(nameOfFileToSign);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);
        byte[] buffer = new byte[1024];

        int len;
        while ((len = bufferedInputStream.read(buffer)) >= 0) {
            dsa.update(buffer, 0, len);
        }
        bufferedInputStream.close();
        return dsa.sign();
    }

    public String convertBytesArrayToString(byte[] signature) {
        return new BigInteger(1, signature).toString(16);
    }

    public boolean verifyStringSignature(String algorithm, PublicKey publicKey, String signedString, byte[] signature) throws Exception {
        Signature sig = Signature.getInstance(algorithm);
        sig.initVerify(publicKey);
        sig.update(signedString.getBytes("UTF-8"));
        return sig.verify(signature);
    }

    public boolean verifyFileSignature(String algorithm, PublicKey publicKey, String signedFileName, byte[] signatureToVerify) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(signedFileName);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        fileInputStream.close();

        Signature sig = Signature.getInstance(algorithm);
        sig.initVerify(publicKey);
        sig.update(bytes);
        return sig.verify(signatureToVerify);
    }
}
