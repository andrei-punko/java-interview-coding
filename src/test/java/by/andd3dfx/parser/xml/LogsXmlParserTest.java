package by.andd3dfx.parser.xml;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class LogsXmlParserTest {

  private LogsXmlParser parser;

  @Before
  public void setUp() throws Exception {
    parser = new LogsXmlParser();
  }

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

    Collection<Integer> ids = parser.getIdsByMessage(xml, "Application ended");

    assertThat(ids.size()).isEqualTo(2);
    assertThat(ids).containsExactlyInAnyOrder(2, 24);
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

    Collection<Integer> ids = parser.getIdsByMessage(xml, "Application stopped");

    assertTrue(ids.isEmpty());
  }
}
