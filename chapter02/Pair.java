package chapter02;

public class Pair<A, B> {
  A first;
  B second;
  public Pair(final A a,
              final B b) {
    first = a;
    second = b;
  }

  public A getFirst() {
    return first;
  }

  public B getSecond() {
    return second;
  }
}
