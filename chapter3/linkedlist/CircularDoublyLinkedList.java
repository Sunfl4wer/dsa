package chapter3.linkedlist;

public class CircularDoublyLinkedList<E> {
  protected static class Node<E> {
    private E element;
    private Node<E> next;
    private Node<E> prev;
    public Node(final E element,
                final Node<E> next,
                final Node<E> prev) {
      this.element = element;
      this.next = next;
      this.prev = prev;
    }

    public E getElement() {
      return element;
    }

    public Node<E> getNext() {
      return this.next;
    }

    public Node<E> getPrev() {
      return this.prev;
    }

    public void setNext(final Node<E> next) {
      this.next = next;
    }

    public void setPrev(final Node<E> prev) {
      this.prev = prev;
    }
  }

  private Node<E> tail;
  private int size = 0;

  public CircularDoublyLinkedList() {
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return size==0;
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

  public void addFirst(E element) {
    if (isEmpty()) {
      tail = new Node<E>(element, null, null);
      tail.setNext(tail);
      tail.setPrev(tail);
      size++;
    } else {
      addBetween(element, tail, tail.getNext());
    }
  }

  public void addLast(E element) {
    addFirst(element);
    tail = tail.getNext();
  }

  public E removeFirst() {
    return remove(tail.getNext());
  }

  public E removeLast() {
    tail = tail.getPrev();
    return removeFirst();
  }

  public void addBetween(final E element,
                         final Node<E> firstNode,
                         final Node<E> secondNode) {
    final Node<E> newNode = new Node<E>(element, secondNode, firstNode);
    firstNode.setNext(newNode);
    secondNode.setPrev(newNode);
    size++;
  }

  public E remove(final Node<E> node) {
    if (isEmpty()) {
      return null;
    }
    Node<E> predecessor = node.getPrev();
    Node<E> successor = node.getNext();
    successor.setPrev(predecessor);
    predecessor.setNext(successor);
    size--;
    return node.getElement();
  }

  public void rotate() {
    if (isEmpty()) {
      return;
    }
    tail = tail.getNext();
  }

  public void rotateBackward() {
    if (isEmpty()) {
      return;
    }
    tail = tail.getPrev();
  }

  @Override
  public boolean equals(final Object object) {
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    CircularDoublyLinkedList other = (CircularDoublyLinkedList) object;
    if (size != other.size) {
      return false;
    }
    Node thisNodeForward = tail.getNext();
    Node otherNodeForward = other.tail.getNext();
    while(thisNodeForward != tail) {
      if(thisNodeForward.getElement() != otherNodeForward.getElement()) {
        return false;
      }
      thisNodeForward = thisNodeForward.getNext();
    }
    Node thisNodeBackward = tail.getPrev();
    Node otherNodeBackward = other.tail.getPrev();
    while(thisNodeBackward != tail) {
      if(thisNodeBackward.getElement() != otherNodeBackward.getElement()) {
        return false;
      }
      thisNodeBackward = thisNodeBackward.getPrev();
    }
    return other.tail.getElement() == tail.getElement();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    if (!isEmpty()) {
      Node<E> node = tail.getNext();
      while (node != tail) {
        sb.append(node.getElement().toString());
        sb.append(" ");
        node = node.getNext();
      }
      sb.append(tail.element.toString());
    }
    sb.append("]");
    return sb.toString();
  }
}
