package by.andd3dfx.multithreading;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomAtomicTest {

    @Test
    public void getAndIncrementWithoutFailedAttempts() {
        CustomAtomic customAtomic = new CustomAtomicImpl(34, 0);

        assertThat(customAtomic.current())
                .as("Initial value for current() expected")
                .isEqualTo(34);
        assertThat(customAtomic.getAndIncrement())
                .as("Initial value for getAndIncrement() expected")
                .isEqualTo(34);
        assertThat(customAtomic.current())
                .as("Incremented value for current() expected")
                .isEqualTo(35);
    }

    @Test
    public void getAndIncrementWithFailedAttempts() {
        CustomAtomic customAtomic = new CustomAtomicImpl(34, 5);

        assertThat(customAtomic.current())
                .as("Initial value for current() expected")
                .isEqualTo(34);
        assertThat(customAtomic.getAndIncrement())
                .as("Initial value for getAndIncrement() expected")
                .isEqualTo(34);
        assertThat(customAtomic.current())
                .as("Incremented value for current() expected")
                .isEqualTo(35);
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
