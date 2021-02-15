package chapter3.exercise;

import chapter3.Matrix;

public class P336 {
  public static void main(final String[] args) throws CloneNotSupportedException {
    final int[][] firstMatrix = {{1,2}};
    final int[][] secondMatrix = {{1},{2}};
    final Matrix matrix1 = new Matrix(firstMatrix);
    final Matrix matrix2 = new Matrix(secondMatrix);
    System.out.println(matrix1.toString());
    System.out.println(matrix2.toString());
    System.out.println(matrix1.multiply(matrix2).toString());
  }
}
