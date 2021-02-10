package chapter02;

public class GenericDemo {
  public static <T> void reverse(T[] data) {
    int low = 0;
    int high = data.length - 1;
    while (low < high) {
      T temp = data[low];
      data[low++] = data[high];
      data[high--] = temp;
    }
  }
}
