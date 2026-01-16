package by.andd3dfx.search;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

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

    /// Cases from deleted implementation copy

    @Test
    public void testFind_ON() {
        var result = FindSumOfTwoInArray.find_On(new int[]{1, 3, 5, 7, 9}, 12);

        assertThat(result).satisfiesAnyOf(
            items -> assertThat(items).isEqualTo(new int[]{1, 4}),
            items -> assertThat(items).isEqualTo(new int[]{2, 3}),
            items -> assertThat(items).isEqualTo(new int[]{3, 2}),
            items -> assertThat(items).isEqualTo(new int[]{4, 1})
        );
    }

    @Test
    public void testFind_ON2() {
        var result = FindSumOfTwoInArray.find_On2(new int[]{1, 3, 5, 7, 9}, 12);

        assertThat(result).satisfiesAnyOf(
            items -> assertThat(items).isEqualTo(new int[]{1, 4}),
            items -> assertThat(items).isEqualTo(new int[]{2, 3}),
            items -> assertThat(items).isEqualTo(new int[]{3, 2}),
            items -> assertThat(items).isEqualTo(new int[]{4, 1})
        );
    }

    @Test
    public void testFind_ONForSameNumbers() {
        var result = FindSumOfTwoInArray.find_On(new int[]{1, 1, 6, 6, 1}, 12);

        assertThat(result).satisfiesAnyOf(
            items -> assertThat(items).isEqualTo(new int[]{2, 3}),
            items -> assertThat(items).isEqualTo(new int[]{3, 2})
        );
    }

    @Test
    public void testFind_ON2ForSameNumbers() {
        var result = FindSumOfTwoInArray.find_On2(new int[]{1, 1, 6, 6, 1}, 12);

        assertThat(result).satisfiesAnyOf(
            items -> assertThat(items).isEqualTo(new int[]{2, 3}),
            items -> assertThat(items).isEqualTo(new int[]{3, 2})
        );
    }

    @Test
    public void testFind_ONForAbsentSolution() {
        var result = FindSumOfTwoInArray.find_On(new int[]{1, 1, 6, 3, 1}, 12);

        assertThat(result).isNull();
    }

    @Test
    public void testFind_ON2ForAbsentSolution() {
        var result = FindSumOfTwoInArray.find_On2(new int[]{1, 1, 6, 3, 1}, 12);

        assertThat(result).isNull();
    }
}
