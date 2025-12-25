package by.andd3dfx.core.predict;

import java.util.stream.Stream;

/**
 * <pre>
 * Что будет выведено в консоль?
 *
 *   public static Stream<String> bar(Stream<String> stream) {
 *   System.out.println("start bar");
 *       return stream.filter(el -> !el.equals("bar"))
 *               .peek(System.out::print);
 *   }
 *
 *   public static void main(String[] args) {
 *       Stream<String> stream = Stream.of("foo", "bar", "foo", "bar");
 *       Stream<String> result = bar(stream);
 *   }
 * </pre>
 */
public class NoTerminalOpOnStream {

    public static Stream<String> bar(Stream<String> stream) {
        System.out.println("start bar");
        return stream.filter(el -> !el.equals("bar"))
            .peek(System.out::print);
    }

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("foo", "bar", "foo", "bar");
        Stream<String> result = bar(stream);

        /*
         * Кажется, что будет выведено 'foofoo', но на стриме не вызвана терминальная операция,
         * поэтому будет выведена только надпись `start bar`.
         */
    }
}
