package by.andd3dfx.java8.stream;

import by.andd3dfx.java8.functionalinterface.Converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Implement CustomStream class to make possible usage of filter() and map() operations like next expression:
 * stream.filter(item -> item.y > 10).map(Item::getX);
 * <p>
 * Add collectToList method to CustomStream
 */
public class CustomStream {

    private List list;
    private List<Action> actions = new ArrayList<>();

    public CustomStream(List list) {
        this.list = list;
    }

    public CustomStream filter(Predicate predicate) {
        actions.add(stream -> {
            List result = new ArrayList<>();
            for (Object item : list) {
                if (predicate.test(item)) {
                    result.add(item);
                }
            }
            list = result;
        });
        return this;
    }

    public CustomStream map(Converter conversion) {
        actions.add(stream -> {
            List result = new ArrayList<>();
            for (Object item : list) {
                result.add(conversion.convert(item));
            }
            list = result;
        });
        return this;
    }

    public List collectToList() {
        for (Action action : actions) {
            action.apply(this);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Item> list = Arrays.asList(new Item(1, 3), new Item(2, 18), new Item(5, 11));

        CustomStream stream = new CustomStream(list);
        List result = stream
                .filter(item -> ((Item) item).getY() > 10)
                .map(from -> ((Item) from).getX())
                .collectToList();

        System.out.println(result);
    }
}
