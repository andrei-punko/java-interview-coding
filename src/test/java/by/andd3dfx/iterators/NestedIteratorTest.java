package by.andd3dfx.iterators;

import static org.assertj.core.api.Assertions.assertThat;

import by.andd3dfx.iterators.NestedIterator.INestedInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.Test;

public class NestedIteratorTest {

    @Test
    public void testNextAndHasNext() {
        check(List.of(new NestedInteger(2)), List.of(2));
        check(List.of(new NestedIntegerList(new NestedIntegerList())), List.of());

        check(List.of(
                new NestedIntegerList(1, 1),
                new NestedInteger(2),
                new NestedIntegerList(1, 1)
            ),
            List.of(1, 1, 2, 1, 1));

        check(List.of(
                new NestedInteger(1),
                new NestedIntegerList(new NestedInteger(4), new NestedIntegerList(6))
            ),
            List.of(1, 4, 6));
    }

    @Test
    public void testNextAndHasNext_emptyList() {
        check(List.of(
                new NestedIntegerList()
            ),
            List.of());
    }

    @Test(expected = NoSuchElementException.class)
    public void testNextWhenNoElements() {
        var nestedIterator = new NestedIterator(List.of());
        nestedIterator.next();
    }

    private void check(List<INestedInteger> incoming, List<Integer> outgoing) {
        var result = new ArrayList<>();

        var nestedIterator = new NestedIterator(incoming);
        while (nestedIterator.hasNext()) {
            result.add(nestedIterator.next());
        }

        assertThat(result).isEqualTo(outgoing);
    }

    private static class NestedInteger implements INestedInteger {

        private final Integer integer;

        public NestedInteger(Integer integer) {
            this.integer = integer;
        }

        @Override
        public boolean isInteger() {
            return true;
        }

        @Override
        public Integer getInteger() {
            return integer;
        }

        @Override
        public List<INestedInteger> getList() {
            throw new IllegalStateException("Could not call getList on Integer!");
        }
    }

    private static class NestedIntegerList implements INestedInteger {

        private final List<INestedInteger> list;

        public NestedIntegerList() {
            list = new ArrayList<>();
        }

        public NestedIntegerList(INestedInteger... values) {
            list = Arrays.stream(values).toList();
        }

        public NestedIntegerList(int... values) {
            list = new ArrayList<>();
            for (var value : values) {
                list.add(new NestedInteger(value));
            }
        }

        @Override
        public boolean isInteger() {
            return false;
        }

        @Override
        public Integer getInteger() {
            throw new IllegalStateException("Could not call getInteger on list!");
        }

        @Override
        public List<INestedInteger> getList() {
            return list;
        }
    }
}
