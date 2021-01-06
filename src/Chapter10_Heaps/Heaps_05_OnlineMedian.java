package Chapter10_Heaps;

import Chapter04_PrimitiveTypes.PrimitiveTypes_08_Reverse;

import java.util.*;

public class Heaps_05_OnlineMedian {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private static void onlineMedian(Iterator<Integer> sequence) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        while (sequence.hasNext()) {
            int x = sequence.next();
            minHeap.add(x);
            maxHeap.add(minHeap.remove());
            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.remove());
            }

            System.out.println(minHeap.size() == maxHeap.size()
                    ? 0.5 * (minHeap.peek() + maxHeap.peek())
                    : (double) minHeap.peek());
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 0, 3, 5, 2, 0, 1));
        onlineMedian(list.iterator());
    }
}
