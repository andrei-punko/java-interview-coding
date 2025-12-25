package by.andd3dfx.multithreading;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Taken from <a href="https://github.com/proselytear/javaconcurrency">this repo</a>
 */
public class Livelock {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Spoon {
        private Eater owner;

        public synchronized void use() {
            System.out.printf("%s has eaten!", owner.getName());
        }
    }

    @Getter
    public static class Eater {
        private String name;
        private boolean isHungry;

        public Eater(String n) {
            name = n;
            isHungry = true;
        }

        public void eatWith(Spoon spoon, Eater spouse) {
            while (isHungry) {
                // Don't have the spoon, so wait patiently for spouse.
                if (spoon.getOwner() != this) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        continue;
                    }
                    continue;
                }

                // If spouse is hungry, insist upon passing the spoon.
                if (spouse.isHungry()) {
                    System.out.printf(
                        "%s: You eat first my darling %s!%n",
                        name, spouse.getName());
                    spoon.setOwner(spouse);
                    continue;
                }

                // Spouse wasn't hungry, so finally eat
                spoon.use();
                isHungry = false;
                System.out.printf(
                    "%s: I am stuffed, my darling %s!%n",
                    name, spouse.getName());
                spoon.setOwner(spouse);
            }
        }
    }

    public void makeLivelock() {
        Eater husband = new Eater("Bob");
        Eater wife = new Eater("Alice");

        Spoon s = new Spoon(husband);

        Thread thread1 = new Thread(() -> husband.eatWith(s, wife));
        Thread thread2 = new Thread(() -> wife.eatWith(s, husband));

        thread1.start();
        thread2.start();

        while (thread1.isAlive() || thread2.isAlive()) ;
    }
}
