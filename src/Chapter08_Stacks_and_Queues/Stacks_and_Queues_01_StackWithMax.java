package Chapter08_Stacks_and_Queues;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Stacks_and_Queues_01_StackWithMax {
    public static class MaxCount {
        public int max;
        public int count;

        public MaxCount(int max, int count) {
            this.max = max;
            this.count = count;
        }

        @Override
        public String toString() {
            return "(" + this.max + ", " + this.count + ")";
        }
    }

    public static class StackMax {
        public StackMax() {
            stack = new ArrayDeque<>();
            maxCountStack = new ArrayDeque<>();
        }

        public Deque<Integer> stack;
        public Deque<MaxCount> maxCountStack;

        public void push(int e) {
            stack.push(e);

            if (maxCountStack.size() > 0) {
                MaxCount mc = maxCountStack.peek();
                if (e == mc.max) {
                    maxCountStack.poll();
                    mc.count++;
                    maxCountStack.push(mc);
                } else if (e > mc.max) {
                    maxCountStack.push(new MaxCount(e, 1));
                }
            } else {
                maxCountStack.push(new MaxCount(e, 1));
            }
        }

        public int pop() {
            Integer e = stack.poll();
            if (e != null) {
                MaxCount mc = maxCountStack.poll();
                if (e == mc.max) {
                    if (mc.count > 1) {
                        mc.count--;
                        maxCountStack.push(mc);
                    }
                } else {
                    maxCountStack.push(mc); // put it back
                }
            }
            return e;
        }

        public boolean isEmpty() {
            return this.stack.isEmpty();
        }

        public int max() {
            if (isEmpty()) {
                throw new IllegalStateException("max(): empty stack");
            }
            return this.maxCountStack.peek().max;
        }
    }

    public static void main(String[] args) {
        StackMax stackMax = new StackMax();
        List<Integer> pushVals = new ArrayList<>(Arrays.asList(2, 2, 1, 4, 5, 5, 3));
        for (int i = 0; i < pushVals.size(); ++i) {
            stackMax.push(pushVals.get(i));
            System.out.println("stack: " + stackMax.stack);
            System.out.println("aux: " + stackMax.maxCountStack + "\n");
        }
        // pop 4 times:
        for (int i = 0; i < 4; ++i) {
            System.out.println("pop: " + stackMax.pop());
            System.out.println("stack: " + stackMax.stack);
            System.out.println("aux: " + stackMax.maxCountStack + "\n");
        }
        // push 2 more values:
        List<Integer> pushVals2 = new ArrayList<>(Arrays.asList(0, 3));
        for (int i = 0; i < pushVals2.size(); ++i) {
            stackMax.push(pushVals2.get(i));
            System.out.println("stack: " + stackMax.stack);
            System.out.println("aux: " + stackMax.maxCountStack + "\n");
        }
    }
}
