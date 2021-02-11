package chapter3.exercise;

import chapter3.linkedlist.CircularDoublyLinkedList;

public class C332 {
  public static void main(final String[] args) {
    final CircularDoublyLinkedList<Integer> list
        = new CircularDoublyLinkedList<>();
    list.addLast(10);
    list.addLast(11);
    list.addLast(12);
    list.addLast(13);
    list.addLast(14);
    System.out.println(list.toString());
    list.rotate();
    System.out.println(list.toString());
    list.removeFirst();
    System.out.println(list.toString());
    list.removeLast();
    System.out.println(list.toString());
    list.rotateBackward();
    System.out.println(list.toString());
  }
}
