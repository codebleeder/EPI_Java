package Chapter17_GreedyAlgorithms_and_Invariants;

import Util.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Invariants_00_HasTwoSum {
    public static boolean hasTwoSum(List<Integer> arr, int t) {
        int i = 0, j = arr.size() - 1;
        while (i <= j) {
            int sum = arr.get(i) + arr.get(j);
            if (sum == t) {
                return true;
            } else if (sum < t) {
                ++i;
            } else {
                --j;
            }
        }
        return false;
    }

    public static void test() {
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(-2, 1, 2, 4, 7, 11));
        List<TestCase<Integer, Boolean>> testCases = new ArrayList<>();
        testCases.add(new TestCase<>(9, true));
        testCases.add(new TestCase<>(18, true));
        testCases.add(new TestCase<>(6, true));
        testCases.add(new TestCase<>(-3, false));
        testCases.add(new TestCase<>(20, false));
        for (TestCase<Integer, Boolean> test : testCases) {
            String display = String.format("total=%d  result=%b  expected=%b", test.input, hasTwoSum(arr1, test.input), test.expected);
            System.out.println(display);
        }
    }
}
