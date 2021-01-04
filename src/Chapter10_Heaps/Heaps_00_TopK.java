package Chapter10_Heaps;

import java.util.*;

public class Heaps_00_TopK {
    public static List<String> topK(Iterator<String> iter, int k) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };

        PriorityQueue<String> minHeap = new PriorityQueue<>(k, comparator);
        while (iter.hasNext()) {
            minHeap.add(iter.next());
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("adf", "ssss", "jsdkdls", "df", "lfldfkdfkdfjdkfkd", "klfdsl"));
        List<String> res1 = topK(list.iterator(), 3);
        System.out.println(res1);
    }
}
