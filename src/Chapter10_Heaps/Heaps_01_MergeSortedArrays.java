package Chapter10_Heaps;

import java.util.*;

public class Heaps_01_MergeSortedArrays {
    private static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (List<Integer> arr : sortedArrays) {
            for (Integer n : arr) {
                heap.add(n);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            res.add(heap.poll());
        }

        return res;
    }

    // book sol:
    private static class ArrayEntry {
        public Integer value;
        public Integer arrayId;

        public ArrayEntry(Integer value, Integer arrayId) {
            this.value = value;
            this.arrayId = arrayId;
        }
    }

    public static List<Integer> mergeSortedArrays2(List<List<Integer>> sortedArrays) {
        List<Iterator<Integer>> iters = new ArrayList<>(sortedArrays.size());
        for (List<Integer> array : sortedArrays) {
            iters.add(array.iterator());
        }

        Comparator<ArrayEntry> comparator =
                (ArrayEntry a, ArrayEntry b) -> Integer.compare(a.value, b.value);

        PriorityQueue<ArrayEntry> minHeap =
                new PriorityQueue<>(sortedArrays.size(), comparator);

        for (int i = 0; i < iters.size(); ++i) {
            if (iters.get(i).hasNext()) {
                minHeap.add(new ArrayEntry(iters.get(i).next(), i));
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            ArrayEntry headEntry = minHeap.poll();
            result.add(headEntry.value);
            if (iters.get(headEntry.arrayId).hasNext()) {
                minHeap.add(new ArrayEntry(iters.get(headEntry.arrayId).next(),
                        headEntry.arrayId));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(3, 5, 7));
        input.add(Arrays.asList(0, 6));
        input.add(Arrays.asList(0, 6, 28));

        List<Integer> res = mergeSortedArrays2(input);

        System.out.println(res);
    }
}
