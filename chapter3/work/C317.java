package chapter3.work;

import java.util.Arrays;

public class C317 {
  public static void main(final String[] args) {
    final int[] randomArray = {1,2,3,6,5,4,7,9,10,8,11,12,11,11,11,11};
    final int sumArray = C317.sum(randomArray);
    final int noDuplicate = 5;
    final int index = randomArray.length-
        (randomArray.length*(randomArray.length+1)/2-
            (sumArray+(noDuplicate-1)*noDuplicate/2))/(noDuplicate-1)-1;
    Arrays.sort(randomArray);
    System.out.println(randomArray[index]);
  }

  public static int sum(final int[] array) {
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      sum+=array[i];
    }
    return sum;
  }
}
