package by.andd3dfx.multithreading;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class TwoLegsRobotTest {

    private final String LEFT = "left";
    private final String RIGHT = "right";

    @Test
    public void testMain() throws InterruptedException {
        TwoLegsRobot.main(new String[]{});

        String outContent = TwoLegsRobot.getWriter().toString();
        checkLogs(outContent);
    }

    private void checkLogs(String log) {
        String[] lines = log.split("\r\n");

        Boolean leftExpected = null;
        for (String line : lines) {
            if (!line.startsWith(LEFT) && !line.startsWith(RIGHT)) {
                continue;
            }
            if (leftExpected == null) {
                leftExpected = line.startsWith(RIGHT);
                continue;
            }
            String expectedString = leftExpected ? LEFT : RIGHT;
            assertThat("Expected " + expectedString + ", but actual is " + line, line.startsWith(expectedString), is(true));
            leftExpected = !leftExpected;
        }
    }
}
