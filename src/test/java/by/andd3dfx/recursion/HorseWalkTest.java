package by.andd3dfx.recursion;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

public class HorseWalkTest {

    private HorseWalk horseWalk;

    @Before
    public void setUp() throws Exception {
        horseWalk = new HorseWalk();
    }

    @Test
    public void solveFor1x1Board() {
        commonSolve(1, true);
    }

    @Test
    public void solveFor2x2Board() {
        commonSolve(2, false);
    }

    @Test
    public void solveFor3x3Board() {
        commonSolve(3, false);
    }

    @Test
    public void solveFor4x4Board() {
        commonSolve(4, false);
    }

    @Test
    public void solveFor5x5Board() {
        commonSolve(5, true);
    }

    @Test
    public void solveFor6x6Board() {
        commonSolve(6, true);
    }

    @Test(expected = IllegalStateException.class)
    public void printSolutionWhenIsFoundEqualsToFalse() {
        Deque<HorseWalk.Cell> log = new ArrayDeque<>();
        log.add(new HorseWalk.Cell(0, 0));
        HorseWalk.Solution solution = new HorseWalk.Solution(false, new boolean[][]{{}}, log);
        System.out.println(solution.logToString());
    }

    @Test(expected = IllegalStateException.class)
    public void printSolutionWhenLogSizeLessThanExpectation() {
        Deque<HorseWalk.Cell> log = new ArrayDeque<>();
        HorseWalk.Solution solution = new HorseWalk.Solution(true, new boolean[][]{{}}, log);
        System.out.println(solution.logToString());
    }

    @Test(expected = IllegalStateException.class)
    public void printSolutionWhenLogSizeGreaterThanExpectation() {
        Deque<HorseWalk.Cell> log = new ArrayDeque<>();
        log.add(new HorseWalk.Cell(0, 0));
        log.add(new HorseWalk.Cell(0, 1));
        HorseWalk.Solution solution = new HorseWalk.Solution(true, new boolean[][]{{}}, log);
        System.out.println(solution.logToString());
    }

    @Test
    public void printSolution() {
        Deque<HorseWalk.Cell> log = new ArrayDeque<>();
        log.add(new HorseWalk.Cell(0, 0));
        HorseWalk.Solution solution = new HorseWalk.Solution(true, new boolean[][]{{}}, log);
        System.out.println(solution.logToString());
    }

    @Test
    public void cell() {
        assertThat(new HorseWalk.Cell(0, 0).convertToCheckMateCoordinateSystem()).isEqualTo("a1");
        assertThat(new HorseWalk.Cell(2, 3).convertToCheckMateCoordinateSystem()).isEqualTo("c4");
    }

    private void commonSolve(int boardSize, boolean solutionExpected) {
        HorseWalk.Solution solution = horseWalk.solve(boardSize);

        assertThat(solution.isFound()).isEqualTo(solutionExpected);
        if (solution.isFound()) {
            checkAreAllCellsVisited(boardSize, solution);
            System.out.println(solution.logToString());
        }
    }

    private void checkAreAllCellsVisited(int boardSize, HorseWalk.Solution solution) {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                assertThat(solution.getCellsTaken()[i][j]).isTrue();
            }
        }
    }
}
