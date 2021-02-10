package chapter02;

public class Progression {

  protected long current;

  public Progression() {
    this(0);
  }

  public Progression(final long start) {
    current = start;
  }

  public long nextValue() {
    final long answer = current;
    advance();
    return answer;
  }

  protected void advance() {
    current++;
  }

  public void printProgression(final int n) {
    System.out.print(nextValue());
    for (int j=1; j<n; j++) {
      System.out.print(" " + nextValue());
    }
    System.out.println();
  }

  public void printProgressionFibonacciNumberStartWithTwoTwos() {
    long nextValue = nextValue();
    while (!startWithTwoTwos(nextValue)) {
      nextValue  = nextValue();
    }
    System.out.print(nextValue);
    System.out.print(getEighthValue(nextValue));
  }

  private boolean startWithTwoTwos(final long value) {
    boolean isValid = false;
    long divisor = 1;
    while (value > divisor) {
      if (((value / divisor) == 22)) {
        isValid = true;
        break;
      }
      divisor = divisor*10;
    }
    return isValid;
  }

  private long getEighthValue(final long value) {
    final long upper = 100000000;
    if (upper > value) {
      return 0;
    }
    return value / upper % 10;
  }
}
