package by.andd3dfx.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * <pre>
 * Implement the function count(), which returns the number of lines from the InputStream
 * that contains text matching the provided string.
 *
 * For example, when the `String needle` is "there" and the `InputStream haystack` contains:
 *
 * 	Hello, there!
 * 	How are you today?
 * 	Yes, you over there.
 *
 * The count() function should return 2: {"Hello, there!" and "Yes, you over there."}.
 * </pre>
 *
 * @see <a href="https://youtu.be/XDIgxvYAGfY">Video solution</a>
 */
public class Needle {

    public static int count(String needle, InputStream haystack) throws IOException {
        try (var bufferedReader = new BufferedReader(new InputStreamReader(haystack))) {
            String line;
            var count = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(needle)) {
                    count++;
                }
            }
            return count;
        }
    }
}
