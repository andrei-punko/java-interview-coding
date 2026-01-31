package by.andd3dfx.numeric;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class NumberOfRecentCallsTest {

    private NumberOfRecentCalls numberOfRecentCalls;

    @Before
    public void setUp() {
        numberOfRecentCalls = new NumberOfRecentCalls();
    }

    @Test
    public void ping() {
        assertThat(numberOfRecentCalls.ping(1)).isEqualTo(1);     // requests = [1], range is [-2999,1], return 1
        assertThat(numberOfRecentCalls.ping(100)).isEqualTo(2);   // requests = [1, 100], range is [-2900,100], return 2
        assertThat(numberOfRecentCalls.ping(3001)).isEqualTo(3);  // requests = [1, 100, 3001], range is [1,3001], return 3
        assertThat(numberOfRecentCalls.ping(3002)).isEqualTo(3);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
    }
}
