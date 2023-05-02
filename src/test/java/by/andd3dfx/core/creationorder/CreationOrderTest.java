package by.andd3dfx.core.creationorder;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CreationOrderTest {

    private final List<String> EXPECTED_LOGS = List.of(
            "A2 Static block of class A",
            "B2 Static block of class B",
            "A1 Usual block of class A, 100",
            "A3 Class A constructor, 100",
            "B4 Call of class B method, 0",
            "B1 Usual block of class B, 1000",
            "B3 Class B constructor, 1000",
            "B4 Call of class B method, 1000",
            "B4 Call of class B method, 1000"
    );

    @Test
    public void checkCallsOrder() {
        var instance = new ClassB();
        instance.showValue();

        var logs = instance.getLogs();
        assertThat(logs.size()).isEqualTo(EXPECTED_LOGS.size());

        var index = 0;
        for (var logItem : logs) {
            assertThat(logItem).isEqualTo(EXPECTED_LOGS.get(index));
            index++;
        }
    }
}
