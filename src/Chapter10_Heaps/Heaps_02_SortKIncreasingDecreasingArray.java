package Chapter10_Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Heaps_02_SortKIncreasingDecreasingArray {
    private static enum SubarrayType {INCREASING, DECREASING}

    ;

    public static List<Integer> sortKIncreasingDecreasingArray(List<Integer> arr) {
        List<List<Integer>> sortedSubArrays = new ArrayList<>();
        SubarrayType subarrayType = SubarrayType.INCREASING;
        int startIndex = 0;
        for (int i = 1; i <= arr.size(); ++i) {
            if (i == arr.size()
                    || (arr.get(i - 1) < arr.get(i) && subarrayType == SubarrayType.DECREASING)
                    || (arr.get(i - 1) >= arr.get(i) && subarrayType == SubarrayType.INCREASING)) {
                List<Integer> subList = arr.subList(startIndex, i);
                if (subarrayType == SubarrayType.DECREASING) {
                    Collections.reverse(subList);
                }
                sortedSubArrays.add(subList);
                startIndex = i;
                subarrayType = subarrayType == SubarrayType.INCREASING
                        ? SubarrayType.DECREASING
                        : SubarrayType.INCREASING;
            }
        }
        return Heaps_01_MergeSortedArrays.mergeSortedArrays2(sortedSubArrays);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(57, 131, 493, 294, 221, 339, 418, 452, 442, 190));
        List<Integer> res = sortKIncreasingDecreasingArray(arr);
        System.out.println("original: " + arr);
        System.out.println("result: " + res);
    }
}
