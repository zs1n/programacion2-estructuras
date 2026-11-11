package stackModule;

public class SimpleArrayStack<E> implements SimpleStack<E> {

    private E[] elements;
    private static final int DEFAULT_CAPACITY = 4;
    private int size = 0;


    @SuppressWarnings("unchecked")
    public SimpleArrayStack(int capacity) {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void push(E element) {
        if (size == elements.length) {
            throw new IllegalStateException("Stack is full");
        }
        elements[size] = element;
        size++;
    }

    @Override
    public E pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        size--;
        E element = (E) elements[size];
        elements[size] = null; // para evitar memory leak
        return element;
    }

    @Override
    public E peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return (E) elements[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}