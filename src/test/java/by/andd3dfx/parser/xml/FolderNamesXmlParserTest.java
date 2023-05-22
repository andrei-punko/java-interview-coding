package by.andd3dfx.parser.xml;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FolderNamesXmlParserTest {

    private FolderNamesXmlParser parser;

    @Before
    public void setUp() throws Exception {
        parser = new FolderNamesXmlParser();
    }

    @Test
    public void folderNames() throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"c\">" +
                        "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";

        Collection<String> result = parser.folderNames(xml, 'u');

        assertThat(result.size(), is(2));
        assertThat(result, hasItems("uninstall information", "users"));
    }
}
