package by.andd3dfx.numeric;

/**
 * Реализовать вручную функцию целочисленного деления int divide(int a, int b)
 */
public class IntDivider {

    public static int divide(int a, int b) {
        int counter = 0;
        while (a >= b) {
            a -= b;
            counter++;
        }
        return counter;
    }
}
