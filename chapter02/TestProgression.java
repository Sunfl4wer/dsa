package chapter02;

public class TestProgression {

  public static void main(final String[] args) {
    Progression progression;

    progression = new ArithmeticProgression();
    progression.printProgression(10);
    progression = new ArithmeticProgression(5);
    progression.printProgression(10);
    progression = new ArithmeticProgression(5, 2);
    progression.printProgression(10);

    progression = new GeometricProgression();
    progression.printProgression(10);
    progression = new GeometricProgression(3);
    progression.printProgression(10);

    progression = new FibonacciProgression();
    progression.printProgression(23);

    progression = new FibonacciProgression();
    progression.printProgressionFibonacciNumberStartWithTwoTwos();
  }
}
