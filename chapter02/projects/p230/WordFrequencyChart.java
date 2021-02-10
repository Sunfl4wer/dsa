package chapter02.projects.p230;

import java.io.File;
import java.util.Scanner;

public class WordFrequencyChart {

  private static final Character[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
  'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

  private int[] frequency = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
  0, 0, 0, 0};

  private int[] relativeFrequency = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 0};

  public void getFrequency(final String line) {
    for (int i = 0; i < line.length(); i++) {
      for (int j = 0; j < alphabet.length; j++) {
        if (line.charAt(i) == alphabet[j]) {
          frequency[j]+=1;
          break;
        }
      }
    }
  }

  public void plotFrequency() {
    calculateRelativeFrequency();
    for (int i = 0; i<frequency.length; i++) {
      plotLine(alphabet[i], frequency[i], relativeFrequency[i]);
    }
  }

  private void plotLine(final Character c,
                        final int frequency,
                        final int relativeFrequency) {
    final String prefix = c + " [" + frequency + "]" + "[" + relativeFrequency + "%]";
    System.out.print(prefix);
    for (int i = 0; i<15-prefix.length(); i++) {
      System.out.print(' ');
    }
    System.out.print(": ");
    for (int i = 0; i<relativeFrequency; i++) {
      System.out.print("+");
    }
    System.out.println();
  }

  private void calculateRelativeFrequency() {
    int sum = 0;
    for (int value : frequency) {
      sum += value;
    }
    for (int i = 0; i<frequency.length; i++) {
      relativeFrequency[i] = frequency[i]*100/sum;
    }
  }

  public static void main(final String[] args) {
    final WordFrequencyChart wordFrequencyChart = new WordFrequencyChart();
    try {
      File file = new File("C:\\Users\\son.nguyenthai\\eclipse-workspace\\dsa\\src\\chapter02\\projects\\p230\\text" +
          ".txt");
      Scanner scanner = new Scanner(file);
      while (scanner.hasNext()) {
        String data = scanner.next().toLowerCase();
        wordFrequencyChart.getFrequency(data);
      }
      scanner.close();
      wordFrequencyChart.plotFrequency();
    } catch (Exception ignored) {

    }
  }
}
