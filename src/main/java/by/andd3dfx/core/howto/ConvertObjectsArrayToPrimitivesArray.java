package by.andd3dfx.core.howto;

import java.util.Arrays;

/**
 * <pre>
 * How to convert an array of objects to an array of their primitive types?
 *
 * <a href="https://stackoverflow.com/questions/564392/converting-an-array-of-objects-to-an-array-of-their-primitive-types">See Q&A</a>
 * </pre>
 */
public class ConvertObjectsArrayToPrimitivesArray {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};

        int[] converted = Arrays.stream(array).mapToInt(value -> value).toArray();

        System.out.println(Arrays.toString(converted));
    }
}
