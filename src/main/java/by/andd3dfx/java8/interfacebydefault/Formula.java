package by.andd3dfx.java8.interfacebydefault;

public interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
