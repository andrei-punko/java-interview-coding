package by.andd3dfx.jvm;

public class CrashJvmBecauseOfStackOverflow {

    public static void main(String[] args) {
        fire();
    }

    private static void fire() {
        fire();
    }
}
