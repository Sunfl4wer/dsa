package chapter3.exercise;

import chapter3.linkedlist.DoublyLinkedListWithOneSentinel;

public class C331 {
  public static void main(final String[] args) {
    final DoublyLinkedListWithOneSentinel<Integer> list
        = new DoublyLinkedListWithOneSentinel<Integer>();
    list.addLast(10);
    list.addLast(11);
    list.addLast(12);
    list.addLast(13);
    list.addLast(14);
    System.out.println(list.toString());
  }
}
