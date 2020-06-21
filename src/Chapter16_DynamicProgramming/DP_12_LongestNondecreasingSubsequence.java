package Chapter16_DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DP_12_LongestNondecreasingSubsequence {
    public static int longestNondecreasingSubsequence(List<Integer> arr) {
        Integer[] max = new Integer[arr.size()];
        Arrays.fill(max, 1);
        for (int i = 1; i < arr.size(); ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (arr.get(i) > arr.get(j)) {
                    max[i] = Math.max(max[i], max[j] + 1);
                }
            }
        }
        return Collections.max(Arrays.asList(max));
    }

    public static void test() {
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(new ArrayList<>(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9)));
        arrays.add(new ArrayList<>(Arrays.asList(10, 22, 9, 33, 21, 50, 41, 60, 80)));
        arrays.add(new ArrayList<>(Arrays.asList(3, 10, 2, 1, 20)));
        List<Integer> expected = new ArrayList<>(Arrays.asList(4, 6, 3));
        for (int i = 0; i < 3; ++i) {
            String res = String.format("expected=%d  result=%d", expected.get(i), longestNondecreasingSubsequence(arrays.get(i)));
            System.out.println(res);
        }

    }
}
