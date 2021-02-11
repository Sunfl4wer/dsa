package chapter3.exercise;

import chapter3.linkedlist.DoublyLinkedList;

public class C335 {
  public static void main(final String[] args) throws CloneNotSupportedException {
    final DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
    list.addLast(10);
    list.addLast(11);
    list.addLast(12);
    list.addLast(13);
    list.addFirst(20);
    final DoublyLinkedList<Integer> cloned = list.clone();
    System.out.println(list);
    System.out.println(cloned);
  }
}
