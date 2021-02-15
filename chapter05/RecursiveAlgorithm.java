package chapter05;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

import chapter3.linkedlist.CircularDoublyLinkedList;
import chapter3.linkedlist.CircularlyLinkedList;

public class RecursiveAlgorithm {
  public static long diskUsage(final File root) {
    long total = root.length();
    if (root.isDirectory()) {
      for (String childName : root.list()) {
        final File childFolder = new File(root, childName);
        System.out.println(childFolder.length() + "\t" + childFolder.getName());
        total = total + childFolder.length();
      }
    }
    System.out.println(total + "\t" + root);
    return total;
  }

  public static void diskTree(final File root,
                              final int level) {
    printFolder(level, root.getName(), root.length());
    if (root.isDirectory() && root.list() != null) {
      for (String childName : Objects.requireNonNull(root.list())) {
        diskTree(new File(root, childName), level+1);
      }
    }
  }

  private static void printFolder(final int level,
                                  final String name,
                                  final long bytes) {
    System.out.println(" ".repeat(Math.max(0, level*5)) +
        "|___ " + name + " " + (double)bytes/1000 + "kbs");
  }

  public static boolean binarySearch(final int[] data,
                                     final int target,
                                     final int low,
                                     final int high) {
    if (low > high) {
      return false;
    } else {
      final int mid = (low + high)/2;
      if (target == data[mid]) {
        return true;
      } else if (target < data[mid]) {
        return binarySearch(data, target, low, mid-1);
      } else{
        return binarySearch(data, target, mid+1, high);
      }
    }
  }

  public static boolean linearSearch(final int[] data,
                                     final int target) {
    if (data == null || data.length == 0) {
      return false;
    }
    for (int value : data) {
      if (value == target) {
        return true;
      }
    }
    return false;
  }

  public static void drawRuler(final int nInches,
                               final int majorLength) {
    drawLine(majorLength, 0);
    for (int i = 1; i < nInches; i++) {
      drawInterval(majorLength-1);
      drawLine(majorLength, i);
    }
  }

  private static void drawInterval(final int centralLength) {
    if (centralLength >= 1) {
      drawInterval(centralLength-1);
      drawLine(centralLength);
      drawInterval(centralLength-1);
    }
  }

  private static void drawLine(final int tickLength,
                               final int tickLabel) {
    for (int i = 0; i < tickLength; i++) {
      System.out.print("-");
    }
    if (tickLabel >= 0) {
      System.out.print(" " + tickLabel);
    }
    System.out.print("\n");
  }

  private static void drawLine(final int tickLength) {
    drawLine(tickLength, -1);
  }

  public static int linearRecursionSum(final int[] data,
                                       final int n) {
    if (n == 0) {
      return 0;
    } else {
      return linearRecursionSum(data, n-1) + data[n-1];
    }
  }

  public static void reverseArray(final int[] data,
                                  final int low,
                                  final int high) {
    if (low < high) {
      int temp = data[low];
      data[low] = data[high];
      data[high] = temp;
      reverseArray(data, low+1, high-1);
    }
  }

  public static double powerRecursive(final double x,
                                      final int n) {
    if (n == 0) {
      return 1;
    } else {
      return x * powerRecursive(x, n - 1);
    }
  }

  public static double powerRecursiveImproved(final double x,
                                              final int n) {
    if (n == 0) {
      return 1;
    } else {
      double temp = powerRecursive(x, n/2);
      double result = temp * temp;
      if (n % 2 != 0) {
        result *= x;
      }
      return result;
    }
  }

  public static int binaryRecursionSum(final int[] data,
                                       final int low,
                                       final int high) {
    if (low > high) {
      return 0;
    } else if (low == high) {
      return data[low];
    } else {
      int mid = (low + high)/2;
      return binaryRecursionSum(data, low, mid) +
          binaryRecursionSum(data, mid+1, high);
    }
  }

  public static <T extends Object> void printAllPossibleSequence(final int k,
                                              final CircularDoublyLinkedList<T> s,
                                              final CircularDoublyLinkedList<T> u) {
    int i = 0;
    while (i++ < u.size()) {
      s.addLast(u.removeFirst());
      if (k == 1) {
        System.out.println(s.toString());
      } else {
        System.out.println(s.toString());
        printAllPossibleSequence(k - 1, s, u);
      }
      u.addFirst(s.removeLast());
      u.rotate();
    }
  }

  public static long[] goodFibonacci(final int n) {
    if (n <= 1) {
      return new long[]{n, 0};
    } else {
      final long[] temp = goodFibonacci(n-1);
      return new long[]{temp[0] + temp[1], temp[0]};
    }
  }

  public static long badFibonacci(final int n) {
    if (n <= 1) {
      return n;
    } else {
      return badFibonacci(n-2) + badFibonacci(n-1);
    }
  }

  public static void main(final String[] args) {
    final Random random = new Random();
    final int arraySize = 1000;
    final int[] data = new int[arraySize];
    for (int i = 0; i < arraySize; i ++) {
      data[i] = random.nextInt();
    }

    final long start = System.nanoTime();
    System.out.println(goodFibonacci(50)[0]);
    final long end = System.nanoTime();
    System.out.println("Execution time: " + ((double) end - (double) start)/Math.pow(10, 9) + "s");

    final long start1 = System.nanoTime();
    System.out.println(badFibonacci(50));
    final long end1 = System.nanoTime();
    System.out.println("Execution time: " + ((double) end1 - (double) start1)/Math.pow(10, 9) + "s");

//    final int k = 4;
//    final CircularDoublyLinkedList<Character> s = new CircularDoublyLinkedList<>();
//    final CircularDoublyLinkedList<Character> u = new CircularDoublyLinkedList<>();
//    u.addLast('a');
//    u.addLast('b');
//    u.addLast('c');
//    u.addLast('e');
//    printAllPossibleSequence(k,s,u);


//    RecursiveAlgorithm.drawRuler(3, 5);
//
//    final long start2 = System.nanoTime();
//    System.out.println(linearSearch(data, target));
//    final long end2 = System.nanoTime();
//    System.out.println("Execution time: " + ((double) end2 - (double) start2)/Math.pow(10, 9) + "s");
//
//    final long start1 = System.nanoTime();
//    Arrays.sort(data);
//    System.out.println(binarySearch(data, target, 0, data.length-1));
//    final long end1 = System.nanoTime();
//    System.out.println("Execution time: " + ((double) end1 - (double) start1)/Math.pow(10, 9) + "s");

//    RecursiveAlgorithm.diskTree(
//        new File("C:\\Users\\son.nguyenthai\\Downloads"), 0);


//    final long start1 = System.nanoTime();
//    Arrays.sort(data);
//    reverseArray(data, 0, data.length-1);
//    System.out.println(powerRecursive(7, 10000));
//    final long end1 = System.nanoTime();
//    System.out.println("Execution time: " + ((double) end1 - (double) start1)/Math.pow(10, 9) + "s");

//    final long start2 = System.nanoTime();
//    Arrays.sort(data);
//    reverseArray(data, 0, data.length-1);
//    System.out.println(powerRecursiveImproved(7, 10000));
//    final long end2 = System.nanoTime();
//    System.out.println("Execution time: " + ((double) end2 - (double) start2)/Math.pow(10, 9) + "s");
  }
}
