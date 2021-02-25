package by.andd3dfx.recursion;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EightQueensTest {

    private EightQueens eightQueens;

    @Before
    public void setup() {
        eightQueens = new EightQueens();
    }

    @Test
    public void solveFor1x1() {
        EightQueens.Solution solution = eightQueens.solve(1);

        assertTrue(solution.isFound);
        assertTrue("Solution for 1x1 board", solution.cellsTaken[0][0]);
    }

    @Test
    public void solveFor2x2() {
        EightQueens.Solution solution = eightQueens.solve(2);

        assertFalse("Solution for 2x2 board doesn't exist", solution.isFound);
    }

    @Test
    public void solveFor3x3() {
        EightQueens.Solution solution = eightQueens.solve(3);

        assertFalse("Solution for 3x3 board doesn't exist", solution.isFound);
    }

    @Test
    public void solveFor4x4() {
        EightQueens.Solution solution = eightQueens.solve(4);

        assertTrue(solution.isFound);
        assertThat("Solution for 4x4 board", solution.cellsTaken, is(new boolean[][]{
                {false, true, false, false},
                {false, false, false, true},
                {true, false, false, false},
                {false, false, true, false},
        }));
    }

    @Test
    public void solveFor8x8() {
        EightQueens.Solution solution = eightQueens.solve(8);

        assertTrue(solution.isFound);
        assertThat("Solution for 8x8 board", solution.cellsTaken, is(new boolean[][]{
                {true, false, false, false, false, false, false, false},
                {false, false, false, false, true, false, false, false},
                {false, false, false, false, false, false, false, true},
                {false, false, false, false, false, true, false, false},
                {false, false, true, false, false, false, false, false},
                {false, false, false, false, false, false, true, false},
                {false, true, false, false, false, false, false, false},
                {false, false, false, true, false, false, false, false}
        }));
    }

    @Test
    public void isLegal() {
        assertTrue("empty board", eightQueens.isLegal(2, new boolean[][]{{false, false}, {false, false}}));

        assertTrue("one queen", eightQueens.isLegal(2, new boolean[][]{{true, false}, {false, false}}));

        assertTrue("two queens", eightQueens.isLegal(3, new boolean[][]{{true, false, false}, {false, false, true}, {false, false, false}}));

        assertFalse("same row", eightQueens.isLegal(2, new boolean[][]{{true, true}, {false, false}}));

        assertFalse("same column", eightQueens.isLegal(2, new boolean[][]{{true, false}, {true, false}}));

        assertFalse("same diagonal", eightQueens.isLegal(2, new boolean[][]{{true, false}, {false, true}}));
    }
}
