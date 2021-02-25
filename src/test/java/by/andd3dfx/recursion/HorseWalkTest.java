package by.andd3dfx.recursion;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HorseWalkTest {

    private HorseWalk horseWalk;

    @Before
    public void setUp() throws Exception {
        horseWalk = new HorseWalk();
    }

    @Test
    public void solveFor1x1Board() {
        int boardSize = 1;
        HorseWalk.Solution solution = horseWalk.solve(boardSize);

        assertTrue(solution.isFound);
        checkAreAllCellsVisited(boardSize, solution);
        assertThat(solution.log.toString(), is("[a1]"));
    }

    @Test
    public void solveFor4x4Board() {
        int boardSize = 4;
        HorseWalk.Solution solution = horseWalk.solve(boardSize);

        assertFalse(solution.isFound);
    }

    @Test
    public void solveFor5x5Board() {
        int boardSize = 5;
        HorseWalk.Solution solution = horseWalk.solve(boardSize);

        assertTrue(solution.isFound);
        checkAreAllCellsVisited(boardSize, solution);
        assertThat(solution.log.toString(), is("[a1, b3, c1, e2, d4, b5, a3, b1, d2, e4, c5, a4, b2, d1, e3, d5, c3, a2, b4, c2, e1, d3, e5, c4, a5]"));
    }

    @Test
    public void solveFor6x6Board() {
        int boardSize = 6;
        HorseWalk.Solution solution = horseWalk.solve(boardSize);

        assertTrue(solution.isFound);
        checkAreAllCellsVisited(boardSize, solution);
        assertThat(solution.log.toString(), is("[a1, b3, c1, d3, e1, f3, e5, c6, a5, c4, b2, a4, b6, d5, f6, e4, f2, d1, e3, f1, d2, b1, c3, a2, b4, c2, a3, b5, d6, f5, d4, e2, f4, e6, c5, a6]"));
    }

    private void checkAreAllCellsVisited(int boardSize, HorseWalk.Solution solution) {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                assertTrue(solution.cellsTaken[i][j]);
            }
        }
    }
}
