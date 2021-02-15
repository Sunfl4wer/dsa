package chapter05;

import java.util.Arrays;
import java.util.Random;

import chapter3.linkedlist.CircularDoublyLinkedList;
import chapter3.linkedlist.CircularlyLinkedList;
import chapter3.linkedlist.DoublyLinkedList;

public class Exercise {
  public static long max(final long[] data) {
    return maxBinaryRecursion(data, 0, data.length-1);
  }

  public static double harmonicNumberRecursive(final int n) {
    if (n == 1) {
      return n;
    } else {
      final double result = 1/(double)n + harmonicNumberRecursive(n-1);
      System.out.println(result);
      return result;
    }
  }

  public static double harmonicNumberNonRecursive(final int n) {
    double h = 0;
    for (double i = 1; i <= n; i++) {
     h += 1/i;
    }
    return h;
  }

  public static int binarySearchModified(final int[] data,
                                             final int target,
                                             final int low,
                                             final int high) {
    if (low > high) {
      return -1;
    } else {
      final int mid = (low + high)/2;
      if (target == data[mid]) {
        return mid;
      } else if (target < data[mid]) {
        return binarySearchModified(data, target, low, mid-1);
      } else{
        return binarySearchModified(data, target, mid+1, high);
      }
    }
  }

  public static long maxBinaryRecursion(final long[] data,
                                        final int low,
                                        final int high) {
    if (low == high) {
      return data[low];
    } else if (high-low == 1) {
      return Math.max(data[low], data[high]);
    } else {
      int mid = (low+high)/2;
      long first = maxBinaryRecursion(data, low, mid);
      long second = maxBinaryRecursion(data, mid+1, high);
      return Math.max(first, second);
    }
  }

  public static long linearMaxFinding(final long[] data,
                                      final int n) {
    if (data == null || data.length == 0) {
      throw new IndexOutOfBoundsException();
    } else if (n == 0) {
      return data[n];
    } else {
      long previousResult = linearMaxFinding(data, n-1);
      return Math.max(data[n], previousResult);
    }
  }

  public static long stringToLong(final String str) {
    if (str.length() == 1) {
      return str.charAt(0)-'0';
    } else {
      return str.charAt(str.length()-1)-'0'
          + stringToLong(str.substring(0,str.length()-1))*10;
    }
  }

  public static long nonRecursivePower(final int x,
                                       final int n) {
    int mid = n/2;
    long result = x;
    while (mid-- > 0) {
      result = result*result;
    }
    return n % 2 == 0 ? result : result*x;
  }

  public static boolean isUniqueArray(final long[] data) {
    return isUniqueArray(data, 0, data.length-1);
  }

  public static boolean isUniqueArray(final long[] data,
                                      final int low,
                                      final int high) {
    if (low >= high) {
      return true;
    } else {
      for (int i = low; i < high; i++) {
        if (data[i] == data[high]) {
          return false;
        }
      }
      return isUniqueArray(data, low, high-1);
    }
  }

  public static int baseNLogarithm(final int x,
                                   final int n) {
    if (x < n) {
      return 0;
    }
    return 1+baseNLogarithm(x/n, n);
  }

  public static long multiply(final int n,
                              final int m) {
    if (n > m) {
      return multiplyWithRecursive(n, m);
    }
    return multiplyWithRecursive(m,n);
  }

  public static long multiplyWithRecursive(final int x,
                                           final int n) {
    if (n == 1) {
      return x;
    } else {
      int half = n/2;
      final long result = multiplyWithRecursive(x, half);
      return n % 2 == 0 ? result+result : result+result+x;
    }
  }


  public static void printSubset(final Object[] data) throws CloneNotSupportedException {
    final CircularDoublyLinkedList<Object> list = new CircularDoublyLinkedList<>(data);
    final CircularDoublyLinkedList<Object> subSet = new CircularDoublyLinkedList<>();
    RecursiveAlgorithm.printAllPossibleSequence(list.size(), subSet, list);
  }

  public static void main(final String[] args) {
    final Random random = new Random();
    final int arraySize = 6;
    final Integer[] data = new Integer[arraySize];
    for (int i = 0; i < arraySize; i++) {
      data[i] = random.nextInt();
    }

//    final Long[] data = new Long[]{1L,2L,3L};
    long start;
    long end;
    int x = 1000;
    int y = 10000;

    start = System.nanoTime();
    try {
      printSubset(data);
    } catch (Exception ignore) {

    }
    end = System.nanoTime();
    System.out.println("Execution time: " + ((double) end - (double) start)/Math.pow(10, 9) + "s");
  }
}
