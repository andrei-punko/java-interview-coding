package by.andd3dfx.numeric;

/**
 * Реализовать функцию решения уравнения вида ax^2 + bx + c = 0.
 */
public class QuadraticEquation {

    public static double[] solve(int a, int b, int c) {
        var d = b * b - 4 * a * c;
        if (d < 0) {
            return null;
        }
        return new double[]{(-b - Math.sqrt(d)) / (2 * a), (-b + Math.sqrt(d)) / (2 * a)};
    }
}
