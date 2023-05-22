package by.andd3dfx.parser.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * You receive a string that contains an XML log file like the following:
 * <pre>
 *   &lt;?xml version="1.0" encoding="UTF-8"?&gt;
 *   &lt;log&gt;
 *       &lt;entry id="1"&gt;
 *           &lt;message&gt;Application started&lt;/message&gt;
 *       &lt;/entry&gt;
 *       &lt;entry id="2"&gt;
 *           &lt;message&gt;Application ended&lt;/message&gt;
 *       &lt;/entry&gt;
 *   &lt;/log&gt;
 * </pre>
 * <p>
 * Implement a function getIdsByMessage(xmlString, message) that returns the ids of the entries that contain a specific message.
 * <p>
 * For example, getIdsByMessage() for the XML log above and for the message "Application ended" should return { 2 }.
 */
public class LogsXmlParser {

    private static final String MESSAGE_TAG = "message";
    private static final String ID_ATTRIBUTE = "id";

    public List<Integer> getIdsByMessage(String xmlString, String message) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(xmlString.getBytes());
        Document document = documentBuilder.parse(inputStream);

        List<Integer> result = new ArrayList<>();
        NodeList elements = document.getElementsByTagName(MESSAGE_TAG);
        for (int i = 0; i < elements.getLength(); i++) {
            Node item = elements.item(i);
            if (message.equals(item.getTextContent())) {
                NamedNodeMap attributes = item.getParentNode().getAttributes();
                result.add(Integer.valueOf(attributes.getNamedItem(ID_ATTRIBUTE).getTextContent()));
            }
        }
        return result;
    }
}
