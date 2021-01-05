package Chapter10_Heaps;

import java.util.*;

public class Heaps_03_SortAlmostSortedArray {
    public static List<Integer> sortAlmostSortedArray(Iterator<Integer> sequence, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k && sequence.hasNext(); ++i) {
            minHeap.add(sequence.next());
        }

        List<Integer> result = new ArrayList<>();

        while (sequence.hasNext()) {
            result.add(minHeap.poll());
            minHeap.add(sequence.next());
        }

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(3, -1, 2, 6, 4, 5, 8));
        List<Integer> res = sortAlmostSortedArray(input.iterator(), 2);
        System.out.println(res);
    }
}
