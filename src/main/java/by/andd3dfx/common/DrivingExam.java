package by.andd3dfx.common;

import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * Implement the executeExercise() method by doing the following:
 * - Call exercise.start() at the start of the method.
 * - Call exercise.execute() if start() does not fail.
 * - If start() or execute() fail, an exception will be thrown. If that is the case,
 * then call exercise.markNegativePoints() (the exception should not propagate).
 * - Call exercise.end() at the end in any case.
 *
 * public class DrivingExam {
 *   public static void executeExercise(IExercise exercise) {
 *     throw new UnsupportedOperationException("Waiting to be implemented.");
 *   }
 *
 *   public static void main(String[] args) {
 *     DrivingExam.executeExercise(new Exercise());
 *   }
 * }
 *
 *  interface IExercise {
 *    void start() throws Exception;
 *    void execute();
 *    void markNegativePoints();
 *    void end();
 *  }
 *
 * class Exercise implements IExercise {
 *   public void start() { System.out.println("Start"); }
 *   public void execute() { System.out.println("Execute"); }
 *   public void markNegativePoints() { System.out.println("MarkNegativePoints"); }
 *   public void end() { System.out.println("End"); }
 * }
 * </pre>
 *
 * @see <a href="https://youtu.be/HmQ4u9UFOVQ">Video solution</a>
 */
public class DrivingExam {

    public static void executeExercise(IExercise exercise) {
        try {
            exercise.start();
            exercise.execute();
        } catch (Exception e) {
            markNegativePoints(exercise);
        } finally {
            exercise.end();
        }
    }

    private static void markNegativePoints(IExercise exercise) {
        try {
            exercise.markNegativePoints();
        } catch (Exception e) {
            // do nothing
        }
    }
}

interface IExercise {

    void start() throws Exception;

    void execute();

    void markNegativePoints();

    void end();
}

@Slf4j
class Exercise implements IExercise {

    @Override
    public void start() {
        log.info("Start");
    }

    @Override
    public void execute() {
        log.info("Execute");
    }

    @Override
    public void markNegativePoints() {
        log.info("MarkNegativePoints");
    }

    @Override
    public void end() {
        log.info("End");
    }
}
