package by.andd3dfx.interview.dow;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Parse file ./sandbox-core/src/main/resources/233.xml and find all articles inside it
 */
public class Parser {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File fXmlFile = new File("./sandbox-core/src/main/resources/233.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        NodeList childNodes = doc.getChildNodes();
        find(childNodes);
    }

    private static void find(NodeList childNodes) {
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if ("Article".equals(item.getNodeName())) {
                System.out.println("Found it");
                System.out.println(prettyFormat(item));
            }
            find(item.getChildNodes());
        }
    }

    private static String prettyFormat(Node item) {
        String result = "";

        String[] lines = item.getTextContent().split("\n");
        boolean blankLineIsPossible = true;

        for (String line : lines) {
            if (StringUtils.isNotBlank(line)) {
                result += line + "\n";
                blankLineIsPossible = true;
            } else if (blankLineIsPossible) {
                result += "\n";
                blankLineIsPossible = false;
            }
        }

        return result;
    }
}
