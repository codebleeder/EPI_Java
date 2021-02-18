package Chapter12_HashTables;

import java.util.*;

public class HashTables_09_LongestSubarrayWithDistinctEntries {
    private static class Subarray {
        public Integer start;
        public Integer end;

        public Subarray(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return String.format("[start: %d, end: %d]", start, end);
        }

        public Integer getLength() {
            return end - start;
        }
    }

    public static int longestSubarrayWithDistinctEntries(List<Integer> arr) {
        Map<Integer, Integer> mostRecentOccurence = new HashMap<>();
        int longestDupFreeSubarrayStartIndex = 0, result = 0;
        for (int i = 0; i < arr.size(); ++i) {
            Integer dupIndex = mostRecentOccurence.put(arr.get(i), i);
            if (dupIndex != null) {
                if (dupIndex >= longestDupFreeSubarrayStartIndex) {
                    result = Math.max(result, i - longestDupFreeSubarrayStartIndex);
                    longestDupFreeSubarrayStartIndex = dupIndex + 1;
                }
            }
        }
        return Math.max(result, arr.size() - longestDupFreeSubarrayStartIndex);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(6, 19, 6, 5, 20, 23, 5, 14, 23, 5));
        System.out.println("longest distinct length: " + longestSubarrayWithDistinctEntries(arr));

    }
}
