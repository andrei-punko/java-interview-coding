package by.andd3dfx.common;

/**
 * <pre>
 * Implement the executeExercise() method by doing the following:
 * - Call exercise.start() at the start of the method.
 * - Call exercise.execute() if start() does not fail.
 * - If start() or execute() fail, an exception will be thrown. If that is the case,
 * then call exercise.markNegativePoints() (the exception should not propagate).
 * - Call exercise.end() at the end in any case.
 *
 * public class DriverExam {
 *   public static void executeExercise(IExercise exercise) {
 *     throw new UnsupportedOperationException("Waiting to be implemented.");
 *   }
 *
 *   public static void main(String[] args) {
 *     DriverExam.executeExercise(new Exercise());
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
 */
public class DriverExam {

  public static void executeExercise(IExercise exercise) {
    try {
      exercise.start();
      exercise.execute();
    } catch (Exception e) {
      exercise.markNegativePoints();
    } finally {
      exercise.end();
    }
  }
}

interface IExercise {

  void start() throws Exception;

  void execute();

  void markNegativePoints();

  void end();
}

class Exercise implements IExercise {

  public void start() {
    System.out.println("Start");
  }

  public void execute() {
    System.out.println("Execute");
  }

  public void markNegativePoints() {
    System.out.println("MarkNegativePoints");
  }

  public void end() {
    System.out.println("End");
  }
}
