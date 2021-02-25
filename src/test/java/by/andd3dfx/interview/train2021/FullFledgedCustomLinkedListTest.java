package by.andd3dfx.interview.train2021;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FullFledgedCustomLinkedListTest {

    @Test
    public void reverse() {
        FullFledgedCustomLinkedList<Integer> linkedList = new FullFledgedCustomLinkedList<>();
        linkedList.add(3);
        linkedList.add(7);
        linkedList.add(12);

        linkedList.reverse();

        assertThat("Wrong size", linkedList.size(), is(3));
        assertThat("Wrong list[0] item", linkedList.get(0), is(12));
        assertThat("Wrong list[1] item", linkedList.get(1), is(7));
        assertThat("Wrong list[2] item", linkedList.get(2), is(3));

        System.out.printf(linkedList.toString());
    }
}