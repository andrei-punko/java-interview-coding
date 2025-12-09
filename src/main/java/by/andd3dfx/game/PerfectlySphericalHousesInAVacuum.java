package by.andd3dfx.game;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * --- Day 3: Perfectly Spherical Houses in a Vacuum ---
 *
 * Santa is delivering presents to an infinite two-dimensional grid of houses.
 *
 * He begins by delivering a present to the house at his starting location, and then an elf at the North Pole calls him via radio and tells him where to move next. Moves are always exactly one house to the north (^), south (v), east (>), or west (<). After each move, he delivers another present to the house at his new location.
 *
 * However, the elf back at the North Pole has had a little too much eggnog, and so his directions are a little off, and Santa ends up visiting some houses more than once. How many houses receive at least one present?
 *
 * For example:
 *
 *     > delivers presents to 2 houses: one at the starting location, and one to the east.
 *     ^>v< delivers presents to 4 houses in a square, including twice to the house at his starting/ending location.
 *     ^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses.
 *
 * Your puzzle answer was 2081.
 *
 * --- Part Two ---
 *
 * The next year, to speed up the process, Santa creates a robot version of himself, Robo-Santa, to deliver presents with him.
 *
 * Santa and Robo-Santa start at the same location (delivering two presents to the same starting house), then take turns moving based on instructions from the elf, who is eggnoggedly reading from the same script as the previous year.
 *
 * This year, how many houses receive at least one present?
 *
 * For example:
 *
 *     ^v delivers presents to 3 houses, because Santa goes north, and then Robo-Santa goes south.
 *     ^>v< now delivers presents to 3 houses, and Santa and Robo-Santa end up back where they started.
 *     ^v^v^v^v^v now delivers presents to 11 houses, with Santa going one direction and Robo-Santa going the other.
 *
 * Your puzzle answer was 2341.
 *  </pre>
 *
 * @see <a href="https://youtu.be/NGsUsBGIrYA">Video solution, Part 1</a>
 * @see <a href="https://youtu.be/V5fPufcno8Q">Video solution, Part 2</a>
 */
public class PerfectlySphericalHousesInAVacuum {

    private static final int X0 = 0;
    private static final int Y0 = 0;

    public static int countHouses(String directionsString) {
        var x = X0;
        var y = Y0;
        Set<String> visited = new HashSet<>();
        visited.add(x + "," + y);

        for (var ch : directionsString.toCharArray()) {
            switch (ch) {
                case '<':
                    x--;
                    break;
                case '>':
                    x++;
                    break;
                case '^':
                    y++;
                    break;
                case 'v':
                    y--;
                    break;
            }
            visited.add(x + "," + y);
        }
        return visited.size();
    }

    public static int countHouses2(String directionsString) {
        var xSanta = X0;
        var ySanta = Y0;

        var xRobo = X0;
        var yRobo = Y0;

        Set<String> visited = new HashSet<>();
        visited.add(X0 + "," + Y0);
        boolean isSantaTurn = true;

        for (var ch : directionsString.toCharArray()) {
            switch (ch) {
                case '<':
                    int _1 = isSantaTurn ? xSanta-- : xRobo--;
                    break;
                case '>':
                    int _2 = isSantaTurn ? xSanta++ : xRobo++;
                    break;
                case '^':
                    int _3 = isSantaTurn ? ySanta++ : yRobo++;
                    break;
                case 'v':
                    int _4 = isSantaTurn ? ySanta-- : yRobo--;
                    break;
            }
            visited.add(xSanta + "," + ySanta);
            visited.add(xRobo + "," + yRobo);

            isSantaTurn = !isSantaTurn;
        }
        return visited.size();
    }

    @SneakyThrows
    public static void main(String[] args) {
        String directionsString = read("/game/perfectly-spherical-houses-in-a-vacuum.txt");
        var result = PerfectlySphericalHousesInAVacuum.countHouses(directionsString);
        var result2 = PerfectlySphericalHousesInAVacuum.countHouses2(directionsString);
        System.out.println(result + ", " + result2);
    }

    private static String read(String filePathName) throws IOException {
        InputStream inputStream = PerfectlySphericalHousesInAVacuum.class.getResourceAsStream(filePathName);
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
