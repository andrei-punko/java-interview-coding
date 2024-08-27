package by.andd3dfx.core.predict;

/**
 * <pre>
 * Что будет выведено в консоль?
 *
 * String string = "Hello";
 * string.concat(" World");
 * System.out.println(string);
 * </pre>
 */
public class ImmutableString {

    public static void main(String[] args) {
        String string = "Hello";
        string.concat(" World");
        System.out.println(string);

        /**
         * Будет выведено только 'Hello', т.к. String - immutable,
         * и результат вызова concat() попадет в другую строку,
         * которую никакой переменной не присвоили
         */
    }
}
