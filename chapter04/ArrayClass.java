package chapter04;

import java.util.Arrays;
import java.util.Map;

public class ArrayClass {
  private int[] data;
  private int max;
  private int min;

  public ArrayClass() {};

  public int getMax() {
    return max;
  }

  public int getSize() {
    if (data == null) {
      return 0;
    }
    return data.length;
  }

  public void setData(final int[] data) {
    this.data = data;
  }

  public int getMin() {
    return min;
  }

  public ArrayClass(final int size) {
    this.max = 0;
    this.min = 0;
    this.data = new int[size];
  }

  public ArrayClass(final int[] data) {
    this.max = 0;
    this.min = 0;
    this.data = data;
  }

  public void setMax(final int max) {
    this.max = max;
  }

  public void setMin(final int min) {
    this.min = min;
  }

  public void findPeaks() {
    if (getSize() == 1) {
      max = data[0];
      min = data[0];
      return;
    }
    final int mid = (getSize()-1)/2;
    final ArrayClass first = new ArrayClass(Arrays.copyOfRange(this.data, 0, mid+1));
    final ArrayClass second = new ArrayClass(Arrays.copyOfRange(this.data, mid+1, getSize()));
    first.findPeaks();
    second.findPeaks();
    max = first.max < second.max ? second.max : first.max;
    min = first.min > second.min ? second.min : first.min;
  }
}
