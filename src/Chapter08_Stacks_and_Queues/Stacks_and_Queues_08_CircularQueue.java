package Chapter08_Stacks_and_Queues;

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
            while (count <= size) {
                newArr[i] = this.arr[oldArrIndex];
                count++;
                i++;
                oldArrIndex = oldArrIndex == arr.length - 1 ? 0 : oldArrIndex + 1;
            }
            this.head = 0;
            this.tail = size;
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
        System.out.println("write 4 times:");
        for (int i = 0; i < 4; ++i) {
            cq.enqueue(i + 5);
        }

    }
}
