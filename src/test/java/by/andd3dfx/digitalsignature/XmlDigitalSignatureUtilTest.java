package by.andd3dfx.digitalsignature;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class XmlDigitalSignatureUtilTest {

    private XmlDigitalSignatureUtil xmlDigitalSignatureUtil;

    @Before
    public void setup() {
        xmlDigitalSignatureUtil = new XmlDigitalSignatureUtil();
    }

    @Test
    public void signXmlFileAndValidateSignature() throws Exception {
        xmlDigitalSignatureUtil.signXmlFile("target/test-classes/file-to-sign.xml", "target/signed-file.xml");

        assertThat("Validation should passed", xmlDigitalSignatureUtil.validateXmlSignature("target/signed-file.xml"), is(true));
    }
}
