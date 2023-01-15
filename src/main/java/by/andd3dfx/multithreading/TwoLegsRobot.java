package by.andd3dfx.multithreading;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.io.StringWriter;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

/**
 * <pre>
 * Дан класс:
 * class Foot implements Runnable {
 * 	   private String name;
 *
 * 	   public Foot(String name) {
 * 	   	this.name = name;
 *     }
 *
 * 	   public void run() {
 * 	   	for (int i = 0; i < 10; i++) {
 * 	   		step();
 *         }
 *     }
 *
 * 	   private void step() {
 * 	   	System.out.println(name + " steps!");
 *     }
 * }
 *
 * И программа:
 * public class MainClass {
 *     public static void main(String[] args) {
 *         new Thread(new Foot("left")).start();
 *         new Thread(new Foot("right")).start();
 *
 *         while(true);
 *     }
 * }
 *
 * Исправить программу, чтобы робот шагал ногами по очереди.
 * Сделать так, чтобы не потреблялись ресурсы CPU, пока ожидаем передвижения очередной ноги.
 * </pre>
 */
public class TwoLegsRobot {

    private static StringWriter writer = new StringWriter();

    @AllArgsConstructor
    public static class Foot implements Runnable {
        private final String name;
        private final Semaphore mySemaphore;
        private final Semaphore notMySemaphore;

        @SneakyThrows
        public void run() {
            for (int i = 0; i < 10; i++) {
                step();
            }
        }

        private void step() throws InterruptedException {
            mySemaphore.acquire();
            log();
            notMySemaphore.release();
        }

        private void log() {
            writer.write(name + " steps!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Semaphore leftSemaphore = new Semaphore(1);
        Semaphore rightSemaphore = new Semaphore(0);

        new Thread(new Foot("left", leftSemaphore, rightSemaphore)).start();
        new Thread(new Foot("right", rightSemaphore, leftSemaphore)).start();

        sleep(100);
    }

    public static StringWriter getWriter() {
        return writer;
    }
}
