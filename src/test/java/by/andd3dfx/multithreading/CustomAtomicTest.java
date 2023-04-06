package by.andd3dfx.multithreading;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomAtomicTest {

    @Test
    public void getAndIncrementWithoutFailedAttempts() {
        CustomAtomic customAtomic = new CustomAtomicImpl(34, 0);

        assertThat("Initial value for current() expected", customAtomic.current(), is(34));
        assertThat("Initial value for getAndIncrement() expected", customAtomic.getAndIncrement(), is(34));
        assertThat("Incremented value for current() expected", customAtomic.current(), is(35));
    }

    @Test
    public void getAndIncrementWithFailedAttempts() {
        CustomAtomic customAtomic = new CustomAtomicImpl(34, 5);

        assertThat("Initial value for current() expected", customAtomic.current(), is(34));
        assertThat("Initial value for getAndIncrement() expected", customAtomic.getAndIncrement(), is(34));
        assertThat("Incremented value for current() expected", customAtomic.current(), is(35));
    }

    class CustomAtomicImpl extends CustomAtomic {

        private int innerValue;
        private final int maxNumberOfFailedAttempts;
        private int attemptsCount = 0;

        public CustomAtomicImpl(int initialValue, int maxNumberOfFailedAttempts) {
            this.innerValue = initialValue;
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
                System.out.println("Failed attempt N" + attemptsCount);
                return false;
            }

            innerValue = newValue;
            return true;
        }
    }
}
