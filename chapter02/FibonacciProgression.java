package chapter02;

public class FibonacciProgression extends Progression {

  protected long prev;
  protected long prevPrev;

  public FibonacciProgression() {
    this(0, 1);
  }

  public FibonacciProgression(final long first,
                              final long second) {
    super(first);
    prev = second - first;
  }

  protected void advance() {
    prevPrev = prev;
    prev = current;
    current += prevPrev;
  }
}
