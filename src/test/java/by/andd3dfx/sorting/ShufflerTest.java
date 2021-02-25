package by.andd3dfx.sorting;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ShufflerTest {

    private Shuffler shuffler;

    @Before
    public void setup() {
        shuffler = new Shuffler();
    }

    @Test
    public void shuffle() {
        int[] list = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0};

        int[] result = shuffler.shuffle(list);

        assertThat("Wrong size of result list", result.length, is(10));
        int counter = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != result[i]) {
                counter++;
            }
        }
        assertThat("Bad shuffling quality", counter/(double)result.length, lessThan(0.1d));
    }
}
