package Chapter08_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class Stacks_and_Queues_00_QueueWithMax {
    public static class QueueWithMax {
        private Deque<Integer> queue = new ArrayDeque<>();

        public void enqueue(int data) {
            queue.addFirst(data);
        }

        public int dequeue() {
            return queue.removeFirst();
        }

        public Integer max() {
            if (!queue.isEmpty()) {
                return Collections.max(queue);
            }
            throw new IllegalStateException("cannot perform max() on empty queue");
        }
    }

    public static void main(String[] args) {
        QueueWithMax q = new QueueWithMax();
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        System.out.println("max: " + q.max());
        System.out.println("dequeue: " + q.dequeue());
        System.out.println("max: " + q.max());
    }
}
