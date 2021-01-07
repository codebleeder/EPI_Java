package Chapter10_Heaps;

import java.util.EmptyStackException;
import java.util.PriorityQueue;

public class Heaps_07_StackAPIUsingHeap {
    private static class StackEntry {
        public Integer index;
        public Integer value;

        public StackEntry(Integer index, Integer value) {
            this.index = index;
            this.value = value;
        }
    }

    private static class Stack {
        private PriorityQueue<StackEntry> maxHeap =
                new PriorityQueue<>(
                        (StackEntry a, StackEntry b) -> Integer.compare(b.index, a.index));

        private Integer topIndex = 0;

        public void push(Integer val) {
            maxHeap.add(new StackEntry(topIndex++, val));
        }

        public Integer pop() {
            try {
                if (topIndex < 0) {
                    throw new EmptyStackException();
                }
                Integer val = maxHeap.remove().value;
                --topIndex;
                return val;
            } catch (EmptyStackException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        // try to pop an empty stack:
        // stack.pop(); // should throw exception

        stack.push(23);
        stack.push(45);
        stack.push(89);

        for (int i = 0; i < 3; ++i) {
            System.out.println(stack.pop());
        }
    }
}
