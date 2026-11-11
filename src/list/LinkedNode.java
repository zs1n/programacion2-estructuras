package list;

public class LinkedNode<E> {
    public LinkedNode<E> prev = null; // un solo '=' para asignar
    public LinkedNode<E> next = null;
    public E value;

    public LinkedNode(E value) {
        this.value = value; // 'this.value para referirme al atributo de arriba
    }
}