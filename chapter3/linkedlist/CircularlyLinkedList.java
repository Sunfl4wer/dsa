package chapter3.linkedlist;

public class CircularlyLinkedList<E> extends LinkedList<E> implements Cloneable {
  private Node<E> tail = null;
  private int size = 0;
  public CircularlyLinkedList() {}

  public CircularlyLinkedList(final E[] data) {
    for (int i = 0; i < data.length; i++) {
      addLast(data[i]);
    }
  }

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
    return tail.getNext().getElement();
  }

  public E last() {
    if (isEmpty()) {
      return null;
    }
    return tail.getElement();
  }

  public void rotate() {
    if (tail != null) {
      tail = tail.getNext();
    }
  }

  public void addFirst(final E element) {
    if (isEmpty()) {
      tail = new Node<>(element, null);
      tail.setNext(tail);
    } else {
      tail.setNext(new Node<>(element, tail.getNext()));
    }
    size++;
  }

  public void addLast(final E element) {
    addFirst(element);
    tail = tail.getNext();
  }

  public E removeFirst() {
    if (isEmpty()) {
      return null;
    }

    final Node<E> firstNode = tail.getNext();
    if (firstNode == tail) {
      tail = null;
    } else {
      tail.setNext(firstNode.getNext());
    }
    size--;

    return firstNode.getElement();
  }

  @Override
  public boolean equals(final Object object) {
    if (object == null) {
      return false;
    }
    if (getClass() != object.getClass()) {
      return false;
    }
    CircularlyLinkedList other = (CircularlyLinkedList) object;
    if (this.size != other.size) {
      return false;
    }
    Node thisNode = tail;
    Node otherNode = other.tail;
    for (int i = 0; i < size; i++) {
      if (thisNode.getElement() != otherNode.getElement()) {
        return false;
      }
      thisNode = thisNode.getNext();
      otherNode = otherNode.getNext();
    }
    return true;
  }

  public CircularlyLinkedList<E> clone() throws CloneNotSupportedException {
    CircularlyLinkedList<E> cloned = (CircularlyLinkedList<E>)super.clone();
    cloned.size = 0;
    if (size > 0) {
      Node<E> node = tail;
      for (int i = 0; i < size; i++) {
        cloned.addLast(node.getElement());
        node = node.getNext();
      }
    }
    cloned.rotate();
    return cloned;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("[");
    Node<E> node = tail;
    for (int i = 0; i < size; i++) {
      sb.append(node.getNext().getElement().toString());
      sb.append(" ");
      node = node.getNext();
    }
    sb.append("]");
    return sb.toString();
  }

  public boolean containSameSequence(final CircularlyLinkedList<E> other) {
    int size = other.size();
    while (size-- > 0) {
      if (this.equals(other)){
        return true;
      }
      other.rotate();
    }
    return false;
  }
}
