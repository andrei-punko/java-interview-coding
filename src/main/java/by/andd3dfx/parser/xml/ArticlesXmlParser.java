package by.andd3dfx.parser.xml;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Parse file ./src/main/resources/233.xml and find all articles inside it
 */
@Slf4j
public class ArticlesXmlParser {

    public static final String ARTICLE_TAG = "Article";

    @SneakyThrows
    public static List<String> parse(String filePath) {
        File fXmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        NodeList childNodes = doc.getChildNodes();

        List<String> articles = new ArrayList<>();
        find(childNodes, articles);
        return articles;
    }

    private static void find(NodeList childNodes, List<String> articles) {
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (ARTICLE_TAG.equals(item.getNodeName())) {
                articles.add(prettyFormat(item));
            }
            find(item.getChildNodes(), articles);
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

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        List<String> articles = new ArticlesXmlParser().parse("./src/main/resources/233.xml");

        System.out.println(articles);
    }
}
