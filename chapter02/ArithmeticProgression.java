package chapter02;

public class ArithmeticProgression extends Progression{

  protected long increment;

  public ArithmeticProgression() {
    this(1, 0);
  }

  public ArithmeticProgression(final long stepSize) {
    this(stepSize, 0);
  }

  public ArithmeticProgression(final long stepSize,
                               final long start) {
    super(start);
    increment = stepSize;
  }

  protected void advance() {
    current += increment;
  }
}
