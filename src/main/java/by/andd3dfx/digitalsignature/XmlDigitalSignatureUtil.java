package by.andd3dfx.digitalsignature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.crypto.*;
import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/guides/security/xmldsig/XMLDigitalSignature.html
 */
public class XmlDigitalSignatureUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(XmlDigitalSignatureUtil.class);

    public void signXmlFile(String fileToSignName, String resultFileName) throws Exception {

        // * Instantiating the Document to be Signed
        // First, we use a JAXP DocumentBuilderFactory to parse the XML document that we want to sign.
        // An application obtains the default implementation for DocumentBuilderFactory by calling the following line of code:
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        // We must also make the factory namespace-aware:
        dbf.setNamespaceAware(true);

        // Next, we use the factory to get an instance of a DocumentBuilder, which is used to parse the document:
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.parse(new FileInputStream(fileToSignName));

        // * Creating a Public Key Pair
        // We generate a public key pair. Later in the example, we will use the private key to generate
        // the signature. We create the key pair with a KeyPairGenerator.
        // In this example, we will create a DSA KeyPair with a length of 512 bytes :
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
        kpg.initialize(512);
        KeyPair kp = kpg.generateKeyPair();

        // In practice, the private key is usually previously generated and stored in a KeyStore file with an associated public key certificate.

        // * Creating a Signing Context
        // We create an XML Digital Signature XMLSignContext containing input parameters for generating
        // the signature. Since we are using DOM, we instantiate a DOMSignContext (a subclass of XMLSignContext),
        // and pass it two parameters, the private key that will be used to sign the document and the root of the document to be signed:
        DOMSignContext dsc = new DOMSignContext(kp.getPrivate(), doc.getDocumentElement());

        // * Assembling the XML Signature
        // We assemble the different parts of the Signature element into an XMLSignature object.
        // These objects are all created and assembled using an XMLSignatureFactory object.
        // An application obtains a DOM implementation of XMLSignatureFactory by calling the following line of code:
        XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

        // We then invoke various factory methods to create the different parts of the XMLSignature object as shown below.
        // We create a Reference object, passing to it the following:
        // - The URI of the object to be signed (We specify a URI of "", which implies the root of the document.)
        // - The DigestMethod (we use SHA1)
        // - A single Transform, the enveloped Transform, which is required for enveloped signatures so that the signature itself
        // is removed before calculating the signature value
        Reference ref = fac.newReference
                ("", fac.newDigestMethod(DigestMethod.SHA1, null),
                        Collections.singletonList
                                (fac.newTransform(Transform.ENVELOPED,
                                        (TransformParameterSpec) null)), null, null
                );

        // Next, we create the SignedInfo object, which is the object that is actually signed, as shown below.
        // When creating the SignedInfo, we pass as parameters:
        // - The CanonicalizationMethod (we use inclusive and preserve comments)
        // - The SignatureMethod (we use DSA)
        // - A list of References (in this case, only one)
        SignedInfo si = fac.newSignedInfo
                (fac.newCanonicalizationMethod
                                (CanonicalizationMethod.INCLUSIVE_WITH_COMMENTS,
                                        (C14NMethodParameterSpec) null),
                        fac.newSignatureMethod(SignatureMethod.DSA_SHA1, null),
                        Collections.singletonList(ref));

        // Next, we create the optional KeyInfo object, which contains information that enables the recipient
        // to find the key needed to validate the signature. In this example, we add a KeyValue object containing
        // the public key. To create KeyInfo and its various subtypes, we use a KeyInfoFactory object, which
        // can be obtained by invoking the getKeyInfoFactory method of the XMLSignatureFactory, as follows:
        KeyInfoFactory kif = fac.getKeyInfoFactory();

        // We then use the KeyInfoFactory to create the KeyValue object and add it to a KeyInfo object:
        KeyValue kv = kif.newKeyValue(kp.getPublic());
        KeyInfo ki = kif.newKeyInfo(Collections.singletonList(kv));

        // Finally, we create the XMLSignature object, passing as parameters the SignedInfo and KeyInfo objects that we created earlier:
        XMLSignature signature = fac.newXMLSignature(si, ki);

        // Notice that we haven't actually generated the signature yet; we'll do that in the next step.

        // * Generating the XML Signature
        // Now we are ready to generate the signature, which we do by invoking the sign method on the XMLSignature object, and pass it the signing context as follows:
        signature.sign(dsc);
        // The resulting document now contains a signature, which has been inserted as the last child element of the root element.

        // * Printing or Displaying the Resulting Document to file or a standard output
        outFileToStream(doc, new FileOutputStream(resultFileName));
        // outFileToStream(doc, System.out);
    }

    private void outFileToStream(Document doc, OutputStream os) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();
