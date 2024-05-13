package by.andd3dfx.multithreading;

import java.util.concurrent.Semaphore;

/**
 * <pre>
 * https://leetcode.com/problems/print-in-order/
 *
 * Suppose we have a class:
 *
 *  public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 *
 * The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will
 * call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second()
 * is executed after first(), and third() is executed after second().
 *
 * Note:
 * We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seem
 * to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: "firstsecondthird"
 * Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(),
 * thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
 *
 * Example 2:
 * Input: nums = [1,3,2]
 * Output: "firstsecondthird"
 * Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second().
 * "firstsecondthird" is the correct output.
 *
 * Constraints:
 *      nums is a permutation of [1, 2, 3].
 *
 * Initial code:
 * class Foo {
 *     public void first(Runnable printFirst) throws InterruptedException {
 *         printFirst.run();    // Outputs "first". Do not change or remove this line.
 *     }
 *     public void second(Runnable printSecond) throws InterruptedException {
 *         printSecond.run();   // Outputs "second". Do not change or remove this line.
 *     }
 *     public void third(Runnable printThird) throws InterruptedException {
 *         printThird.run();    // Outputs "third". Do not change or remove this line.
 *     }
 * }
 * </pre>
 *
 * @see <a href="https://youtu.be/UTmv-H2xc9Y">Video solution</a>
 */
public class PrintInOrder {

    private Semaphore semaphore2 = new Semaphore(0);
    private Semaphore semaphore3 = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();   // Outputs "first". Do not change or remove this line.
        semaphore2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore2.acquire();
        printSecond.run();  // Outputs "second". Do not change or remove this line.
        semaphore3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore3.acquire();
        printThird.run();   // Outputs "third". Do not change or remove this line.
    }
}
