package stackModule;

public void interface SimpleStack<E> {
    public void push(E element);
    public E pop();
    public E peek();
    public void clear();
    public int size();
    public boolean isEmpty();
}

public void interface SimpleQueue<E> {
    public void enqueue(E element);
    public E dequeue();
    public E peek();
    public void clear();
    public int size();
    public boolean isEmpty();
}