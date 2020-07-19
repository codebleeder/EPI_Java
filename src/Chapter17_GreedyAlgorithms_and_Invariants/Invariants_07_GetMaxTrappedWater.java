package Chapter17_GreedyAlgorithms_and_Invariants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Invariants_07_GetMaxTrappedWater {
    public static int getMaxTrappedWater(List<Integer> heights) {
        int i = 0, j = heights.size() - 1;
        int maxArea = 0;
        while (i < j) {
            int area = (j - i) * Math.min(heights.get(i), heights.get(j));
            if (area > maxArea) {
                maxArea = area;
            }
            if (heights.get(i) <= heights.get(j)) {
                ++i;
            } else {
                --j;
            }
        }
        return maxArea;
    }

    public static void test() {
        List<Integer> heights = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 4, 5, 6, 2, 1,
                3, 1, 3, 2, 1, 2, 4, 1));
        System.out.println("expected = 48  result = " + getMaxTrappedWater(heights));
    }
}
