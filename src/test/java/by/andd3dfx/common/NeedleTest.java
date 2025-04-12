package by.andd3dfx.common;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static by.andd3dfx.common.Needle.count;
import static org.assertj.core.api.Assertions.assertThat;

public class NeedleTest {

    @Test
    public void countOneLine() throws IOException {
        String inMessage = "Hello, there!";

        assertThat(count("there", buildStream(inMessage))).isEqualTo(1);
        assertThat(count("small", buildStream(inMessage))).isEqualTo(0);
    }

    @Test
    public void countMultiLine() throws IOException {
        String inMessage = "Hello, there!\n" +
                "How are you today?\n" +
                "Yes, you over there.";

        assertThat(count("there", buildStream(inMessage))).isEqualTo(2);
        assertThat(count("today", buildStream(inMessage))).isEqualTo(1);
        assertThat(count("small", buildStream(inMessage))).isEqualTo(0);
    }

    private InputStream buildStream(String inMessage) {
        return new ByteArrayInputStream(inMessage.getBytes());
    }
}
