package by.andd3dfx.parser.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Implement a function folderNames(), which accepts a string containing an XML file that specifies folder structure
 * and returns all folder names that start with startingLetter. The XML format is given in the example below.
 *
 * For example, for the letter 'u' and an XML file:
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;
 * &lt;folder name="c"&gt;
 *     &lt;folder name="program files"&gt;
 *         &lt;folder name="uninstall information"/&gt;
 *     &lt;/folder&gt;
 *     &lt;folder name="users"/&gt;
 * &lt;/folder&gt;
 *
 * the function should return a collection with items "uninstall information" and "users" (in any order).
 * </pre>
 *
 * @see <a href="https://youtu.be/4DGhiBXFhUc">Video solution</a>
 */
public class FolderNamesXmlParser {

    private static final String FOLDER_TAG = "folder";
    private static final String NAME_ATTRIBUTE = "name";

    public List<String> folderNames(String xml, char startingLetter) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        InputSource inputSource = new InputSource(new StringReader(xml));
        Document document = documentBuilder.parse(inputSource);

        List<String> result = new ArrayList<>();
        NodeList elements = document.getElementsByTagName(FOLDER_TAG);
        for (int i = 0; i < elements.getLength(); i++) {
            final Node item = elements.item(i);
            final NamedNodeMap attributes = item.getAttributes();
            String folderName = attributes.getNamedItem(NAME_ATTRIBUTE).getNodeValue();
            if (folderName.charAt(0) == startingLetter) {
                result.add(folderName);
            }
        }

        return result;
    }
}
