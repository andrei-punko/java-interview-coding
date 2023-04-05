package by.andd3dfx.java8.stream;

import by.andd3dfx.java8.stream.CustomStream.Item;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomStreamTest {

    @Test
    public void testFilter() {
        List<Item> list = buildList();

        List result = new CustomStream<>(list)
                .filter(item -> item.getY() > 10)
                .collectToList();

        assertThat(result).isEqualTo(List.of(
                new Item(2, 18),
                new Item(5, 11)
        ));
    }

    @Test
    public void testMap() {
        List<Item> list = buildList();

        List result = new CustomStream<>(list)
                .map(Item::getX)
                .collectToList();

        assertThat(result).isEqualTo(List.of(1, 2, 5));
    }

    @Test
    public void testFilterAndMap() {
        List<Item> list = buildList();

        List result = new CustomStream<>(list)
                .filter(item -> item.getY() > 10)
                .map(Item::getX)
                .collectToList();

        assertThat(result).isEqualTo(List.of(2, 5));
    }

    @Test
    public void testSkip() {
        List<Item> list = buildList();

        List<Item> result = new CustomStream<>(list)
                .skip(2)
                .collectToList();

        assertThat(result).isEqualTo(List.of(new Item(5, 11)));
    }

    @Test
    public void testSkipAll() {
        List<Item> list = buildList();

        List<Item> result = new CustomStream<>(list)
                .skip(4)
                .collectToList();

        assertThat(result.isEmpty()).isEqualTo(true);
    }

    @Test
    public void testLimit() {
        List<Item> list = buildList();

        List<Item> result = new CustomStream<>(list)
                .limit(2)
                .collectToList();

        assertThat(result).isEqualTo(List.of(new Item(1, 3), new Item(2, 18)));
    }

    @Test
    public void testCount() {
        List<Item> list = buildList();

        int result = new CustomStream<>(list)
                .count();

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void testToArray() {
        List<Item> list = buildList();

        Object[] result = new CustomStream<>(list)
                .toArray();

        assertThat(result).isEqualTo(new Object[]{new Item(1, 3), new Item(2, 18), new Item(5, 11)});
    }

    private List<Item> buildList() {
        return List.of(
                new Item(1, 3), new Item(2, 18), new Item(5, 11)
        );
    }
}
