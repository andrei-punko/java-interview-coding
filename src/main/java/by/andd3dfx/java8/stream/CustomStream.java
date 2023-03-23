package by.andd3dfx.java8.stream;

import by.andd3dfx.java8.functionalinterface.Converter;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Implement CustomStream class to make possible usage of filter() and map() operations like next expression:
 * stream.filter(item -> item.y > 10).map(Item::getX);
 * <p>
 * Add collectToList() method to CustomStream
 */
public class CustomStream<T> {

    private List<T> list;
    private List<Action> actions = new ArrayList<>();

    public CustomStream(List<T> list) {
        this.list = list;
    }

    public CustomStream<T> filter(Predicate<T> predicate) {
        actions.add(stream -> {
            List result = new ArrayList<>();
            for (var item : list) {
                if (predicate.test(item)) {
                    result.add(item);
                }
            }
            list = result;
        });
        return this;
    }

    public CustomStream<T> map(Converter<T, Object> converter) {
        actions.add(stream -> {
            List result = new ArrayList<>();
            for (var item : list) {
                result.add(converter.convert(item));
            }
            list = result;
        });
        return this;
    }

    public List<T> collectToList() {
        for (var action : actions) {
            action.apply(this);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Item> list = Arrays.asList(new Item(1, 3), new Item(2, 18), new Item(5, 11));

        var stream = new CustomStream<>(list);
        List result = stream
                .filter(item -> item.getY() > 10)
                .map(Item::getX)
                .collectToList();

        System.out.println(result);
    }

    @Data
    @AllArgsConstructor
    public static class Item {
        private int x;
        private int y;
    }
}
