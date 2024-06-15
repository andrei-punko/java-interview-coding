package by.andd3dfx.common;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class PassportCheckpointTest {

    @Test
    public void testSolution1() {
        var entry = new PassportCheckpoint.Solution1();
        assertThat("Null expected", entry.exit(), nullValue());
        entry.enter("AB54321");
        entry.enter("UK32032");

        assertThat("First element expected", entry.exit(), is("AB54321"));
        assertThat("Second element expected", entry.exit(), is("UK32032"));
        assertThat("Null expected", entry.exit(), nullValue());
        assertThat("Null expected", entry.exit(), nullValue());
    }

    @Test
    public void testSolution2() {
        var entry = new PassportCheckpoint.Solution2();
        assertThat("Null expected", entry.exit(), nullValue());
        entry.enter("AB54321");
        entry.enter("UK32032");

        assertThat("First element expected", entry.exit(), is("AB54321"));
        assertThat("Second element expected", entry.exit(), is("UK32032"));
        assertThat("Null expected", entry.exit(), nullValue());
        assertThat("Null expected", entry.exit(), nullValue());
    }
}
