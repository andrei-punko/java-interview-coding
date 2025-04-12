package by.andd3dfx.multithreading;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.awaitility.Durations.ONE_HUNDRED_MILLISECONDS;
import static org.awaitility.Durations.ONE_SECOND;

public class TwoLegsRobotTest {

    private Map<Boolean, String> EXPECTED_STRING = Map.of(
            false, "left steps",
            true, "right steps"
    );

    private TwoLegsRobot robot;

    @Before
    public void setUp() throws Exception {
        robot = new TwoLegsRobot();
    }

    @Test
    public void testLogsOrder() {
        robot.start();
        await()
                .atMost(ONE_SECOND)
                .pollInterval(ONE_HUNDRED_MILLISECONDS)
                .until(() -> robot.getLogs().split("!").length > 10);   // At least 10 steps

        checkLogs(robot.getLogs());
    }

    private void checkLogs(String logs) {
        String[] lines = logs.split("!");
        assertThat(lines.length).isGreaterThan(10);

        var index = false;
        for (var line : lines) {
            assertThat(line).isEqualTo(EXPECTED_STRING.get(index));
            index = !index;
        }
    }
}
