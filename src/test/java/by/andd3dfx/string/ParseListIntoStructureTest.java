package by.andd3dfx.string;

import by.andd3dfx.string.ParseListIntoStructure.Properties;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ParseListIntoStructureTest {

    private ParseListIntoStructure parser;

    @Before
    public void setUp() throws Exception {
        parser = new ParseListIntoStructure();
    }

    @Test
    public void parseOneRowSimpleStructure() {
        var lines = List.of(
            "key=14"
        );
        var expectedResult = new Properties(Map.of(
            "key", new Properties(14)
        ));

        parseAndCheckAssertions(lines, expectedResult);
    }

    @Test
    public void parseOneRowComplexStructure() {
        var lines = List.of(
            "key.subkey=10"
        );
        var expectedResult = new Properties(Map.of(
            "key", new Properties(Map.of("subkey", new Properties(10)))
        ));

        parseAndCheckAssertions(lines, expectedResult);
    }

    @Test
    public void parseMultipleRowsSimpleStructure() {
        var lines = List.of(
            "key=2",
            "key2=3"
        );
        var expectedResult = new Properties(Map.of(
            "key", new Properties(2),
            "key2", new Properties(3)
        ));

        parseAndCheckAssertions(lines, expectedResult);
    }

    @Test
    public void parseMultipleRowsComplexStructure() {
        var lines = List.of(
            "key.subkey.subkey2=1",
            "key.subkey=2",
            "key.subkey3=3",
            "key2.subkey4=5"
        );
        var expectedResult = new Properties(Map.of(
            "key", new Properties(Map.of(
                "subkey", new Properties(2, Map.of("subkey2", new Properties(1))),
                "subkey3", new Properties(3)
            )),
            "key2", new Properties(Map.of("subkey4", new Properties(5)))
        ));

        parseAndCheckAssertions(lines, expectedResult);
    }

    private void parseAndCheckAssertions(List<String> lines, Properties expectedResult) {
        var result = parser.parse(lines);

        assertThat(result).isEqualTo(expectedResult);
    }
}
