package Chapter16_DynamicProgramming;

public class DP_10_NumberOfWaysToTop {
    public static int numberOfWaysToTop(int n, int k) {
        return helper(n, k, new int[n + 1]);
    }

    public static int helper(int n, int k, int[] results) {
        if (n <= 1) {
            return 1;
        }

        if (results[n] == 0) {
            int sum = 0;
            for (int i = 1; i <= k; ++i) {
                sum += helper(n - i, k, results);
            }
            results[n] = sum;
        }
        return results[n];
    }

    public static void test() {
        int n = 4, k = 2;
        System.out.println(String.format("no. of combinations for n = %d with max step of %d:", n, k));
        System.out.println("expected = 5  result = " + numberOfWaysToTop(n, k));
    }
}
