package chapter04;

public class Exercise {

  public static void main(final String[] args) {
    final int[] data = {109,2,233,44,15,6,71,8,9,10};
    final ArrayClass array = new ArrayClass(data);
    array.findPeaks();
    System.out.println(array.getMax());
    System.out.println(array.getMin());
  }
}
