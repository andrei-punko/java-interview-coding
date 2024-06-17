package by.andd3dfx.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PassportCheckpointTest {

    @Test
    public void testSolution1() {
        var solution = new PassportCheckpoint.Solution1();
        assertThat(solution.exit()).isNull();
        solution.enter("AB54321");
        solution.enter("UK32032");
        assertThat(solution.exit()).isEqualTo("AB54321");
        solution.enter("UK32033");
        assertThat(solution.exit()).isEqualTo("UK32032");
        assertThat(solution.exit()).isEqualTo("UK32033");
        assertThat(solution.exit()).isNull();
        assertThat(solution.exit()).isNull();
    }

    @Test
    public void testSolution2() {
        var solution = new PassportCheckpoint.Solution2();
        assertThat(solution.exit()).isNull();
        solution.enter("AB54321");
        solution.enter("UK32032");
        assertThat(solution.exit()).isEqualTo("AB54321");
        solution.enter("UK32033");
        assertThat(solution.exit()).isEqualTo("UK32032");
        assertThat(solution.exit()).isEqualTo("UK32033");
        assertThat(solution.exit()).isNull();
        assertThat(solution.exit()).isNull();
    }
}
