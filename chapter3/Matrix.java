package chapter3;

import java.security.InvalidParameterException;

import chapter3.linkedlist.SinglyLinkedList;

public class Matrix implements Cloneable {
  private int noColumn;

  public int getNoColumn() {
    return noColumn;
  }

  public void setNoColumn(int noColumn) {
    this.noColumn = noColumn;
  }

  public int getNoRow() {
    return noRow;
  }

  public void setNoRow(int noRow) {
    this.noRow = noRow;
  }

  private int noRow;

  public SinglyLinkedList<SinglyLinkedList<Integer>> getMatrix() {
    return matrix;
  }

  public void setMatrix(SinglyLinkedList<SinglyLinkedList<Integer>> matrix) {
    this.matrix = matrix;
  }

  private SinglyLinkedList<SinglyLinkedList<Integer>> matrix;

  public Matrix() {
    noColumn = 0;
    noRow = 0;
    matrix = new SinglyLinkedList<>();
  }

  public Matrix(final int[][] inputMatrix) throws InvalidParameterException {
    noRow = inputMatrix.length;
    for (int i = 0; i < noRow-1; i++) {
      if (inputMatrix[i].length != inputMatrix[i+1].length) {
        throw new InvalidParameterException("Invalid matrix size!");
      }
    }
    noColumn = inputMatrix[0].length;
    this.matrix = new SinglyLinkedList<>();
    for (int i = 0; i < noRow; i++) {
      final SinglyLinkedList<Integer> row = new SinglyLinkedList<>();
      for (int j = 0; j < noColumn; j++) {
        row.addLast(inputMatrix[i][j]);
      }
      this.matrix.addLast(row);
    }
  }

  public Matrix(final int noRow,
                final int noColumn) {
    this.noRow = noRow;
    this.noColumn = noColumn;
    matrix = new SinglyLinkedList<>();
    for (int i = 0; i < noRow; i++) {
      final SinglyLinkedList<Integer> row = new SinglyLinkedList<>();
      for (int j = 0; j < noColumn; j++) {
        row.addLast(0);
      }
      matrix.addLast(row);
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    if (noRow != 0 || noColumn != 0) {
      for (int i = 0; i < noRow; i++) {
        final SinglyLinkedList<Integer> row = matrix.getValueAt(i);
        for (int j = 0; j < noColumn; j++) {
          sb.append(row.getValueAt(j).toString());
          if (j != noColumn - 1) {
            sb.append(' ');
          }
        }
        if (i != noRow - 1) {
          sb.append('\n');
        }
      }
    }
    return sb.toString();
  }

  @Override
  public Matrix clone() throws CloneNotSupportedException {
    Matrix cloned = (Matrix)super.clone();
    cloned.matrix = new SinglyLinkedList<>();
    for (int i = 0; i < noRow; i++) {
      cloned.matrix.addLast(matrix.getValueAt(i).clone());
    }
    return cloned;
  }

  public Integer getValueAt(final int i,
                            final int j) {
    if (i > noRow-1 || j > noColumn - 1) {
      throw new IndexOutOfBoundsException();
    }
    return matrix.getValueAt(i).getValueAt(j);
  }

  public void setValueAt(final int i,
                         final int j,
                         final Integer value) {
    if (i > noRow - 1 || j > noColumn - 1) {
      throw new IndexOutOfBoundsException();
    }
    matrix.getValueAt(i).setValueAt(j, value);
  }

  public Matrix add(final Matrix matrix) {
    if (noRow != matrix.noRow && noColumn != matrix.noColumn) {
      throw new UnsupportedOperationException("Only matrix with same size can be added.");
    }
    final Matrix result = new Matrix(noRow, noColumn);
    for (int i = 0; i < noRow; i++) {
      for (int j = 0; j < noColumn; j++) {
        result.setValueAt(i,j,this.getValueAt(i,j)+matrix.getValueAt(i,j));
      }
    }
    return result;
  }

  public Matrix multiply(final Matrix matrix) {
    if (noRow != matrix.noColumn && noColumn != matrix.noRow) {
      throw new UnsupportedOperationException("Number of columns in the first matrix must match the number of rows in" +
          " second matrix.");
    }
    final Matrix result = new Matrix(noRow, matrix.noColumn);
    for (int i = 0; i < noRow; i++) {
      for (int j = 0; j < matrix.noColumn; j++) {
        int sum = 0;
        for (int k = 0; k < noColumn; k++) {
          sum+=this.getValueAt(i,k)*matrix.getValueAt(k,i);
        }
        result.setValueAt(i,j,sum);
      }
    }
    return result;
  }
}
