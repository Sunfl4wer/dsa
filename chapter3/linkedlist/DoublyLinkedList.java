package chapter3.linkedlist;

public class DoublyLinkedList<E> {
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

  private Node<E> header;
  private Node<E> trailer;
  private int size = 0;

  public DoublyLinkedList() {
    header = new Node<E>(null, null, null);
    trailer = new Node<E>(null, null, header);
    header.setNext(trailer);
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
    return header.getNext().getElement();
  }

  public E last() {
    if (isEmpty()) {
      return null;
    }
    return trailer.getPrev().getElement();
  }

  public void addFirst(E element) {
    addBetween(element, header, header.getNext());
  }

  public void addLast(E element) {
    addBetween(element, trailer.getPrev(), trailer);
  }

  public E removeFirst() {
    return remove(header.getNext());
  }

  public E removeLast() {
    return remove(trailer.getPrev());
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
    size--;
    return node.getElement();
  }

  @Override
  public boolean equals(final Object object) {
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    DoublyLinkedList other = (DoublyLinkedList) object;
    if (size != other.size) {
      return false;
    }
    Node thisNodeForward = header.getNext();
    Node otherNodeForward = other.header.getNext();
    while(thisNodeForward != trailer) {
      if(thisNodeForward.getElement() != otherNodeForward.getElement()) {
        return false;
      }
      thisNodeForward = thisNodeForward.getNext();
    }
    Node thisNodeBackward = trailer.getPrev();
    Node otherNodeBackward = other.trailer.getPrev();
    while(thisNodeBackward != header) {
      if(thisNodeBackward.getElement() != otherNodeBackward.getElement()) {
        return false;
      }
      thisNodeBackward = thisNodeBackward.getPrev();
    }
    return true;
  }
}
