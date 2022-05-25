package by.andd3dfx.java8.stream;

import java.util.List;

public class PredictStreamOutput {

    /**
     * It should be: 123455
     */
    public static void case1() {
        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .stream()
                .peek(i -> System.out.print(i))
                .filter(i -> i > 4)
                .peek(i -> System.out.print(i))
                .findAny();
    }

    public static void main(String[] args) {
        case1();
    }
}
