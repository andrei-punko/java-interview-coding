package by.andd3dfx.multithreading;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Example from JDK: http://docs.oracle.com/javase/tutorial/essential/concurrency/deadlock.html
 */
public class Deadlock {

    @Getter
    @AllArgsConstructor
    public class Friend {
        private final String name;

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s" + "  has bowed to me!%n", this.name, bower.getName());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s" + " has bowed back to me!%n", this.name, bower.getName());
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
