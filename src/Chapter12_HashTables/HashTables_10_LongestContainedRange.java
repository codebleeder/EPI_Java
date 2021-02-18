package Chapter12_HashTables;

import java.util.*;

public class HashTables_10_LongestContainedRange {
    private static int longestContainedRange(List<Integer> arr) {
        Set<Integer> set = new HashSet<>(arr);
        int maxSize = 0;
        int i = 0;

        while (!set.isEmpty()) {
            // get first entry of array
            int x = arr.get(i);

            if (set.contains(x)) {
                set.remove(x);
                int size = 1;
                // check for contiguous values larger than x
                int iter = 1;
                while (set.contains(x + iter)) {
                    set.remove(x + iter);
                    ++size;
                    ++iter;

                }

                iter = 1;
                while (set.contains(x - iter)) {
                    set.remove(x - iter);
                    ++size;
                    ++iter;
                }

                maxSize = Math.max(maxSize, size);
            }

            ++i;
        }

        return maxSize;
    }

    // book sol:
    private static int longestContainedRange2(List<Integer> arr) {
        Set<Integer> set = new HashSet<>(arr);
        int maxSize = 0;
        while (!set.isEmpty()) {
            int a = set.iterator().next();
            set.remove(a);

            // check lower contiguous values:
            int lowerBound = a - 1;
            while (set.contains(lowerBound)) {
                set.remove(lowerBound);
                --lowerBound;
            }

            // check higher contiguous values:
            int upperBound = a + 1;
            while (set.contains(upperBound)) {
                set.remove(upperBound);
                ++upperBound;
            }

            maxSize = Math.max(upperBound - lowerBound - 1, maxSize);
        }
        return maxSize;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(10, 5, 3, 11, 6, 100, 4));
        System.out.println(longestContainedRange2(arr));
    }
}
