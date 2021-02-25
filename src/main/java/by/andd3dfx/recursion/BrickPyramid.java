package by.andd3dfx.recursion;

import java.util.HashMap;
import java.util.Map;

public class BrickPyramid {

    private static final Map<Position, Double> positionToPressureMap = new HashMap<>();

    public static double pressure(int row, int pos) {
        if (row < 0 || pos < 0 || row < pos) {
            throw new IllegalArgumentException("row and pos should satisfy conditions: row>=0, pos>=0, row>=pos");
        }

        Position position = new Position(row, pos);
        if (positionToPressureMap.containsKey(position)) {
            return positionToPressureMap.get(position);
        }

        double result = 0;
        if (pos > 0) result += 0.5 * (pressure(row - 1, pos - 1) + 1);
        if (pos < row) result += 0.5 * (pressure(row - 1, pos) + 1);
        positionToPressureMap.put(position, result);
        return result;
    }

    private static class Position {
        private final int row;
        private final int pos;

        private Position(int row, int pos) {
            this.row = row;
            this.pos = pos;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (row != position.row) return false;
            return pos == position.pos;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + pos;
            return result;
        }
    }
}
