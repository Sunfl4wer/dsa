package chapter04;

import java.util.Arrays;
import java.util.Random;

public class CodeFragment {
  public static boolean disjoint1(final int[] groupA,
                                  final int[] groupB,
                                  final int[] groupC) {
    for (int a : groupA) {
      for (int b : groupB) {
        for (int c : groupC) {
          if ((a == b) && (b == c)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  public static boolean disjoint2(final int[] groupA,
                                  final int[] groupB,
                                  final int[] groupC) {
    for (int a : groupA) {
      for (int b : groupB) {
        if (a == b) {
          for (int c : groupC) {
            if (b == c) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  public static boolean unique1(final int[] data) {
    for (int i = 0; i < data.length-1; i++) {
      for (int j = i+1; j < data.length; j++) {
        if (data[i] == data[j]) {
          return false;
        }
      }
    }
    return true;
  }

  public static boolean unique2(final int[] data) {
    int[] array = Arrays.copyOf(data, data.length);
    Arrays.sort(array);
    for (int i = 0; i < array.length-1; i++) {
      if (array[i] == array[i+1]) {
        return false;
      }
    }
    return true;
  }

  public static double[] prefixAverage1(final double[] data) {
    double[] a = new double[data.length];
    for (int i = 0; i < data.length; i++) {
      double sum = 0;
      for (int j = 0; j <= i; j++) {
        sum+=data[j];
      }
      a[i] = sum/(i+1);
    }
    return a;
  }

  public static double[] prefixAverage2(final double[] data) {
    double[] a = new double[data.length];
    double sum = 0;
    for (int i = 0; i < data.length; i++) {
      sum += data[i];
      a[i] = sum / (i + 1);
    }
    return a;
  }

  public int[] initIntegerArray(final int size) {
    final int[] array = new int[size];
    final Random random = new Random();
    for (int i = 0; i < size; i++) {
      array[i] = random.nextInt();
    }
    return array;
  }

  public double[] initDoubleArray(final int size) {
    final double[] array = new double[size];
    final Random random = new Random();
    for (int i = 0; i < size; i++) {
      array[i] = random.nextDouble();
    }
    return array;
  }

  public static void main(final String[] args) {

    final CodeFragment codeFragment = new CodeFragment();
    final int[] groupA = codeFragment.initIntegerArray(10000);
    final int[] groupB = codeFragment.initIntegerArray(10000);
    final int[] groupC = codeFragment.initIntegerArray(10000);
    final double[] doubleArray = codeFragment.initDoubleArray(10000);

    final long start = System.currentTimeMillis();
//    CodeFragment.disjoint1(groupA, groupB, groupC);
//    CodeFragment.unique1(groupA);
    double[] a1 = CodeFragment.prefixAverage1(doubleArray);
    final long end = System.currentTimeMillis();
    System.out.println("Execution time: " + ((double)end - (double)start)/1000 + "s");

    final long start1 = System.currentTimeMillis();
//    CodeFragment.disjoint2(groupA, groupB, groupC);
//    CodeFragment.unique2(groupA);
    double[] a2 = CodeFragment.prefixAverage2(doubleArray);
    final long end1 = System.currentTimeMillis();
    System.out.println("Execution time: " + ((double)end1 - (double)start1)/1000 + "s");

    System.out.println(Arrays.equals(a1, a2));
  }
}
