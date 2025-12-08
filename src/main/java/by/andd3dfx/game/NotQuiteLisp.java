package by.andd3dfx.game;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * <pre>
 * --- Day 1: Not Quite Lisp ---
 *
 * Santa was hoping for a white Christmas, but his weather machine's "snow" function is powered by stars, and he's fresh out! To save Christmas, he needs you to collect fifty stars by December 25th.
 *
 * Collect stars by helping Santa solve puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!
 *
 * Here's an easy puzzle to warm you up.
 *
 * Santa is trying to deliver presents in a large apartment building, but he can't find the right floor - the directions he got are a little confusing. He starts on the ground floor (floor 0) and then follows the instructions one character at a time.
 *
 * An opening parenthesis, (, means he should go up one floor, and a closing parenthesis, ), means he should go down one floor.
 *
 * The apartment building is very tall, and the basement is very deep; he will never find the top or bottom floors.
 *
 * For example:
 *
 *     (()) and ()() both result in floor 0.
 *     ((( and (()(()( both result in floor 3.
 *     ))((((( also results in floor 3.
 *     ()) and ))( both result in floor -1 (the first basement level).
 *     ))) and )())()) both result in floor -3.
 *
 * To what floor do the instructions take Santa?
 * </pre>
 *
 * @see <a href="https://youtu.be/7En4RJa6384">Video solution</a>
 */
public class NotQuiteLisp {

    @SneakyThrows
    public static int determineFloor(String input) {
        var result = 0;
        for (var ch : input.toCharArray()) {
            switch (ch) {
                case '(':
                    result++;
                    break;
                case ')':
                    result--;
                    break;
            }
        }

        return result;
    }

    @SneakyThrows
    public static void main(String[] args) {
        var inputString = readFromInputStream("/game/not-quite-lisp.txt");
        var result = determineFloor(inputString);
        System.out.println(result);
    }

    private static String readFromInputStream(String filePathName) throws IOException {
        InputStream inputStream = NotQuiteLisp.class.getResourceAsStream(filePathName);
        var resultStringBuilder = new StringBuilder();
        try (var br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
