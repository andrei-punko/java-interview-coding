package by.andd3dfx.jvm;

/**
 * @see <a href="https://youtu.be/FTR-_QqcH-I">Video solution</a>
 */
public class CrashJvmBecauseOfStackOverflow {

    public static void main(String[] args) {
        fire();
    }

    private static void fire() {
        fire();
    }
}
