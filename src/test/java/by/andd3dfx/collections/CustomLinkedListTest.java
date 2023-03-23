package by.andd3dfx.collections;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomLinkedListTest {

    @Test
    public void reverse() {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.add(3);
        linkedList.add(7);
        linkedList.add(12);
        linkedList.add(34);

        assertThat("Wrong size", linkedList.size(), is(4));
        assertThat("Wrong list[0] item", linkedList.get(0), is(3));
        assertThat("Wrong list[1] item", linkedList.get(1), is(7));
        assertThat("Wrong list[2] item", linkedList.get(2), is(12));
        assertThat("Wrong list[3] item", linkedList.get(3), is(34));

        linkedList.reverse();

        assertThat("Wrong size", linkedList.size(), is(4));
        assertThat("Wrong list[0] item", linkedList.get(0), is(34));
        assertThat("Wrong list[1] item", linkedList.get(1), is(12));
        assertThat("Wrong list[2] item", linkedList.get(2), is(7));
        assertThat("Wrong list[3] item", linkedList.get(3), is(3));
    }
}
