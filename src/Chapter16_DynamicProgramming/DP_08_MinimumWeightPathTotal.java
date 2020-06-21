package Chapter16_DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DP_08_MinimumWeightPathTotal {
    public static int minimumWeightPathTotal(List<List<Integer>> triangle) {
        List<Integer> last = triangle.get(triangle.size() - 1);
        List<Integer> minSums = new ArrayList<>();
        for (int j = 0; j < last.size(); ++j) {
            minSums.add(getMinSum(triangle.size() - 1, j, triangle));
        }
        return Collections.min(minSums);
    }

    public static int getMinSum(int i, int j, List<List<Integer>> triangle) {
        // base case
        if (i == 0) {
            return triangle.get(i).get(0);
        }
        int minSumLeft = j == 0 ? Integer.MAX_VALUE : getMinSum(i - 1, j - 1, triangle);
        int minSumTop = j == triangle.get(i).size() - 1 ? Integer.MAX_VALUE : getMinSum(i - 1, j, triangle);
        return triangle.get(i).get(j) + Math.min(minSumLeft, minSumTop);
    }

    // book solution:
    public static int minimumWeightPathTotal2(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }
        List<Integer> prevRow = new ArrayList<>(triangle.get(0));
        for (int i = 1; i < triangle.size(); ++i) {
            List<Integer> currRow = new ArrayList<>(triangle.get(i));
            // first element:
            currRow.set(0, currRow.get(0) + prevRow.get(0));
            // mid elements:
            for (int j = 1; j < currRow.size() - 1; ++j) {
                currRow.set(j, currRow.get(j) + Math.min(prevRow.get(j - 1), prevRow.get(j)));
            }
            // last element:
            currRow.set(
                    currRow.size() - 1,
                    currRow.get(currRow.size() - 1) + prevRow.get(prevRow.size() - 1)
            );
            prevRow = currRow;
        }
        return Collections.min(prevRow);
    }

    public static void test() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(2)));
        triangle.add(new ArrayList<>(Arrays.asList(4, 4)));
        triangle.add(new ArrayList<>(Arrays.asList(8, 5, 6)));
        triangle.add(new ArrayList<>(Arrays.asList(4, 2, 6, 2)));
        triangle.add(new ArrayList<>(Arrays.asList(1, 5, 2, 3, 4)));
        System.out.println("expected = 15;  result = " + minimumWeightPathTotal(triangle));
    }
}
