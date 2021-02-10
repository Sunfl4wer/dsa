package chapter02;

public class GeometricProgression extends Progression{

  protected long base;

  public GeometricProgression() {
    this(2, 1);
  }

  public GeometricProgression(final long b) {
    this(b, 1);
  }

  public GeometricProgression(final long b,
                              final long start) {
    super(start);
    base = b;
  }

  protected void advance() {
    current *= base;
  }
}
