package by.andd3dfx.common;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class ATMTest {

    private ATM atm;

    @Before
    public void setUp() throws Exception {
        atm = new ATM(Map.of(
                500, 1,
                100, 2,
                50, 10
        ));
    }

    @Test
    public void withdraw() {
        var result = atm.withdraw(450);

        assertThat(result).isEqualTo(Map.of(
                100, 2,
                50, 5
        ));
    }

    @Test
    public void withdrawWhenNoSmallNominalsInATM() {
        var thrown = assertThrows(IllegalStateException.class, () -> atm.withdraw(451));
        assertThat(thrown.getMessage()).isEqualTo("Could not perform withdraw!");
    }

    @Test
    public void withdrawForConsequentCalls() {
        var result = atm.withdraw(650);
        assertThat(result).isEqualTo(Map.of(
                500, 1,
                100, 1,
                50, 1
        ));

        var result2 = atm.withdraw(250);
        assertThat(result2).isEqualTo(Map.of(
                100, 1,
                50, 3
        ));
    }
}