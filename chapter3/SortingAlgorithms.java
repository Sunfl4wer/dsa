package chapter3;

import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithms {
  public static void insertionSort(final char[] data) {
    final long startTime = System.nanoTime();

    int length = data.length;
    for (int i = 1; i<length; i++) {
      final char current = data[i];
      int j = i;
      while (j > 0 && data[j-1] > current) {
        data[j] = data[j-1];
        j--;
      }
      data[j] = current;
    }

    final long endTime = System.nanoTime();
    System.out.println("Time to complete: " + (endTime - startTime)/Math.pow(10, 9) + "s");
  }

  public static void main(final String[] args) {
    final Random r = new Random();
    final char[] inArray = new char[1000000];
    final char[] inArray1 = new char[1000000];
    for (int i = 0; i < inArray.length; i++) {
      final char temp = (char)(r.nextInt(26)+'a');
      inArray[i] = temp;
      inArray1[i] = temp;
    }
    insertionSort(inArray);
    final long startTime = System.nanoTime();
    Arrays.sort(inArray1);
    final long endTime = System.nanoTime();
    System.out.println("Time to complete: " + (endTime - startTime)/Math.pow(10, 9) + "s");
  }
}
