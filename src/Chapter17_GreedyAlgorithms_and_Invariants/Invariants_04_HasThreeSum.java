package Chapter17_GreedyAlgorithms_and_Invariants;

import Util.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Invariants_04_HasThreeSum {
    public static boolean hasThreeSum(List<Integer> arr, int t) {
        Collections.sort(arr);
        for (int n : arr) {
            if (Invariants_00_HasTwoSum.hasTwoSum(arr, t - n)) {
                return true;
            }
        }
        return false;
    }

    public static void test() {
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(11, 2, 5, 7, 3));
        List<TestCase<Integer, Boolean>> testCases = new ArrayList<>();
        testCases.add(new TestCase<>(21, true));
        testCases.add(new TestCase<>(33, true));
        testCases.add(new TestCase<>(6, true));
        testCases.add(new TestCase<>(50, false));
        testCases.add(new TestCase<>(1, false));
        for (TestCase<Integer, Boolean> test : testCases) {
            String display = String.format("total=%d  result=%b  expected=%b",
                    test.input, hasThreeSum(arr1, test.input), test.expected);
            System.out.println(display);
        }
    }
}