//        NodeList nodeList = doc.getElementsByTagName("Signature");
//        NodeList nodeList = doc.getElementsByTagNameNS(XMLSignature.XMLNS, "Signature");
//        trans.transform(new DOMSource(nodeList.item(0)), new StreamResult(os));
        trans.transform(new DOMSource(doc), new StreamResult(os));
    }

    // * Validating an XML Signature using JSR 105 API
    // The example uses DOM to parse an XML document containing a Signature element and a JSR 105 DOM implementation to validate the signature.
    public boolean validateXmlSignature(String filename) throws Exception {

        // * Instantiating the Document that Contains the Signature
        // First we use a JAXP DocumentBuilderFactory to parse the XML document containing the Signature.
        // An application obtains the default implementation for DocumentBuilderFactory by calling the following line of code:
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        // We must also make the factory namespace-aware:
        dbf.setNamespaceAware(true);

        // Next, we use the factory to get an instance of a DocumentBuilder, which is used to parse the document:
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.parse(new FileInputStream(filename));

        // * Specifying the Signature Element to be Validated
        // We need to specify the Signature element that we want to validate, since there could be more than one in the document.
        // We use the DOM method Document.getElementsByTagNameNS, passing it the XML Signature namespace URI and the tag name of the Signature element, as shown:
        NodeList nl = doc.getElementsByTagNameNS(XMLSignature.XMLNS, "Signature");
        if (nl.getLength() == 0) {
            throw new Exception("Cannot find Signature element");
        }
        // This returns a list of all Signature elements in the document. In this example, there is only one Signature element.

        // * Creating a Validation Context
        // We create an XMLValidateContext instance containing input parameters for validating the signature.
        // Since we are using DOM, we instantiate a DOMValidateContext instance (a subclass of XMLValidateContext),
        // and pass it two parameters, a KeyValueKeySelector object and a reference to the Signature element
        // to be validated (which is the first entry of the NodeList we generated earlier):
        DOMValidateContext valContext = new DOMValidateContext(new KeyValueKeySelector(), nl.item(0));

        // * Unmarshaling the XML Signature
        // We extract the contents of the Signature element into an XMLSignature object. This process is called unmarshalling.
        // The Signature element is unmarshalled using an XMLSignatureFactory object. An application can obtain a DOM implementation
        // of XMLSignatureFactory by calling the following line of code:
        XMLSignatureFactory factory = XMLSignatureFactory.getInstance("DOM");

        // We then invoke the unmarshalXMLSignature method of the factory to unmarshal an XMLSignature object,
        // and pass it the validation context we created earlier:
        XMLSignature signature = factory.unmarshalXMLSignature(valContext);

        // * Validating the XML Signature
        // Now we are ready to validate the signature. We do this by invoking the validate method
        // on the XMLSignature object, and pass it the validation context as follows:
        boolean coreValidity = signature.validate(valContext);
        // The validate method returns "true" if the signature validates successfully according to the core validation rules
        // in the W3C XML Signature Recommendation, and false otherwise.

        // * What If the XML Signature Fails to Validate?
        // If the XMLSignature.validate method returns false, we can try to narrow down the cause of the failure. There are two phases in core XML Signature validation:
        // - Signature validation (the cryptographic verification of the signature)
        // - Reference validation (the verification of the digest of each reference in the signature)
        // Each phase must be successful for the signature to be valid. To check if the signature failed to cryptographically validate, we can check the status, as follows:

        // Check core validation status.
        if (coreValidity == false) {
            LOGGER.error("Signature failed core validation");
            boolean sv = signature.getSignatureValue().validate(valContext);
            LOGGER.info("signature validation status: " + sv);
            if (sv == false) {
                // Check the validation status of each Reference.
                Iterator i = signature.getSignedInfo().getReferences().iterator();
                for (int j = 0; i.hasNext(); j++) {
                    boolean refValid = ((Reference) i.next()).validate(valContext);
                    LOGGER.info("ref[" + j + "] validity status: " + refValid);
                }
            }
        } else {
            System.out.println("Signature passed core validation");
        }

        return coreValidity;
    }

    // * Using KeySelectors
    // KeySelectors are used to find and select keys that are needed to validate an XMLSignature.

    // Earlier, when we created a DOMValidateContext object, we passed a KeySelector object as the first argument:
    // DOMValidateContext valContext = new DOMValidateContext(new KeyValueKeySelector(), nl.item(0));

    // Alternatively, we could have passed a PublicKey as the first argument if we already knew what key is needed to validate the signature. However, we often don't know.
    // The KeyValueKeySelector is a concrete implementation of the abstract KeySelector class.
    // The KeyValueKeySelector implementation tries to find an appropriate validation key using the data
    // contained in KeyValue elements of the KeyInfo element of an XMLSignature. It does not determine if the key is trusted.
    // This is a very simple KeySelector implementation, designed for illustration rather than real-world usage.
    // A more practical example of a KeySelector is one that searches a KeyStore for trusted keys that match X509Data information
    // (for example, X509SubjectName, X509IssuerSerial, X509SKI, or X509Certificate elements) contained in a KeyInfo.
    // The implementation of the KeyValueKeySelector is as follows:

    private static class KeyValueKeySelector extends KeySelector {

        public KeySelectorResult select(KeyInfo keyInfo,
                                        Purpose purpose,
                                        AlgorithmMethod method,
                                        XMLCryptoContext context)
                throws KeySelectorException {

            if (keyInfo == null) {
                throw new KeySelectorException("Null KeyInfo object!");
            }
            SignatureMethod sm = (SignatureMethod) method;
            List list = keyInfo.getContent();

            for (int i = 0; i < list.size(); i++) {
                XMLStructure xmlStructure = (XMLStructure) list.get(i);
                if (xmlStructure instanceof KeyValue) {
                    PublicKey pk = null;
                    try {
                        pk = ((KeyValue) xmlStructure).getPublicKey();
                    } catch (KeyException ke) {
                        throw new KeySelectorException(ke);
                    }
                    // make sure algorithm is compatible with method
                    if (algEquals(sm.getAlgorithm(),
                            pk.getAlgorithm())) {
                        return new SimpleKeySelectorResult(pk);
                    }
                }
            }
            throw new KeySelectorException("No KeyValue element found!");
        }

        static boolean algEquals(String algURI, String algName) {
            if (algName.equalsIgnoreCase("DSA") &&
                    algURI.equalsIgnoreCase(SignatureMethod.DSA_SHA1)) {
                return true;
            } else if (algName.equalsIgnoreCase("RSA") &&
                    algURI.equalsIgnoreCase(SignatureMethod.RSA_SHA1)) {
                return true;
            } else {
                return false;
            }
        }
    }

    private static class SimpleKeySelectorResult implements KeySelectorResult {
        private PublicKey pk;

        SimpleKeySelectorResult(PublicKey pk) {
            this.pk = pk;
        }

        public Key getKey() {
            return pk;
        }
    }
}
