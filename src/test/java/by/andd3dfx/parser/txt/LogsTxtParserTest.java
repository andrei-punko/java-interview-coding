package by.andd3dfx.parser.txt;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LogsTxtParserTest {

    @Test
    public void parse() {
        List<String> result = LogsTxtParser.parse("./src/main/resources/234.txt");

        assertThat(result).hasSize(4);
        assertThat(result).isEqualTo(List.of("logs-123-2", "logs-124-4", "logs-125-6", "logs-126-8"));
    }
}
