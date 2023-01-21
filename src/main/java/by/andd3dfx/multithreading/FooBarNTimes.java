package by.andd3dfx.multithreading;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

/**
 * Task from https://leetcode.com/problems/print-foobar-alternately/
 *
 * <pre>
 * Suppose you are given the following code:
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 *
 * The same instance of FooBar will be passed to two different threads:
 *     thread A will call foo(), while
 *     thread B will call bar().
 * Modify the given program to output "foobar" n times.
 * </pre>
 */
public class FooBarNTimes {

    @RequiredArgsConstructor
    public static class FooBar {
        private final int n;

        private Semaphore fooSemaphore = new Semaphore(1);
        private Semaphore barSemaphore = new Semaphore(0);

        @SneakyThrows
        public void foo() {
            for (int i = 0; i < n; i++) {
                fooSemaphore.acquire();
                System.out.print("foo");
                barSemaphore.release();
            }
        }
        @SneakyThrows
        public void bar() {
            for (int i = 0; i < n; i++) {
                barSemaphore.acquire();
                System.out.print("bar");
                fooSemaphore.release();
            }
        }
    }
}
