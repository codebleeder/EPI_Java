package Chapter16_DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP_05_PatternInGrid {
    public static boolean isPatternInGrid(int[][] grid, List<Integer> pattern) {
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                boolean res = helper(i, j, 0, grid, pattern);
                if (res) return true;
            }
        }
        return false;
    }

    public static boolean helper(int i, int j, int k, int[][] grid, List<Integer> pattern) {
        if (k >= pattern.size()) {
            return true;
        }
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] == pattern.get(k)) {
            boolean top = helper(i - 1, j, k + 1, grid, pattern);
            boolean right = helper(i, j + 1, k + 1, grid, pattern);
            boolean bottom = helper(i + 1, j, k + 1, grid, pattern);
            boolean left = helper(i, j - 1, k + 1, grid, pattern);
            return top || right || bottom || left;
        } else {
            return false;
        }
    }

    public static void test() {
        int[][] grid = {{1, 2, 3}, {3, 4, 5}, {5, 6, 7}};
        List<Integer> pattern = new ArrayList<>(Arrays.asList(1, 3, 4, 6));
        System.out.println(isPatternInGrid(grid, pattern));

        List<Integer> pattern2 = new ArrayList<>(Arrays.asList(1, 3, 4, 60));
        System.out.println(isPatternInGrid(grid, pattern2));

        List<Integer> pattern3 = new ArrayList<>(Arrays.asList(3, 5, 7));
        System.out.println(isPatternInGrid(grid, pattern3));
    }
}
