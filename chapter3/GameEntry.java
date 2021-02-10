package chapter3;

public class GameEntry {
  private String name;
  private int score;

  public GameEntry(final String n,
                   final int s) {
    name = n;
    score = s;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public String toString() {
    return "(" + name + ", " + score + ")";
  }
}
