package by.andd3dfx.multithreading;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class CustomAtomicTest {

    @Test
    public void getAndIncrementWithoutFailedAttempts() {
        CustomAtomic customAtomic = new TestCustomAtomic(34, 0);

        int result = customAtomic.getAndIncrement();

        assertThat("Initial value expected", result, is(34));
        assertThat("Incremented value expected", customAtomic.current(), is(35));
    }

    @Test
    public void getAndIncrementWithFailedAttempts() {
        CustomAtomic customAtomic = new TestCustomAtomic(34, 5);
        int result = customAtomic.getAndIncrement();

        assertThat("Initial value expected", result, is(34));
        assertThat("Incremented value expected", customAtomic.current(), is(35));
    }

    class TestCustomAtomic extends CustomAtomic {

        private int innerValue;
        private final int maxNumberOfFailedAttempts;
        private int attemptsCount = 0;

        public TestCustomAtomic(int initialValue, int maxNumberOfFailedAttempts) {
            innerValue = initialValue;
            this.maxNumberOfFailedAttempts = maxNumberOfFailedAttempts;
        }

        @Override
        public int current() {
            return innerValue;
        }

        @Override
        public boolean compareAndSwap(int oldValue, int newValue) {
            if (attemptsCount < maxNumberOfFailedAttempts) {
                attemptsCount++;
                System.out.println("Failed attempt");
                return false;
            }

            innerValue = newValue;
            return true;
        }
    }
}
