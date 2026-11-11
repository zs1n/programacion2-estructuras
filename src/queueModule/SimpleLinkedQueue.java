package queueModule;

public class SimpleLinkedQueue<E> implements SimpleQueue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    @Override
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    @Override
    public E dequeue() {
        E data = front.data;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return data;
    }

    @Override
    public E peek() { return front.data; }

    @Override
    public void clear() {
        front = rear = null;
        size = 0;
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }
}