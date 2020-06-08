package Chapter16_DynamicProgramming;

public class DP_03_NumberOfWays {
    public static int numberOfWays(int n, int m) {
        int[][] grid = new int[n][m];
        return helper(n - 1, m - 1, grid);
    }

    public static int helper(int i, int j, int[][] grid) {
        if (i == 0 || j == 0) {
            return 1;
        }
        int top = helper(i - 1, j, grid);
        int left = helper(i, j - 1, grid);
        return top + left;
    }

    // book solution
    public static int helper2(int i, int j, int[][] grid) {
        if (i == 0 && j == 0) {
            return 1;
        }
        int top = i == 0 ? 0 : helper(i - 1, j, grid);
        int left = j == 0 ? 0 : helper(i, j - 1, grid);
        return top + left;
    }

    public static void test() {
        System.out.println(numberOfWays(5, 5));
    }
}
