package by.andd3dfx.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Implement CustomStream class to make possible usage of filter() and map() operations like next expression:
 * stream.filter(item -> item.y > 10).map(Item::getX);
 * <p>
 * Add collectToList() method to CustomStream
 *
 * @see <a href="https://youtu.be/LvBjS17CatQ">Video solution part1</a>, <a href="https://youtu.be/iuzWoSzl1to">part2</a>
 */
public class CustomStream<T> {

    private List<T> list;
    private final List<Action> actions = new ArrayList<>();

    public CustomStream(List<T> list) {
        this.list = list;
    }

    public static <T> CustomStream<T> empty() {
        return new CustomStream<>(List.of());
    }

    public static <T> CustomStream<T> of(T value) {
        return new CustomStream<>(List.of(value));
    }

    public static <T> CustomStream<T> of(T... values) {
        return new CustomStream<>(List.of(values));
    }

    public static <T> CustomStream<T> ofNullable(T value) {
        if (value == null) {
            return empty();
        }
        return of(value);
    }

    public CustomStream<T> filter(Predicate<T> predicate) {
        actions.add(stream -> {
            var result = new ArrayList<T>();
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

    public CustomStream<T> limit(int n) {
        actions.add(stream -> {
            list = list.subList(0, Math.min(n, list.size()));
        });
        return this;
    }

    /**
     * Like limit() but with condition instead of number
     */
    public CustomStream<T> takeWhile(Predicate<T> predicate) {
        actions.add(stream -> {
            int i = 0;
            for (var item : list) {
                if (!predicate.test(item)) {
                    break;
                }
                i++;
            }
            list = list.subList(0, i);
        });
        return this;
    }

    public CustomStream<T> skip(int n) {
        actions.add(stream -> {
            list = list.subList(Math.min(n, list.size()), list.size());
        });
        return this;
    }

    /**
     * Like skip() but with condition instead of number
     */
    public CustomStream<T> dropWhile(Predicate<T> predicate) {
        actions.add(stream -> {
            int i = 0;
            for (var item : list) {
                if (!predicate.test(item)) {
                    break;
                }
                i++;
            }
            list = list.subList(i, list.size());
        });
        return this;
    }

    public CustomStream<T> distinct() {
        actions.add(stream -> {
            var result = new ArrayList<T>();
            extLoop:
            for (var item : list) {
                for (var addedItem : result) {
                    if (isEquals(item, addedItem)) {
                        continue extLoop;
                    }
                }
                result.add(item);
            }
            list = result;
        });
        return this;
    }

    public CustomStream<T> sorted(Comparator<? super T> comparator) {
        actions.add(stream -> {
            list.sort(comparator);
        });
        return this;
    }

    static <T> boolean isEquals(T item1, T item2) {
        if (item1 == null) {
            return item2 == null;
        }
        return item1.equals(item2);
    }

    public List<T> collectToList() {
        for (var action : actions) {
            action.apply(this);
        }
        return list;
    }

    public int count() {
        for (var action : actions) {
            action.apply(this);
        }
        return list.size();
    }

    public Object[] toArray() {
        for (var action : actions) {
            action.apply(this);
        }
        return list.toArray();
    }

    public List<T> toList() {
        for (var action : actions) {
            action.apply(this);
        }
        return Collections.unmodifiableList(list);
    }

    public void forEach(Function<T, Object> function) {
        for (var action : actions) {
            action.apply(this);
        }
        for (var item : list) {
            function.apply(item);
        }
    }

    public static void main(String[] args) {
        List<Item> list = Arrays.asList(new Item(1, 3), new Item(2, 18), new Item(5, 11));

        var stream = new CustomStream<>(list);
        var result = stream
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
