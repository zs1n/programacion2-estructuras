package stackModule;

public class SimpleLinkedStack<E> implements SimpleStack<E> {
    private Node<E> top;
    private int size;

    // Clase interna para representar cada eslabón de la pila
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public SimpleLinkedStack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        // El nuevo nodo apunta al antiguo tope
        newNode.next = top;
        // El nuevo nodo ahora es el tope
        top = newNode;
        size++;
    }

    @Override
    public E pop() {
        // La validación de isEmpty() se hace en StackExercise antes de llamar aquí
        E data = top.data;
        top = top.next; // Movemos el tope al siguiente nodo
        size--;
        return data;
    }

    @Override
    public E peek() {
        return top.data;
    }

    @Override
    public void clear() {
        top = null; // Al quitar la referencia al tope, el GC limpia el resto
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}