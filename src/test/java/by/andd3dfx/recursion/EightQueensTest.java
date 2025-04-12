package by.andd3dfx.recursion;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EightQueensTest {

    private EightQueens eightQueens;

    @Before
    public void setUp() throws Exception {
        eightQueens = new EightQueens();
    }

    @Test
    public void solveFor1x1() {
        EightQueens.Solution solution = eightQueens.solve(1);

        assertTrue(solution.isFound());
        checkAmountOfPositionedQueens(solution, 1);
        assertThat(solution.prettyPrint()).isEqualTo(new int[][]{
                {1}
        });
    }

    @Test
    public void solveFor2x2() {
        EightQueens.Solution solution = eightQueens.solve(2);

        assertFalse(solution.isFound());
    }

    @Test
    public void solveFor3x3() {
        EightQueens.Solution solution = eightQueens.solve(3);

        assertFalse(solution.isFound());
    }

    @Test
    public void solveFor4x4() {
        EightQueens.Solution solution = eightQueens.solve(4);

        assertTrue(solution.isFound());
        checkAmountOfPositionedQueens(solution, 4);
        assertThat(solution.prettyPrint()).isEqualTo(new int[][]{
                {0, 1, 0, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0},
                {0, 0, 1, 0}
        });
    }

    @Test
    public void solveFor5x5() {
        EightQueens.Solution solution = eightQueens.solve(5);

        assertTrue(solution.isFound());
        checkAmountOfPositionedQueens(solution, 5);
        assertThat(solution.prettyPrint()).isEqualTo(new int[][]{
                {1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0}
        });
    }

    @Test
    public void solveFor8x8() {
        EightQueens.Solution solution = eightQueens.solve(8);

        assertTrue(solution.isFound());
        checkAmountOfPositionedQueens(solution, 8);
        assertThat(solution.prettyPrint()).isEqualTo(new int[][]{
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0}
        });
    }

    @Test
    public void prettyPrint() {
        var solution = new EightQueens.Solution(true, new boolean[][]{
                {true, false},
                {false, true}
        });

        assertThat(solution.prettyPrint()).isEqualTo(new int[][]{
                {1, 0},
                {0, 1}
        });
    }

    @Test
    public void isLegalEmptyBoard() {
        assertTrue(eightQueens.isLegal(2, new boolean[][]{
                {false, false},
                {false, false}
        }));
    }

    @Test
    public void isLegalOneQueen() {
        assertTrue(eightQueens.isLegal(2, new boolean[][]{
                {true, false},
                {false, false}
        }));
    }

    @Test
    public void isLegalSameCol() {
        assertFalse(eightQueens.isLegal(2, new boolean[][]{
                {true, false},
                {true, false}
        }));
    }

    @Test
    public void isLegalSameRow() {
        assertFalse(eightQueens.isLegal(2, new boolean[][]{
                {true, true},
                {false, false}
        }));
    }

    @Test
    public void isLegalSameDiagonal() {
        assertFalse(eightQueens.isLegal(2, new boolean[][]{
                {true, false},
                {false, true}
        }));
    }

    private void checkAmountOfPositionedQueens(EightQueens.Solution solution, int size) {
        int queensAmount = 0;
        for (var isTakenFlags : solution.getCellsTaken()) {
            for (var isTaken : isTakenFlags) {
                if (isTaken) {
                    queensAmount++;
                }
            }
        }
        assertThat(queensAmount).isEqualTo(size);
    }
}