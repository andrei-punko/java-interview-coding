package by.andd3dfx.jvm;

import java.util.ArrayList;

/**
 * @see <a href="https://youtu.be/FTR-_QqcH-I">Video solution</a>
 */
public class CrashJvmBecauseOfOutOfMemory {

    public static void main(String[] args) {
        var list = new ArrayList<byte[]>();
        while (true) {
            list.add(new byte[10 * 1024 * 1024]);
            System.out.printf("Free memory: %d Mb%n", Runtime.getRuntime().freeMemory() / (1024 * 1024));
        }
    }
}
