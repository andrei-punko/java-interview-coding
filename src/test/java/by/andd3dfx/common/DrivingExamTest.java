package by.andd3dfx.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DrivingExamTest {

    class CustomExercise extends Exercise {
        boolean startCalled = false;
        boolean executeCalled = false;
        boolean markNegativePointsCalled = false;
        boolean endCalled = false;

        @Override
        public void start() {
            startCalled = true;
            super.start();
        }

        @Override
        public void execute() {
            executeCalled = true;
            super.execute();
        }

        @Override
        public void markNegativePoints() {
            markNegativePointsCalled = true;
            super.markNegativePoints();
        }

        @Override
        public void end() {
            endCalled = true;
            super.end();
        }
    }

    @Test
    public void executeExercise() {
        var exercise = new CustomExercise();

        DrivingExam.executeExercise(exercise);

        assertThat(exercise.startCalled).isTrue();
        assertThat(exercise.executeCalled).isTrue();
        assertThat(exercise.markNegativePointsCalled).isFalse();
        assertThat(exercise.endCalled).isTrue();
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

        assertThat(exercise.startCalled).isTrue();
        assertThat(exercise.executeCalled).isFalse();
        assertThat(exercise.markNegativePointsCalled).isTrue();
        assertThat(exercise.endCalled).isTrue();
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

        assertThat(exercise.startCalled).isTrue();
        assertThat(exercise.executeCalled).isTrue();
        assertThat(exercise.markNegativePointsCalled).isTrue();
        assertThat(exercise.endCalled).isTrue();
    }

    @Test
    public void executeExerciseWhenExecuteNMarkNegativePointsFailed() {
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

        assertThat(exercise.startCalled).isTrue();
        assertThat(exercise.executeCalled).isTrue();
        assertThat(exercise.markNegativePointsCalled).isTrue();
        assertThat(exercise.endCalled).isTrue();
    }
}
