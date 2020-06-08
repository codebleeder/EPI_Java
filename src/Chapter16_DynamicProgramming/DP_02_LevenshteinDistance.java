package Chapter16_DynamicProgramming;

import java.util.Arrays;

public class DP_02_LevenshteinDistance {
    public static int levenshteinDistance(String a, String b) {
        int[][] grid = new int[a.length()][b.length()];
        for (int[] row : grid) {
            Arrays.fill(row, -1);
        }
        return helper(a, a.length() - 1, b, b.length() - 1, grid);
    }

    public static int helper(String a, int aIndex, String b, int bIndex, int[][] grid) {
        if (aIndex < 0) {
            return bIndex + 1;
        } else if (bIndex < 0) {
            return aIndex + 1;
        }
        if (grid[aIndex][bIndex] == -1) {
            if (a.charAt(aIndex) == b.charAt(bIndex)) {
                grid[aIndex][bIndex] = helper(a, aIndex - 1, b, bIndex - 1, grid);
            } else {
                int substituteLast = helper(a, aIndex - 1, b, bIndex - 1, grid);
                int addLast = helper(a, aIndex, b, bIndex - 1, grid);
                int deleteLast = helper(a, aIndex - 1, b, bIndex, grid);
                grid[aIndex][bIndex] = 1 + Math.min(substituteLast, Math.min(addLast, deleteLast));
            }
        }
        return grid[aIndex][bIndex];
    }

    public static void test() {
        System.out.println(levenshteinDistance("orchestra", "carthorse"));
    }

}
