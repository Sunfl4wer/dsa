package chapter3.linkedlist;

public abstract class LinkedList<E> {
  protected static class Node<E> {
    private E element;
    private Node<E> next;
    public Node(final E value,
                final Node<E> nextNode) {
      element = value;
      next = nextNode;
    }

    public E getElement() {
      return element;
    }

    public Node<E> getNext() {
      return next;
    }

    public void setNext(final Node<E> nextNode) {
      this.next = nextNode;
    }
  }

  public abstract int size();
  public abstract boolean isEmpty();
  public abstract E first();
  public abstract E last();
  public abstract void addFirst(E element);
  public abstract void addLast(E element);
  public abstract E removeFirst();
}
