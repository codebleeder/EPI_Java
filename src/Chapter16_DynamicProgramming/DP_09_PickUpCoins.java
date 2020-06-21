package Chapter16_DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DP_09_PickUpCoins {
    public static int pickUpCoins(List<Integer> coins) {
        int[][] grid = new int[coins.size()][coins.size()];
        int res = getMaxSum(0, coins.size() - 1, coins, grid);
        return res;
    }

    public static int getMaxSum(int left, int right, List<Integer> coins, int[][] grid) {
        // base case
        if (right - left <= 1) {
            return Collections.max(coins.subList(left, right + 1));
        }
        if (grid[left][right] == 0) {
            int maxSumIfLeftChosen = coins.get(left)
                    + Math.min(
                    getMaxSum(left + 2, right, coins, grid)
                    , getMaxSum(left + 1, right - 1, coins, grid));
            int maxSumIfRightChosen = coins.get(right)
                    + Math.min(
                    getMaxSum(left + 1, right - 1, coins, grid)
                    , getMaxSum(left, right - 2, coins, grid));
            grid[left][right] = Math.max(maxSumIfLeftChosen, maxSumIfRightChosen);
        }
        return grid[left][right];

    }

    public static void test() {
        List<Integer> coins = new ArrayList<>(Arrays.asList(5, 25, 10, 1));
        System.out.println("expected: 26  result: " + pickUpCoins(coins));

        List<Integer> coins2 = new ArrayList<>(Arrays.asList(10, 25, 5, 1, 10, 5));
        System.out.println("expected: 31  result: " + pickUpCoins(coins2));
    }
}
