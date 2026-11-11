package queueModule;

public interface SimpleQueue<E> {
    public void enqueue(E element);
    public E dequeue();
    publie E clear();
    public E peek();
    public int size();
    public boolean isEmpty();
}