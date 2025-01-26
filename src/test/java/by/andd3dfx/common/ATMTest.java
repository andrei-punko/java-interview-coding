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
                200, 3,
                50, 5
        ));
    }

    @Test
    public void withdraw() {
        var result = atm.withdraw(450);

        assertThat(result).isEqualTo(Map.of(
                200, 2,
                50, 1
        ));
    }

    @Test
    public void withdrawWhenHighGradeBanknotePresentButShouldNotBeUsed() {
        // Spend all 50 banknotes
        for (int i = 0; i < 5; i++) {
            atm.withdraw(50);
        }

        // Ask 600, ATM has only 500 & 200 banknotes at this moment
        var result = atm.withdraw(600);

        assertThat(result).isEqualTo(Map.of(
                200, 3
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
                50, 3
        ));

        var result2 = atm.withdraw(650);
        assertThat(result2).isEqualTo(Map.of(
                200, 3,
                50, 1
        ));
    }
}