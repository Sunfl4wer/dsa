package chapter3.work;

import chapter3.linkedlist.CircularlyLinkedList;

public class C330 {
  public static void main(final String[] args) throws CloneNotSupportedException {
    CircularlyLinkedList<Integer> linkedList = new CircularlyLinkedList<>();
    linkedList.addLast(10);
    linkedList.addLast(12);
    linkedList.addLast(13);
    linkedList.addLast(16);
    linkedList.addLast(12);
    linkedList.addLast(14);
    linkedList.addLast(19);
    linkedList.addLast(20);
    linkedList.addLast(21);

    CircularlyLinkedList<Integer> secondPart = linkedList.clone();
    CircularlyLinkedList<Integer> firstPart = new CircularlyLinkedList<>();
    for (int i = 0; i < linkedList.size()/2; i++) {
      firstPart.addLast(secondPart.removeFirst());
    }
    System.out.println(linkedList.toString());
    System.out.println(firstPart.toString());
    System.out.println(secondPart.toString());
  }
}
