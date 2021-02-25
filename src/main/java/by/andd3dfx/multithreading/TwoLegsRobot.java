package by.andd3dfx.multithreading;

import static java.lang.Thread.sleep;

import java.io.StringWriter;
import java.util.concurrent.atomic.AtomicBoolean;

/*
Дан класс:
class Foot implements Runnable {
	private String name;

	public Foot(String name) {
		this.name = name;
	}

	public void run() {
		for(;;) {
			step();
		}
	}

	private void step() {
		System.out.println(name + " steps!");
	}
}

И программа:
public class MainClass {
    public static void main(String[] args) {
        new Thread(new Foot("left")).start();
        new Thread(new Foot("right")).start();

        while(true);
    }
}

Исправить программу, чтобы робот шагал ногами по очереди.
Сделать так, чтобы не потреблялись ресурсы CPU, пока ожидаем передвижения очередной ноги.
*/
public class TwoLegsRobot {

    private static final StringWriter writer = new StringWriter();

    static class Foot implements Runnable {

        private String name;
        private volatile static AtomicBoolean monitor = new AtomicBoolean(false);

        public Foot(String name) {
            this.name = name;
        }

        public void run() {
            for (; ; ) {
                step();
            }
        }

        private void step() {
            synchronized (monitor) {
                monitor.set(!monitor.get());
                log();
            }
        }

        private void log() {
            writer.write(name + " steps!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Foot("left")).start();
        new Thread(new Foot("right")).start();

        sleep(1);
    }

    public static StringWriter getWriter() {
        return writer;
    }
}
