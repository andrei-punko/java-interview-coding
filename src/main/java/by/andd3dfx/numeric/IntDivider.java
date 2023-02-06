package by.andd3dfx.numeric;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Реализовать вручную функцию целочисленного деления int divide(int a, int b)
 */
public class IntDivider {

    public static int divide(int a, int b) {
        if (b == 1) {
            return a;
        }

        var counter = 0;
        while (a >= b) {
            a -= b;
            counter++;
        }
        return counter;
    }

    public static int divideOptimized(int a, int b) {
        int remains = a;
        int counter = 0;
        int power = 1;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(power);

        int iterationsAmount = 0;
        while (remains >= b) {
            if (remains >= power * b) {
                remains -= power * b;
                counter += power;

                stack.push(power);
                power *= 2;
            } else {
                power = stack.pop();
            }

            iterationsAmount++;
        }

        System.out.println(String.format("Division: %d/%d=%d. Iterations performed: %d", a, b, counter, iterationsAmount));
        return counter;
    }
}
