package by.andd3dfx.search;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Есть прачечная с N стиральными машинами.
 * На входе в прачечную в очереди стоят M человек для того, чтобы постирать свои вещи.
 * Про каждого человека известно, сколько времени он будет стирать свои вещи.
 * Каждый человек использует первую освободившуюся машину.
 * Сколько времени займет стирка всех вещей?
 *
 * @see <a href="https://youtu.be/reTyOF3yo5k">Video solution</a>
 */
public class WashMachines {

    public static int find(int n, int[] times) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(n, Comparator.comparingInt(o -> o));
        for (int i = 0; i < n && i < times.length; i++) {
            queue.add(times[i]);
        }

        for (int i = n; i < times.length; i++) {
            Integer polled = queue.poll();
            queue.add(polled + times[i]);
        }
        return queue.stream()
                .max(Comparator.comparingInt(o -> o))
                .orElse(0);
    }
}
