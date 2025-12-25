package by.andd3dfx.multithreading.queue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.awaitility.Durations.ONE_HUNDRED_MILLISECONDS;
import static org.awaitility.Durations.ONE_SECOND;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class AbstractBlockingQueueTest {

    private final int ITEMS_AMOUNT = 20;
    private CustomBlockingQueue<QueueItem> queue;
    private Random random = new Random();

    @Before
    public void setUp() {
        queue = buildQueue(ITEMS_AMOUNT);
    }

    @Data
    @AllArgsConstructor
    public class QueueItem {
        String name;
        int number;
    }

    protected abstract CustomBlockingQueue<QueueItem> buildQueue(int size);

    @Test
    public void testEnqueueWaitingOfDequeue() {
        for (int i = 0; i < ITEMS_AMOUNT; i++) {
            enqueue("EnqueueDequeue", i);
        }
        var enqueueFuture = CompletableFuture.runAsync(() -> {
            enqueue("EnqueueDequeue", ITEMS_AMOUNT + 1);
        });
        sleep(500);
        assertFalse(enqueueFuture.isDone());

        dequeue();
        await()
            .atMost(ONE_SECOND)
            .pollInterval(ONE_HUNDRED_MILLISECONDS)
            .until(() -> enqueueFuture.isDone());
        assertTrue(enqueueFuture.isDone());
    }

    @Test
    public void testDequeueWaitingOfEnqueue() {
        var dequeueFuture = CompletableFuture.runAsync(() -> {
            dequeue();
        });
        sleep(500);
        assertFalse(dequeueFuture.isDone());

        enqueue("DequeueEnqueue", 1);
        await()
            .atMost(ONE_SECOND)
            .pollInterval(ONE_HUNDRED_MILLISECONDS)
            .until(() -> dequeueFuture.isDone());
        assertTrue(dequeueFuture.isDone());
    }

    @SneakyThrows
    @Test
    public void testParallelism() {
        Runnable enqueue1 = () -> {
            int counter = 0;
            while (counter < ITEMS_AMOUNT) {
                enqueue("A", counter);
                sleep();
                counter++;
            }
        };
        Runnable enqueue2 = () -> {
            int counter = 0;
            while (counter < ITEMS_AMOUNT) {
                enqueue("B", counter);
                sleep();
                counter++;
            }
        };

        Callable<List<QueueItem>> dequeue = () -> {
            List<QueueItem> result = new ArrayList<>(2 * ITEMS_AMOUNT);
            int counter = 0;
            while (counter < 2 * ITEMS_AMOUNT) {
                var item = dequeue();
                result.add(item);
                sleep();
                counter++;
            }
            return result;
        };

        CompletableFuture.runAsync(enqueue1);
        CompletableFuture.runAsync(enqueue2);
        CompletableFuture<Callable<List<QueueItem>>> dequeueFuture = CompletableFuture.supplyAsync(() -> dequeue);
        await()
            .atMost(ONE_SECOND)
            .pollInterval(ONE_HUNDRED_MILLISECONDS)
            .until(() -> dequeueFuture.isDone());

        // Test items distribution
        // Если значения распределены равномерно, средние значения для А и B будут примерно одинаковы,
        // если (худший случай) вначале идут значения одного потока, а потом другого -
        // средние значения будут N^2/2 и 3N^2/2 соответственно.
        // Поэтому проверяем, что разница между ними меньше чем N^2/2 (50% от макс. разницы)
        var itemsList = dequeueFuture.get().call();
        var valueA = 0;
        var valueB = 0;
        for (int i = 0; i < 2 * ITEMS_AMOUNT; i++) {
            var item = itemsList.get(i);
            switch (item.name) {
                case "A":
                    valueA += i;
                    break;
                case "B":
                    valueB += i;
                    break;
            }
        }
        System.out.println(MessageFormat.format("valueA={0}, valueB={1}", valueA, valueB));
        assertThat(Math.abs(valueA - valueB)).isLessThan(ITEMS_AMOUNT * ITEMS_AMOUNT / 2);
    }

    @SneakyThrows
    private void enqueue(String name, int counter) {
        queue.enqueue(new QueueItem(name, counter));
    }

    @SneakyThrows
    private QueueItem dequeue() {
        return queue.dequeue();
    }

    @SneakyThrows
    private void sleep() {
        Thread.sleep(random.nextInt(ITEMS_AMOUNT));
    }

    @SneakyThrows
    private void sleep(long ms) {
        Thread.sleep(ms);
    }
}
