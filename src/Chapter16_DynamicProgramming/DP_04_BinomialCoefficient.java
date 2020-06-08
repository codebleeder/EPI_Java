package Chapter16_DynamicProgramming;

public class DP_04_BinomialCoefficient {
    public static int computeBinomialCoefficient(int n, int k) {
        return helper(n, k, new int[n + 1][k + 1]);
    }

    public static int helper(int n, int k, int[][] grid) {
        if (k == 0 || n == k) {
            return 1;
        }
        int withoutK = helper(n - 1, k, grid);
        int withK = helper(n - 1, k - 1, grid);
        grid[n][k] = withoutK + withK;

        return grid[n][k];
    }

    public static void test() {
        System.out.println(computeBinomialCoefficient(5, 2));
    }
}
