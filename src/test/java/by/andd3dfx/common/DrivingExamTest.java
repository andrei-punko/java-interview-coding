package by.andd3dfx.common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static by.andd3dfx.common.DrivingExamTest.Action.END;
import static by.andd3dfx.common.DrivingExamTest.Action.EXECUTE;
import static by.andd3dfx.common.DrivingExamTest.Action.MARK_NEGATIVE;
import static by.andd3dfx.common.DrivingExamTest.Action.START;
import static org.assertj.core.api.Assertions.assertThat;

public class DrivingExamTest {

    enum Action {
        START, EXECUTE, MARK_NEGATIVE, END
    }

    class CustomExercise extends Exercise {
        List<Action> actionLog = new ArrayList<>();

        @Override
        public void start() {
            actionLog.add(START);
            super.start();
        }

        @Override
        public void execute() {
            actionLog.add(EXECUTE);
            super.execute();
        }

        @Override
        public void markNegativePoints() {
            actionLog.add(MARK_NEGATIVE);
            super.markNegativePoints();
        }

        @Override
        public void end() {
            actionLog.add(END);
            super.end();
        }
    }

    @Test
    public void executeExercise() {
        var exercise = new CustomExercise();

        DrivingExam.executeExercise(exercise);

        assertThat(exercise.actionLog).isEqualTo(List.of(START, EXECUTE, END));
    }

    @Test
    public void executeExerciseWhenStartFailed() {
        var exercise = new CustomExercise() {
            @Override
            public void start() {
                super.start();
                throw new RuntimeException();
            }
        };

        DrivingExam.executeExercise(exercise);

        assertThat(exercise.actionLog).isEqualTo(List.of(START, MARK_NEGATIVE, END));
    }

    @Test
    public void executeExerciseWhenExecuteFailed() {
        var exercise = new CustomExercise() {
            @Override
            public void execute() {
                super.execute();
                throw new RuntimeException();
            }
        };

        DrivingExam.executeExercise(exercise);

        assertThat(exercise.actionLog).isEqualTo(List.of(START, EXECUTE, MARK_NEGATIVE, END));
    }

    @Test
    public void executeExerciseWhenStartAndMarkNegativeFailed() {
        var exercise = new CustomExercise() {
            @Override
            public void start() {
                super.start();
                throw new RuntimeException();
            }

            @Override
            public void markNegativePoints() {
                super.markNegativePoints();
                throw new RuntimeException();
            }
        };

        DrivingExam.executeExercise(exercise);

        assertThat(exercise.actionLog).isEqualTo(List.of(START, MARK_NEGATIVE, END));
    }

    @Test
    public void executeExerciseWhenExecuteAndMarkNegativeFailed() {
        var exercise = new CustomExercise() {
            @Override
            public void execute() {
                super.execute();
                throw new RuntimeException();
            }

            @Override
            public void markNegativePoints() {
                super.markNegativePoints();
                throw new RuntimeException();
            }
        };

        DrivingExam.executeExercise(exercise);

        assertThat(exercise.actionLog).isEqualTo(List.of(START, EXECUTE, MARK_NEGATIVE, END));
    }
}
