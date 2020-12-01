package Chapter08_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class Stacks_and_Queues_09_QueueUsingStacks {
    public static class QueueUsingStacks {
        private Deque<Integer> enqueueStack = new ArrayDeque<>();
        private Deque<Integer> dequeStack = new ArrayDeque<>();

        public void enqueue(Integer x) {
            enqueueStack.addFirst(x);
        }

        public Integer dequeue() {
            if (!dequeStack.isEmpty()) {
                return dequeStack.removeFirst();
            } else {
                if (!enqueueStack.isEmpty()) {
                    while (!enqueueStack.isEmpty()) {
                        dequeStack.addFirst(enqueueStack.removeFirst());
                    }
                    return dequeStack.removeFirst();
                }
                throw new NoSuchElementException("dequeue error: queue is empty");
            }
        }
    }

    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue(5);
        q.enqueue(6);
        for (int i = 0; i < 4; ++i) {
            System.out.println(q.dequeue());
        }
    }
}
