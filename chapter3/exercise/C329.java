package chapter3.exercise;

import chapter3.linkedlist.CircularlyLinkedList;

public class C329 {
  public static void main(final String[] args) throws CloneNotSupportedException {
    final CircularlyLinkedList<Integer> linkedList
        = new CircularlyLinkedList<>();
    linkedList.addLast(10);
    linkedList.addLast(12);
    linkedList.addLast(23);
    linkedList.addLast(16);
    final CircularlyLinkedList<Integer> cloned = linkedList.clone();
    cloned.addLast(43);
    System.out.println(linkedList.containSameSequence(cloned));
  }
}
