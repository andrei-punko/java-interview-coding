package by.andd3dfx.parser.txt;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://youtu.be/4DGhiBXFhUc">Video solution</a>
 */
public class LogsTxtParser {

    @SneakyThrows
    public static List<String> parse(String filePath) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
                // Make some action with each line here
            }
        }
        // Make action with whole lines here

        return result;
    }
}
