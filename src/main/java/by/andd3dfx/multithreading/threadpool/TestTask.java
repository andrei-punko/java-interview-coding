package by.andd3dfx.multithreading.threadpool;

/*
    TestTask simulates the task to be submitted to thread pool
 */
public class TestTask implements Runnable {

    private int number;

    public TestTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Start executing of task number: " + number);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End executing of task number: " + number);
    }
}
