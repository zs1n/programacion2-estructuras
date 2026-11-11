package list;

public class SimpleLinkedList<E> implements SimpleList<E> {
    private LinkedNode<E> first = null;
    private LinkedNode<E> last = null;
    private int size = 0;

    @Override
    public boolean add(E element) {
        LinkedNode<E> addedNode = new LinkedNode<>(element);
        if (size == 0) {
            first = addedNode;
        } else {
            last.next = addedNode;
            addedNode.prev = last;
        }
        last = addedNode;
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index == size) {
            add(element);
            return;
        }
        validateIndex(index);
        LinkedNode<E> addedNode = new LinkedNode<>(element);
        if (index == 0) {
            addedNode.next = first;
            first.prev = addedNode;
            first = addedNode;
        } else {
            LinkedNode<E> existentNode = getNodeByIndex(index);
            addedNode.next = existentNode;
            addedNode.prev = existentNode.prev;
            existentNode.prev.next = addedNode;
            existentNode.prev = addedNode;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        validateIndex(index);
        LinkedNode<E> nodeToRemove = getNodeByIndex(index);
        E element = nodeToRemove.value;

        // caso uno donde es el único nodo
        if (size == 1) {
            first = null;
            last = null;
        } 
        // caso dos donde es el primero
        else if (nodeToRemove == first) {
            first = first.next;
            first.prev = null;
        } 
        // caso 3 es Es el último
        else if (nodeToRemove == last) {
            last = last.prev;
            last.next = null;
        } 
        // caso 4 esta en el medio
        else {
            nodeToRemove.prev.next = nodeToRemove.next;
            nodeToRemove.next.prev = nodeToRemove.prev;
        }

        size--;
        return element;
    }

    @Override
    public boolean remove(Object object) {
        LinkedNode<E> current = first;
        int index = 0;
        while (current != null) {
            // comparo el valor del nodo con el objecto que busco
            if (object == null ? current.value == null : object.equals(current.value)) {
                remove(index);
                return true;
            }
            current = current.next;
            index++;
        }
        return false;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean contains(Object object) {
        LinkedNode<E> current = first;
        while (current != null) {
            if (object == null ? current.value == null : object.equals(current.value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public E get(int index) {
        validateIndex(index);
        return getNodeByIndex(index).value;
    }

    @Override
    public E set(int index, E element) {
        validateIndex(index);
        LinkedNode<E> node = getNodeByIndex(index);
        E oldVal = node.value;
        node.value = element;
        return oldVal;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }

    private LinkedNode<E> getNodeByIndex(int index) {
        if (index < size / 2) { // Optimización: si está en la primera mitad
            LinkedNode<E> currentNode = first;
            for (int i = 0; i < index; i++)
                currentNode = currentNode.next;
            return currentNode;
        } else { // Si está en la segunda mitad, empezamos desde atrás
            LinkedNode<E> currentNode = last;
            for (int i = size - 1; i > index; i--)
                currentNode = currentNode.prev;
            return currentNode;
        }
    }
}