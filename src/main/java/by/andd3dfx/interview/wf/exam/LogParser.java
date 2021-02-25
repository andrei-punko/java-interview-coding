package by.andd3dfx.interview.wf.exam;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LogParser {

  public static Collection<Integer> getIdsByMessage(String xml, String message) throws Exception {
    List<Integer> result = new ArrayList<>();
    ByteArrayInputStream is = new ByteArrayInputStream(xml.getBytes());

    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
    Document document = documentBuilder.parse(is);

    NodeList nodeList = document.getElementsByTagName("message");
    for (int i = 0; i < nodeList.getLength(); i++) {
      Node item = nodeList.item(i);
      if (message.equals(item.getTextContent())) {
        NamedNodeMap attributes = item.getParentNode().getAttributes();
        result.add(Integer.valueOf(attributes.getNamedItem("id").getTextContent()));
      }
    }
    return result;
  }

  public static void main(String[] args) throws Exception {
    String xml =
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<log>\n" +
            "    <entry id=\"1\">\n" +
            "        <message>Application started</message>\n" +
            "    </entry>\n" +
            "    <entry id=\"2\">\n" +
            "        <message>Application ended</message>\n" +
            "    </entry>\n" +
            "</log>";

    Collection<Integer> ids = getIdsByMessage(xml, "Application ended");
    for (int id : ids) {
      System.out.println(id);
    }
  }
}
