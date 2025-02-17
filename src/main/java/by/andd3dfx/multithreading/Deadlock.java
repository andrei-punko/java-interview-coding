package by.andd3dfx.multithreading;

import lombok.AllArgsConstructor;

/**
 * <a href="http://docs.oracle.com/javase/tutorial/essential/concurrency/deadlock.html">Example</a> from JDK
 *
 * @see <a href="https://youtu.be/xuWU_6JTXi4">Video solution</a>
 */
public class Deadlock {

    @AllArgsConstructor
    public class Friend {
        private final String name;

        public synchronized void bow(Friend bower) {
            System.out.printf("%s: %s has bowed to me!%n", name, bower.name);
            bower.bowBack(this);
        }

        private synchronized void bowBack(Friend bower) {
            System.out.printf("%s: %s has bowed back to me!%n", name, bower.name);
        }
    }

    public void makeDeadlock() {
        Friend alphonse = new Friend("Alphonse");
        Friend gaston = new Friend("Gaston");

        Thread thread1 = new Thread(() -> alphonse.bow(gaston));
        Thread thread2 = new Thread(() -> gaston.bow(alphonse));

        thread1.start();
        thread2.start();

        while (thread1.isAlive() || thread2.isAlive()) ;
    }
}
