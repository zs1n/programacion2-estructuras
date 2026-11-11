package queueModule;

public class SimpleArrayQueue<E> implements SimpleQueue<E> {
    private E[] array;
    private int front;
    private int rear;
    private int count;
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public SimpleArrayQueue() {
        this.array = (E[]) new Object[INITIAL_CAPACITY];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
    }

    @Override
    public void enqueue(E element) {
        if (count == array.length) {
            resize();
        }
        array[rear] = element;
        // Incremento circular: si rear es el último índice, vuelve a 0
        rear = (rear + 1) % array.length;
        count++;
    }

    @Override
    public E dequeue() {
        E element = array[front];
        array[front] = null; // Limpieza para el GC
        front = (front + 1) % array.length;
        count--;
        return element;
    }

    @Override
    public E peek() {
        return array[front];
    }

    @Override
    public void clear() {
        // Limpiamos el arreglo para no dejar referencias
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        front = 0;
        rear = 0;
        count = 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        E[] newArray = (E[]) new Object[array.length * 2];
        // Copiamos los elementos respetando el orden lógico desde 'front'
        for (int i = 0; i < count; i++) {
            newArray[i] = array[(front + i) % array.length];
        }
        array = newArray;
        front = 0;
        rear = count;
    }
}