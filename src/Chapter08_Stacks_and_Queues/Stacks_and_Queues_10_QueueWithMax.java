package Chapter08_Stacks_and_Queues;

import java.util.*;

public class Stacks_and_Queues_10_QueueWithMax {
    public static class QueueWithMax {
        private Queue<Integer> queue = new ArrayDeque<>();
        private Deque<Integer> maxDQueue = new ArrayDeque<>();

        public void enqueue(Integer x) {
            queue.add(x);
            while (!maxDQueue.isEmpty() && maxDQueue.getLast() < x) {
                maxDQueue.removeLast();
            }
            maxDQueue.addLast(x);
        }

        public Integer dequeue() {
            if (!queue.isEmpty()) {
                Integer res = queue.remove();
                if (maxDQueue.peekFirst().equals(res)) {
                    maxDQueue.removeFirst();
                }
                return res;
            }
            throw new NoSuchElementException("dequeue error: queue is empty");
        }

        public Integer max() {
            if (!maxDQueue.isEmpty()) return maxDQueue.getFirst();
            throw new NoSuchElementException("max() error: queue is empty");
        }
    }

    public static void main(String[] args) {
        List<Integer> vals = new ArrayList<>(Arrays.asList(3, 1, 3, 2, 0, 1));
        QueueWithMax q = new QueueWithMax();
        for (int i = 0; i < vals.size(); ++i) {
            q.enqueue(vals.get(i));
            System.out.println("enqueue: " + vals.get(i) + " max: " + q.max());
        }
        // dequeue twice
        for (int i = 0; i < 2; ++i) {
            System.out.println("dequeue: " + q.dequeue());
            System.out.println("max: " + q.max());
        }
        vals = new ArrayList<>(Arrays.asList(2, 4));
        for (int i = 0; i < vals.size(); ++i) {
            q.enqueue(vals.get(i));
            System.out.println("enqueue: " + vals.get(i) + " max: " + q.max());
        }

    }
}
