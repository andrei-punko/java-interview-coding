package by.andd3dfx.string.parsing;

import by.andd3dfx.string.parsing.ParseListIntoStructure;
import by.andd3dfx.string.parsing.ParseListIntoStructure.Properties;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParseListIntoStructureTest {
    private ParseListIntoStructure task;

    @Before
    public void setup() {
        task = new ParseListIntoStructure();
    }

    @Test
    public void parseOneRowSimpleStructure() {
        List<String> values = Arrays.asList(
                "key=14"
        );

        Properties result = task.parse(values);

        assertThat("Wrong value", result.value, is(nullValue()));

        Properties keyItem = result.inner.get("key");
        assertThat("Wrong value for keyItem", keyItem.value, is(14));
        assertThat("Wrong inner for keyItem", keyItem.inner.isEmpty(), is(true));
    }

    @Test
    public void parseOneRowComplexStructure() {
        List<String> values = Arrays.asList(
                "key.subkey=10"
        );

        Properties result = task.parse(values);

        assertThat("Wrong value", result.value, is(nullValue()));

        Properties keyItem = result.inner.get("key");
        assertThat("Wrong value for keyItem", keyItem.value, is(nullValue()));

        Properties subkeyItem = keyItem.inner.get("subkey");
        assertThat("Wrong value for subkey", subkeyItem.value, is(10));
        assertThat("Wrong inner for subkey", subkeyItem.inner.isEmpty(), is(true));
    }

    @Test
    public void testParseMultipleRowsSimpleStructure() {
        List<String> values = Arrays.asList(
                "key=2",
                "key2=3"
        );

        Properties result = task.parse(values);

        assertThat("Wrong value", result.value, is(nullValue()));

        Properties keyItem = result.inner.get("key");
        assertThat("Wrong value for keyItem", keyItem.value, is(2));
        assertThat("Wrong inner for keyItem", keyItem.inner.isEmpty(), is(true));

        Properties key2Item = result.inner.get("key2");
        assertThat("Wrong value for key2Item", key2Item.value, is(3));
        assertThat("Wrong inner for key2Item", key2Item.inner.isEmpty(), is(true));
    }

    @Test
    public void testParseMultipleRowsComplexStructure() {
        List<String> values = Arrays.asList(
                "key.subkey.subkey2=1",
                "key.subkey=2",
                "key.subkey3=3",
                "key2.subkey4=5"
        );

        Properties result = task.parse(values);

        assertThat("Wrong value", result.value, is(nullValue()));

        Properties keyItem = result.inner.get("key");
        assertThat("Wrong value for keyItem", keyItem.value, is(nullValue()));

        Properties subkeyItem = keyItem.inner.get("subkey");
        assertThat("Wrong value for subkeyItem", subkeyItem.value, is(2));

        Properties subkey2Item = subkeyItem.inner.get("subkey2");
        assertThat("Wrong value for subkey2Item", subkey2Item.value, is(1));
        assertThat("Wrong inner for subkey2Item", subkey2Item.inner.isEmpty(), is(true));

        Properties subkey3Item = keyItem.inner.get("subkey3");
        assertThat("Wrong value for subkey3Item", subkey3Item.value, is(3));
        assertThat("Wrong inner for subkey3Item", subkey3Item.inner.isEmpty(), is(true));

        Properties key2Item = result.inner.get("key2");
        assertThat("Wrong value for key2Item", key2Item.value, is(nullValue()));

        Properties subkey4Item = key2Item.inner.get("subkey4");
        assertThat("Wrong value for subkey4Item", subkey4Item.value, is(5));
        assertThat("Wrong inner for subkey4Item", subkey4Item.inner.isEmpty(), is(true));
    }
}
