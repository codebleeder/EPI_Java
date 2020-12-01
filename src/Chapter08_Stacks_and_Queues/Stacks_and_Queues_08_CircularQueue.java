package Chapter08_Stacks_and_Queues;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

public class Stacks_and_Queues_08_CircularQueue {
    public static class CircularQueue {
        private Integer size = 0;
        private Integer maxCapacity = 0;
        private int head = 0, tail = 0;
        private Integer[] arr;

        public CircularQueue(int n) {
            this.maxCapacity = n;
            arr = new Integer[n];
        }

        public void enqueue(int n) {
            arr[tail] = n;
            ++size;
            if (size >= maxCapacity) {
                increaseCapacity();
            }
            this.tail = this.tail == this.arr.length - 1 ? 0 : ++this.tail;
        }

        private void increaseCapacity() {
            maxCapacity *= 2;
            Integer[] newArr = new Integer[maxCapacity];
            int i = 0;
            int oldArrIndex = head;
            int count = 0;
            while (count < size) {
                newArr[i] = this.arr[oldArrIndex];
                count++;
                i++;
                oldArrIndex = oldArrIndex == arr.length - 1 ? 0 : oldArrIndex + 1;
            }
            this.head = 0;
            this.arr = newArr;
        }

        public Integer dequeue() {
            if (size > 0) {
                int res = arr[head];
                --size;
                head = head == arr.length - 1 ? 0 : ++head;
                return res;
            }
            throw new NullPointerException("dequeue error: trying to read from empty queue");
        }

        public Integer size() {
            return size;
        }
    }

    // book sol:
    public static class CircularQueue2 {
        private int head = 0, tail = 0, size = 0;
        private static final int SCALE_FACTOR = 2;
        private Integer[] arr;

        public CircularQueue2(int capacity) {
            arr = new Integer[capacity];
        }

        public void enqueue(Integer x) {
            if (size == arr.length) {
                Collections.rotate(Arrays.asList(arr), -head);
                head = 0;
                tail = size;
                arr = Arrays.copyOf(arr, size * SCALE_FACTOR);
            }
            arr[tail] = x;
            tail = (tail + 1) % arr.length;
            ++size;
        }

        public Integer dequeue() {
            if (size != 0) {
                --size;
                Integer res = arr[head];
                head = (head + 1) % arr.length;
                return res;
            }
            throw new NoSuchElementException("dequeue called on empty queue");
        }

        public Integer size() {
            return size;
        }
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(4);
        System.out.println("write 4 times");
        for (int i = 1; i <= 4; ++i) {
            cq.enqueue(i);
        }
        System.out.println("read twice");
        for (int i = 0; i < 2; ++i) {
            System.out.println("dequeue: " + cq.dequeue());
        }
        System.out.println("write 6 times:");
        for (int i = 0; i < 6; ++i) {
            cq.enqueue(i + 5);
        }

    }
}
