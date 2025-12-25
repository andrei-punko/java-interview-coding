package by.andd3dfx.parser.xml;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Parse file ./src/main/resources/233.xml and find all articles inside it
 *
 * @see <a href="https://youtu.be/4DGhiBXFhUc">Video solution</a>
 */
public class ArticlesXmlParser {

    private static final String ARTICLE_TAG = "Article";

    @SneakyThrows
    public List<String> parse(String filePath) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        File xmlFile = new File(filePath);
        Document doc = documentBuilder.parse(xmlFile);

        NodeList childNodes = doc.getChildNodes();

        List<String> articles = new ArrayList<>();
        find(childNodes, articles);
        return articles;
    }

    private void find(NodeList childNodes, List<String> articles) {
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (ARTICLE_TAG.equals(item.getNodeName())) {
                articles.add(prettyFormat(item));
            }
            find(item.getChildNodes(), articles);
        }
    }

    private String prettyFormat(Node item) {
        String[] lines = item.getTextContent().split("\n");
        return Arrays.stream(lines)
            .filter(StringUtils::isNotBlank)
            .map(String::trim)
            .collect(Collectors.joining("\n"));
    }
}
