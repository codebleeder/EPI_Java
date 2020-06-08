package Chapter16_DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP_00_MaxSubarray {
    public static int maxSubarray(List<Integer> arr) {
        int runningSum = 0, minSum = 0, maxSum = 0;
        for (int n : arr) {
            runningSum += n;
            if (runningSum < minSum) {
                minSum = runningSum;
            }
            if (runningSum - minSum > maxSum) {
                maxSum = runningSum - minSum;
            }
        }
        return maxSum;
    }

    // my solution:
    public static int maxSubarray2(List<Integer> arr) {
        int maxSoFar = 0;
        int prevSum = 0;
        for (int i = 0; i < arr.size(); ++i) {
            int added = arr.get(i) + prevSum;
            prevSum = added > arr.get(i) ? added : arr.get(i);
            maxSoFar = maxSoFar > prevSum ? maxSoFar : prevSum;
        }
        return maxSoFar;
    }

    public static void test() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(904, 40, 523, 12, -335, -385, -124, 481, -31));
        System.out.println("max subarray sum: " + maxSubarray(arr));

        List<Integer> arr2 = new ArrayList<>(Arrays.asList(-1, -2, -3, 1, 2, 3, -1));
        System.out.println("max subarray sum: " + maxSubarray(arr2));
    }
}
