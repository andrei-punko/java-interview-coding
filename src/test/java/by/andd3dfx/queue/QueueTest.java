package by.andd3dfx.queue;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Revert of singly linked list
 */
public class QueueTest {

    @Test(expected = AssertionError.class)
    public void revertUsingAdditionalArrayForEmptyQueue() {
        Queue queue = new Queue(null);
        queue.revertUsingAdditionalArray();
    }

    @Test(expected = AssertionError.class)
    public void revertUsingRecursionForEmptyQueue() {
        Queue queue = new Queue(null);
        queue.revertUsingRecursion();
    }

    @Test
    public void revertUsingAdditionalArrayForOneElement() throws Exception {
        Queue queue = new Queue(new Item());

        assertThat("Same element expected", queue.revertUsingAdditionalArray(), is(queue.getHead()));
    }

    @Test
    public void revertUsingRecursionForOneElement() throws Exception {
        Queue queue = new Queue(new Item());

        assertThat("Same element expected", queue.revertUsingRecursion(), is(queue.getHead()));
    }

    @Test
    public void revertUsingAdditionalArray() throws Exception {
        Item item1 = new Item();
        Item item2 = new Item();
        item1.setNext(item2);
        Queue queue = new Queue(item1);

        Item newHead = queue.revertUsingAdditionalArray();

        assertThat("Old last item should be the head", newHead, is(item2));
        assertThat("New last item should be old first", newHead.getNext(), is(item1));
        assertThat("next item for the last item should be null", newHead.getNext().getNext(), nullValue());
    }

    @Test
    public void revertUsingRecursion() throws Exception {
        Item item1 = new Item();
        Item item2 = new Item();
        item1.setNext(item2);
        Queue queue = new Queue(item1);

        Item newHead = queue.revertUsingRecursion();

        assertThat("Old last item should be the head", newHead, is(item2));
        assertThat("New last item should be old first", newHead.getNext(), is(item1));
        assertThat("next item for the last item should be null", newHead.getNext().getNext(), nullValue());
    }
}
