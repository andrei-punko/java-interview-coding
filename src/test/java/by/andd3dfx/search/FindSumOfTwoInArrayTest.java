package by.andd3dfx.search;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindSumOfTwoInArrayTest {

    @Test
    public void find_On2() {
        assertThat(FindSumOfTwoInArray.find_On2(new int[]{1, 4, 7, 2, 90}, 94))
                .containsExactlyInAnyOrder(1, 4);
        assertThat(FindSumOfTwoInArray.find_On2(new int[]{2, 4, 7, 2, 90}, 4))
                .containsExactlyInAnyOrder(0, 3);
        assertThat(FindSumOfTwoInArray.find_On2(new int[]{1, 4, 7, 2, 90}, 19))
                .isNull();
    }

    @Test
    public void find_On() {
        assertThat(FindSumOfTwoInArray.find_On(new int[]{1, 4, 7, 2, 90}, 94))
                .containsExactlyInAnyOrder(1, 4);
        assertThat(FindSumOfTwoInArray.find_On(new int[]{2, 4, 7, 2, 90}, 4))
                .containsExactlyInAnyOrder(0, 3);
        assertThat(FindSumOfTwoInArray.find_On(new int[]{1, 4, 7, 2, 90}, 19))
                .isNull();
    }
}
