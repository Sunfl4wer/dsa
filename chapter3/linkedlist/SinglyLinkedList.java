package chapter3.linkedlist;

public class SinglyLinkedList<E> extends LinkedList<E> implements Cloneable {
  private Node<E> head = null;
  private Node<E> tail = null;
  private int size = 0;

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public E first() {
    if (isEmpty()) {
      return null;
    }
    return head.getElement();
  }

  public E last() {
    if (isEmpty()) {
      return null;
    }
    return tail.getElement();
  }

  public E getValueAt(final int index) {
    if (isEmpty() || index > size-1) {
      return null;
    }
    Node<E> node = head;
    for (int i = 0; i < index; i++) {
      node = node.getNext();
    }
    return node.getElement();
  }

  public void setValueAt(final int index,
                         final E element) {
    if (isEmpty() || index > size-1) {
      throw new IndexOutOfBoundsException();
    }
    Node<E> node = head;
    for (int i = 0; i < index; i++) {
      node = node.getNext();
    }
    node.setElement(element);
  }

  public void addFirst(final E element) {
    head = new Node<>(element, head);
    if (size == 0) {
      tail = head;
    }
    size++;
  }

  public void addLast(final E element) {
    final Node<E> node = new Node<>(element, null);
    if (isEmpty()) {
      head = node;
    } else {
      tail.setNext(node);
    }
    tail = node;
    size++;
  }

  public E removeFirst() {
    if (isEmpty()) {
      return null;
    }

    final E firstElement = head.getElement();
    head = head.getNext();
    size--;

    if (size == 0) {
      tail = null;
    }
    return firstElement;
  }

  public E removeLast() {
    if (isEmpty()) {
      return null;
    }
    final E lastElement = tail.getElement();
    size--;

    if (size == 0) {
      head = null;
    } else {
      int temp = size;
      Node<E> node = head;
      while (temp > 0) {
        node = node.getNext();
        temp--;
      }
      node.setNext(null);
    }

    return lastElement;
  }

  @Override
  public boolean equals(final Object object) {
    if (object == null) {
      return false;
    }
    if (getClass() != object.getClass()) {
      return false;
    }
    final SinglyLinkedList otherList = (SinglyLinkedList) object;
    if (this.size != otherList.size) {
      return false;
    }
    Node firstListNode = head;
    Node secondListNode = otherList.head;
    while (firstListNode != null) {
      if (!firstListNode.getElement().equals(secondListNode.getElement())) {
        return false;
      }
      firstListNode = firstListNode.getNext();
      secondListNode = secondListNode.getNext();
    }
    return true;
  }

  public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
    SinglyLinkedList<E> other = (SinglyLinkedList<E>)super.clone();
    if (size > 0) {
      other.head = new Node<E>(head.getElement(), null);
      Node<E> clonedTail = other.head;
      Node<E> originalNode = head.getNext();
      while (originalNode != null) {
        Node<E> newNode = new Node<E>(originalNode.getElement(), null);
        clonedTail.setNext(newNode);
        clonedTail = newNode;
        originalNode = originalNode.getNext();
      }
    }
    return other;
  }

  public SinglyLinkedList<E> concat(final SinglyLinkedList<E> firstList,
                                    final SinglyLinkedList<E> secondList) {
    final SinglyLinkedList<E> concatList = new SinglyLinkedList<>();
    Node<E> firstListNode = firstList.head;
    while (firstListNode != null) {
      concatList.addLast(firstListNode.getElement());
      firstListNode = firstListNode.getNext();
    }
    Node<E> secondListNode = secondList.head;
    while (secondListNode != null) {
      concatList.addLast(secondListNode.getElement());
      secondListNode = secondListNode.getNext();
    }
    return concatList;
  }

  public boolean swap(final int firstNodeIndex,
                      final int secondNodeIndex) {
    if (isEmpty() || size < firstNodeIndex || size < secondNodeIndex) {
      return false;
    }
    Node<E> node = head;
    Node<E> firstNode = null;
    Node<E> secondNode = null;
    int count = 0;
    while (node != null) {
      if (count == firstNodeIndex) {
        firstNode = node;
      }
      if (count == secondNodeIndex) {
        secondNode = node;
      }
      node = node.getNext();
      count++;
    }
    if (firstNode == null || secondNode == null) {
      return false;
    }
    return swap(firstNode, secondNode);
  }

  public boolean swap(final Node<E> firstNode,
                      final Node<E> secondNode) {
    if (isEmpty()) {
      return false;
    }
    Node<E> firstNodePrecedence = null;
    Node<E> secondNodePrecedence = null;
    Node<E> node = head;
    while (node != null) {
      if (node == firstNode) {
        break;
      }
      firstNodePrecedence = node;
      node = node.getNext();
    }
    node = head;
    while (node != null) {
      if (node == secondNode) {
        break;
      }
      secondNodePrecedence = node;
      node = node.getNext();
    }

    if (firstNodePrecedence == null && secondNodePrecedence == null) {
      return true;
    }

    if (firstNodePrecedence != null) {
      firstNodePrecedence.setNext(secondNode);
    }
    if (secondNodePrecedence != null) {
      secondNodePrecedence.setNext(firstNode);
    }

    if (firstNodePrecedence == null) {
      head = secondNode;
    }
    if (secondNodePrecedence == null) {
      head = firstNode;
    }
    if (tail == secondNode) {
      tail = firstNode;
    }

    if (tail == firstNode) {
      tail = secondNode;
    }

    Node<E> temp = secondNode.getNext();
    secondNode.setNext(firstNode.getNext());
    firstNode.setNext(temp);
    return true;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("[");
    Node<E> node = head;
    while (node != null) {
      sb.append(node.getElement().toString());
      sb.append(" ");
      node = node.getNext();
    }
    sb.append("]");
    return sb.toString();
  }

  public void reverse() {
    if (isEmpty()) {
      return;
    }
    Node<E> prevNode = null;
    Node<E> node = head;
    while (node != null) {
      Node<E> nextNode = node.getNext();
      node.setNext(prevNode);
      prevNode = node;
      node = nextNode;
    }
    tail = head;
    head = prevNode;
  }
}
