package by.andd3dfx.numeric;

import java.util.Stack;

/**
 * Реализовать вручную функцию целочисленного деления int divide(int a, int b)
 */
public class IntDivider {

    public static int divide(int a, int b) {
        if (b == 1) {
            return a;
        }

        int counter = 0;
        while (a >= b) {
            a -= b;
            counter++;
        }
        return counter;
    }

    public static int divide2(int a, int b) {
        int iterationsCounter = 0;

        int remains = a;
        int counter = 0;
        int power = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(power);
        while (remains >= b) {
            int curr = power * b;
            if (remains >= curr) {
                remains -= curr;
                counter += power;

                stack.push(power);
                power *= 2;
            } else {
                power = stack.pop();
            }

            iterationsCounter++;
        }
        System.out.println(String.format("Division: %d/%d. Iterations performed: %d", a, b, iterationsCounter));
        return counter;
    }
}
