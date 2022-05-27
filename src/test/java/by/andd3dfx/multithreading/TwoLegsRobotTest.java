package by.andd3dfx.multithreading;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TwoLegsRobotTest {

    private String[] expectedStrings = {"left steps", "right steps"};

    @Test
    public void testMain() throws InterruptedException {
        TwoLegsRobot.main(new String[]{});

        String logs = TwoLegsRobot.getWriter().toString();
        checkLogs(logs);
    }

    private void checkLogs(String logs) {
        String[] lines = logs.split("!");
        var expectedStringIndex = lines[0].equals(expectedStrings[0]) ? 1 : 0;

        for (int i = 1; i < lines.length; i++) {
            assertThat(lines[i], is(expectedStrings[expectedStringIndex]));

            if (expectedStringIndex == 0) {
                expectedStringIndex = 1;
            } else {
                expectedStringIndex = 0;
            }
        }
    }
}
