package by.andd3dfx.multithreading;

import lombok.Builder;
import lombok.SneakyThrows;

import java.io.StringWriter;
import java.util.concurrent.Semaphore;

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
 *
 * @see <a href="https://youtu.be/MBANIKUlpEs">Video solution</a>
 */
public class TwoLegsRobot {

    private Foot leftLeg;
    private Foot rightLeg;
    private StringWriter logWriter;

    public TwoLegsRobot() {
        Semaphore leftSemaphore = new Semaphore(1);
        Semaphore rightSemaphore = new Semaphore(0);
        logWriter = new StringWriter();

        leftLeg = Foot.builder()
            .name("left")
            .mySemaphore(leftSemaphore)
            .notMySemaphore(rightSemaphore)
            .logWriter(logWriter)
            .build();
        rightLeg = Foot.builder()
            .name("right")
            .mySemaphore(rightSemaphore)
            .notMySemaphore(leftSemaphore)
            .logWriter(logWriter)
            .build();
    }

    public void start() {
        new Thread(leftLeg).start();
        new Thread(rightLeg).start();
    }

    public String getLogs() {
        return logWriter.toString();
    }

    @Builder
    public static class Foot implements Runnable {
        private final String name;
        private final Semaphore mySemaphore;
        private final Semaphore notMySemaphore;
        private final StringWriter logWriter;

        @SneakyThrows
        public void run() {
            for (int i = 0; i < 10; i++) {
                step();
            }
        }

        private void step() throws InterruptedException {
            mySemaphore.acquire();
            logWriter.write("%s steps!".formatted(name));
            notMySemaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        var robot = new TwoLegsRobot();
        robot.start();

        Thread.sleep(100);
        System.out.println(robot.getLogs());
    }
}
