package by.andd3dfx.java8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomStreamTest {

    @Test
    public void testFilterAndMap() {
        List<Item> list = Arrays.asList(
                new Item(1, 3),
                new Item(2, 18),
                new Item(5, 11)
        );

        List result = new CustomStream(list)
                .filter(item -> ((Item) item).getY() > 10)
                .map(from -> ((Item) from).getX())
                .collectToList();

        assertThat(result, is(Arrays.asList(2, 5)));
    }
}
