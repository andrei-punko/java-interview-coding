package by.andd3dfx.multithreading;

import lombok.SneakyThrows;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrintInOrderTest {

    @Test
    public void checkPrintingOrder() throws InterruptedException {
        var printInOrder = new PrintInOrder();

        // Check task requirements
        var result = run(printInOrder);
        assertThat(result).isEqualTo("firstsecondthird");

        // Check could class pass required procedure second time
        var result2 = run(printInOrder);
        assertThat(result2).isEqualTo("firstsecondthird");
    }

    private String run(PrintInOrder printInOrder) throws InterruptedException {
        var sb = new StringBuilder();
        var thread1 = new Thread(() -> printFirst(printInOrder, () -> sb.append("first")));
        var thread2 = new Thread(() -> printSecond(printInOrder, () -> sb.append("second")));
        var thread3 = new Thread(() -> printThird(printInOrder, () -> sb.append("third")));
        thread3.start();
        thread2.start();
        thread1.start();

        Thread.sleep(50);

        return sb.toString();
    }

    @SneakyThrows
    private void printFirst(PrintInOrder printInOrder, Runnable runnable) {
        printInOrder.first(runnable);
    }

    @SneakyThrows
    private void printSecond(PrintInOrder printInOrder, Runnable runnable) {
        printInOrder.second(runnable);
    }

    @SneakyThrows
    private void printThird(PrintInOrder printInOrder, Runnable runnable) {
        printInOrder.third(runnable);
    }
}
