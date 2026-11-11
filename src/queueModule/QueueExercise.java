package queueModule;

import base.Exercise;

public class QueueExercise<E> extends Exercise {
    private SimpleQueue<E> queue;

    public QueueExercise(SimpleQueue<E> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        if (isFirstTime()) {
            System.out.println("Bienvenido al ejercicio de Colas.");
            setFirstTime(false);
        } else {
            System.out.println("Estado de la cola -> Tamaño: " + queue.size() + " | Vacía: " + queue.isEmpty());
        }
        // Lógica de menú aquí...
    }

    public void executeDequeue() {
        if (queue.isEmpty()) {
            System.out.println("Error: La cola está vacía.");
            return;
        }
        System.out.println("Elemento atendido: " + queue.dequeue());
    }

    public void executePeek() {
        if (queue.isEmpty()) {
            System.out.println("Error: La cola está vacía.");
            return;
        }
        System.out.println("Primer elemento en espera: " + queue.peek());
        // No se repite, vuelve al menú principal según consigna.
    }

    public void executeClear() {
        if (!queue.isEmpty()) {
            queue.clear();
            System.out.println("Cola vaciada.");
        } else {
            System.out.println("La cola ya estaba vacía (operación clear omitida).");
        }
    }
}