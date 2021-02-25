package by.andd3dfx.string.parsing;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/*
Implement a function folderNames, which accepts a string containing an XML file that specifies folder structure and
returns all folder names that start with startingLetter. The XML format is given in the example below.

For example, for the letter 'u' and an XML file:
<?xml version="1.0" encoding="UTF-8"?>
<folder name="c">
    <folder name="program files">
        <folder name="uninstall information" />
    </folder>
    <folder name="users" />
</folder>

the function should return a collection with items "uninstall information" and "users" (in any order).
 */
public class Folders {

  public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
    List<String> result = new ArrayList<>();

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    InputSource is = new InputSource(new StringReader(xml));
    Document document = builder.parse(is);

    NodeList elements = document.getElementsByTagName("folder");
    for (int i = 0; i < elements.getLength(); i++) {
      String folderName = elements.item(i).getAttributes().getNamedItem("name").getNodeValue();
      if (folderName.charAt(0) == startingLetter) {
        result.add(folderName);
      }
    }

    return result;
  }

  public static void main(String[] args) throws Exception {
    String xml =
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<folder name=\"c\">" +
            "<folder name=\"program files\">" +
            "<folder name=\"uninstall information\" />" +
            "</folder>" +
            "<folder name=\"users\" />" +
            "</folder>";

    Collection<String> names = folderNames(xml, 'u');
    for (String name : names) {
      System.out.println(name);
    }
  }
}
