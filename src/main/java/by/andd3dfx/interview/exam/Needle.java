package by.andd3dfx.interview.exam;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Implement the function count(), which returns the number of lines from the InputStream that contains text
 * matching the provided string.
 * <p>
 * For example, when the `String needle` is "there" and the `InputStream haystack` contains:
 * <pre>
 * 	Hello, there!
 * 	How are you today?
 * 	Yes, you over there.
 * </pre>
 * The count() function should return 2 {"Hello, there!" and "Yes, you over there."}.
 */
public class Needle {

  public static int count(String needle, InputStream haystack) throws Exception {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(haystack));
    String line;
    int count = 0;
    while ((line = bufferedReader.readLine()) != null) {
      if (line.contains(needle)) {
        count++;
      }
    }
    return count;
  }
}
