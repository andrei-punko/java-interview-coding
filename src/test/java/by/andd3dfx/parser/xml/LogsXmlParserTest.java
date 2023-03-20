package by.andd3dfx.parser.xml;

import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LogsXmlParserTest {

  @Test
  public void getIdsByMessage() throws Exception {
    String xml =
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<log>\n" +
            "    <entry id=\"1\">\n" +
            "        <message>Application started</message>\n" +
            "    </entry>\n" +
            "    <entry id=\"2\">\n" +
            "        <message>Application ended</message>\n" +
            "    </entry>\n" +
            "    <entry id=\"23\">\n" +
            "        <message>Application started</message>\n" +
            "    </entry>\n" +
            "    <entry id=\"24\">\n" +
            "        <message>Application ended</message>\n" +
            "    </entry>\n" +
            "</log>";

    Collection<Integer> ids = LogsXmlParser.getIdsByMessage(xml, "Application ended");

    assertThat("Two items expected", ids.size(), is(2));
    assertThat("Collection should contain items", ids, hasItems(2, 24));
  }

  @Test
  public void getIdsByMessageWhenNothingFound() throws Exception {
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

    Collection<Integer> ids = LogsXmlParser.getIdsByMessage(xml, "Application stopped");

    assertThat("Empty array expected", ids.isEmpty(), is(true));
  }
}
