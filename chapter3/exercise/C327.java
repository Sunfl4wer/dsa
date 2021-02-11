package chapter3.exercise;

import chapter3.linkedlist.SinglyLinkedList;

public class C327 {
  public static void main(final String[] args) throws CloneNotSupportedException {
    final SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
    linkedList.addLast(10);
    linkedList.addLast(11);
    linkedList.addLast(14);
//    linkedList.addLast(19);
//    linkedList.addLast(11);
//    System.out.println(linkedList.swap(1,3));
//    System.out.println(linkedList);
    SinglyLinkedList<Integer> clone = linkedList.clone();
//    linkedList.reverse();
    clone.reverse();
    System.out.println(clone.size());
    System.out.println(linkedList);
  }
}
