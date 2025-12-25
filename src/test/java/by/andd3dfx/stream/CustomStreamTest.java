package by.andd3dfx.stream;

import by.andd3dfx.stream.CustomStream.Item;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CustomStreamTest {

    @Test
    public void testEmpty() {
        List result = CustomStream.empty()
            .collectToList();

        assertThat(result).isEqualTo(List.of());
    }

    @Test
    public void testOfForSingle() {
        List result = CustomStream.of(new Item(56, 78))
            .collectToList();

        assertThat(result).isEqualTo(
            List.of(new Item(56, 78))
        );
    }

    @Test
    public void testOfForMultiple() {
        List result = CustomStream.of(new Item(56, 78), new Item(57, 79))
            .collectToList();

        assertThat(result).isEqualTo(List.of(
            new Item(56, 78), new Item(57, 79)
        ));
    }

    @Test
    public void testOfNullableForNull() {
        List<Object> result = CustomStream
            .ofNullable(null)
            .collectToList();

        assertThat(result).isEqualTo(List.of());
    }

    @Test
    public void testOfNullable() {
        List<Item> result = CustomStream
            .ofNullable(new Item(56, 78))
            .collectToList();

        assertThat(result).isEqualTo(List.of(new Item(56, 78)));
    }

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
    public void testDropWhile() {
        List<Item> list = buildList();

        List<Item> result = new CustomStream<>(list)
            .dropWhile(item -> item.getX() < 5)
            .collectToList();

        assertThat(result).isEqualTo(List.of(new Item(5, 11)));
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
    public void testTakeWhile() {
        List<Item> list = buildList();

        List<Item> result = new CustomStream<>(list)
            .takeWhile(item -> item.getX() < 4)
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
    public void isEquals() {
        assertTrue(CustomStream.isEquals(null, null));
        Object object = new Object();
        assertTrue(CustomStream.isEquals(object, object));
        assertFalse(CustomStream.isEquals(null, object));
        assertFalse(CustomStream.isEquals(object, null));
        assertFalse(CustomStream.isEquals(object, new Object()));
    }

    @Test
    public void testDistinct() {
        List<Item> list = buildList();
        list.addAll(buildList());

        var result = new CustomStream<>(list)
            .distinct()
            .collectToList();

        assertThat(result).isEqualTo(
            List.of(new Item(1, 3), new Item(2, 18), new Item(5, 11))
        );
    }

    @Test
    public void testDistinctWhenNullsPresent() {
        List<Item> list = buildList();
        list.add(null);
        list.addAll(buildList());
        list.add(null);

        var result = new CustomStream<>(list)
            .distinct()
            .collectToList();

        assertThat(result).isEqualTo(
            Arrays.asList(new Item(1, 3), new Item(2, 18), new Item(5, 11), null)
        );
    }

    @Test
    public void testToArray() {
        List<Item> list = buildList();

        Object[] result = new CustomStream<>(list)
            .toArray();

        assertThat(result).isEqualTo(new Object[]{new Item(1, 3), new Item(2, 18), new Item(5, 11)});
    }

    @Test
    public void testToList() {
        List<Item> list = buildList();

        List<Item> result = new CustomStream<>(list)
            .toList();

        assertThat(result).isEqualTo(
            Arrays.asList(new Item(1, 3), new Item(2, 18), new Item(5, 11))
        );
        try {
            result.add(new Item(3, 3));
            fail("Exception should be thrown!");
        } catch (UnsupportedOperationException uoe) {
            // Don't need to check anything
        }
    }

    @Test
    public void testForEach() {
        List<Item> list = buildList();

        var result = new ArrayList<>();
        new CustomStream<>(list)
            .forEach(item -> result.add(item.getX() * item.getY()));

        assertThat(result).isEqualTo(List.of(3, 36, 55));
    }

    @Test
    public void sorted() {
        List<Item> list = buildList();
        list.add(new Item(4, 10));
        list.add(new Item(78, 7));

        List<Item> result = new CustomStream<>(list)
            .sorted(Comparator.comparingInt(Item::getY))
            .toList();

        assertThat(result).isEqualTo(Arrays.asList(
            new Item(1, 3),
            new Item(78, 7),
            new Item(4, 10),
            new Item(5, 11),
            new Item(2, 18)
        ));
    }

    private List<Item> buildList() {
        return new ArrayList<>(List.of(
            new Item(1, 3), new Item(2, 18), new Item(5, 11)
        ));
    }
}
