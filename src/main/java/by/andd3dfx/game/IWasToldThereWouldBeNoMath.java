package by.andd3dfx.game;

import lombok.SneakyThrows;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * --- Day 2: I Was Told There Would Be No Math ---
 *
 * The elves are running low on wrapping paper, and so they need to submit an order for more. They have a list of the dimensions (length l, width w, and height h) of each present, and only want to order exactly as much as they need.
 *
 * Fortunately, every present is a box (a perfect right rectangular prism), which makes calculating the required wrapping paper for each gift a little easier: find the surface area of the box, which is 2*l*w + 2*w*h + 2*h*l. The elves also need a little extra paper for each present: the area of the smallest side.
 *
 * For example:
 *
 *     A present with dimensions 2x3x4 requires 2*6 + 2*12 + 2*8 = 52 square feet of wrapping paper plus 6 square feet of slack, for a total of 58 square feet.
 *     A present with dimensions 1x1x10 requires 2*1 + 2*10 + 2*10 = 42 square feet of wrapping paper plus 1 square foot of slack, for a total of 43 square feet.
 *
 * All numbers in the elves' list are in feet. How many total square feet of wrapping paper should they order?
 * </pre>
 *
 * @see <a href="https://youtu.be/RRyUtaNnntI">Video solution</a>
 */
public class IWasToldThereWouldBeNoMath {

    public static int calculate(List<String> dimensionsList) {
        int result = 0;
        for (var dimensions : dimensionsList) {
            var dimensionStrings = dimensions.split("x");
            var sortedDimensions = Arrays.stream(dimensionStrings).map(NumberUtils::toInt)
                    .sorted()
                    .toList();
            result += fullArea(sortedDimensions) + areaOfSmallestSide(sortedDimensions);
        }
        return result;
    }

    private static int fullArea(List<Integer> dimension) {
        return 2 * (dimension.get(0) * dimension.get(1)
                + dimension.get(1) * dimension.get(2)
                + dimension.get(2) * dimension.get(0));
    }

    private static int areaOfSmallestSide(List<Integer> dimension) {
        return dimension.get(0) * dimension.get(1);
    }

    @SneakyThrows
    public static void main(String[] args) {
        var lines = read("/game/i-was-told-there-would-be-no-math.txt");
        var result = calculate(lines);
        System.out.println(result);
    }

    private static List<String> read(String filePathName) throws IOException {
        InputStream inputStream = IWasToldThereWouldBeNoMath.class.getResourceAsStream(filePathName);
        var result = new ArrayList<String>();
        try (var br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        }
        return result;
    }
}
