package by.andd3dfx.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountStreamersTest {

    @Test
    public void count() {
        var result = CountStreamers.count(new int[][]{
                {10, 30},
                {20, 40},
                {39, 50},
                {60, 110},
                {80, 90},
                {30, 70},
                {10, 120}
        });

        assertThat(result).isEqualTo(4);
    }
}
