package by.andd3dfx.interview.wf.exam;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Collection;
import org.junit.Test;

public class LogParserTest {

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
            "</log>";

    Collection<Integer> ids = LogParser.getIdsByMessage(xml, "Application ended");

    assertThat("One item expected", ids.size(), is(1));
    assertThat("Collection should contain item", ids, hasItem(2));
  }
}
