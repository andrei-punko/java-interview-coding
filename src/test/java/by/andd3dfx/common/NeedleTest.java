package by.andd3dfx.common;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NeedleTest {

    @Test
    public void countOneLine() throws IOException {
        String inMessage = "Hello, there!";

        assertThat(Needle.count("there", buildStream(inMessage)), is(1));
        assertThat(Needle.count("small", buildStream(inMessage)), is(0));
    }

    @Test
    public void countMultiLine() throws IOException {
        String inMessage = "Hello, there!\n" +
                "How are you today?\n" +
                "Yes, you over there.";

        assertThat(Needle.count("there", buildStream(inMessage)), is(2));
        assertThat(Needle.count("today", buildStream(inMessage)), is(1));
        assertThat(Needle.count("small", buildStream(inMessage)), is(0));
    }

    private InputStream buildStream(String inMessage) {
        return new ByteArrayInputStream(inMessage.getBytes());
    }
}