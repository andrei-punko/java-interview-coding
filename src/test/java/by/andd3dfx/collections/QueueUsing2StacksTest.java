package by.andd3dfx.collections;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class QueueUsing2StacksTest {

    @Test
    public void testQueue() {
        QueueUsing2Stacks queue = new QueueUsing2Stacks();
        queue.push(1);      // queue is [1] (leftmost is front of the queue)
        queue.push(2);      // queue is [1 2] (leftmost is front of the queue)
        queue.push(3);      // queue is [1 2 3] (leftmost is front of the queue)
        assertThat(queue.peek()).isEqualTo(1);  // return 1
        assertThat(queue.pop()).isEqualTo(1);   // return 1, queue is [2 3]
        assertThat(queue.pop()).isEqualTo(2);   // return 1, queue is [3]
        assertThat(queue.peek()).isEqualTo(3);  // return 3
        assertThat(queue.empty()).isFalse();
        assertThat(queue.pop()).isEqualTo(3);   // return 3, queue is []
        assertThat(queue.empty()).isTrue();
    }
}
