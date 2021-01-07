package Chapter10_Heaps;

import java.util.*;

public class Heaps_06_KLargestInBinaryHeap {
    public static class HeapEntry {
        public Integer index;
        public Integer value;

        public HeapEntry(Integer index, Integer value) {
            this.index = index;
            this.value = value;
        }
    }

    private static class Compare implements Comparator<HeapEntry> {

        @Override
        public int compare(HeapEntry o1, HeapEntry o2) {
            return Integer.compare(o2.value, o1.value);
        }

        public static final Compare COMPARE_HEAP_ENTRIES = new Compare();
    }

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public static List<Integer> kLargestInBinaryHeap(List<Integer> arr, int k) {
        if (k <= 0) {
            return Collections.EMPTY_LIST;
        }

        PriorityQueue<HeapEntry> candidateMaxHeap = new PriorityQueue<>(DEFAULT_INITIAL_CAPACITY,
                Compare.COMPARE_HEAP_ENTRIES);

        candidateMaxHeap.add(new HeapEntry(0, arr.get(0)));
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; ++i) {
            Integer candidateIndex = candidateMaxHeap.peek().index;
            result.add(candidateMaxHeap.remove().value);

            Integer leftChildIndex = 2 * candidateIndex + 1;
            if (leftChildIndex < arr.size()) {
                candidateMaxHeap.add(new HeapEntry(leftChildIndex, arr.get(leftChildIndex)));
            }

            Integer rightChildIndex = 2 * candidateIndex + 2;
            if (rightChildIndex < arr.size()) {
                candidateMaxHeap.add(new HeapEntry(rightChildIndex, arr.get(rightChildIndex)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(561, 314, 401, 28, 156, 359, 271, 11, 3));
        List<Integer> res = kLargestInBinaryHeap(arr, 5);
        System.out.println(res);
    }
}
