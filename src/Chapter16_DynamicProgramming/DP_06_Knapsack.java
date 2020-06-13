package Chapter16_DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP_06_Knapsack {
    public static class Item {
        public int weight;
        public int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static int computeMaxSubjectToCapacity(List<Item> items, int limit) {
        int[][] grid = new int[items.size()][limit + 1];
        for (int[] row : grid) {
            Arrays.fill(row, -1);
        }
        return helper(items, items.size() - 1, limit, grid);
    }

    public static int helper(List<Item> items, int row, int col, int[][] grid) {
        if (col < 0 || row < 0) {
            return 0;
        }
        if (col == 0) {
            grid[row][col] = 0;
        }
        if (grid[row][col] == -1) {
            int withoutRowItem = helper(items, row - 1, col, grid);
            int usingRowItem = items.get(row).weight <= col ? items.get(row).value + helper(items, row - 1, col - items.get(row).weight, grid) : withoutRowItem;
            grid[row][col] = Math.max(usingRowItem, withoutRowItem);
        }
        return grid[row][col];
    }

    public static void test() {
        List<Item> items = new ArrayList<>(Arrays.asList(
                new Item(1, 1),
                new Item(3, 4),
                new Item(4, 5),
                new Item(5, 7)
        ));
        System.out.println("test1: expected=9  result=" + computeMaxSubjectToCapacity(items, 7));

        List<Item> items2 = new ArrayList<>(Arrays.asList(
                new Item(5, 60),
                new Item(3, 50),
                new Item(4, 70),
                new Item(2, 30)
        ));
        System.out.println("test2: expected=80  result=" + computeMaxSubjectToCapacity(items2, 5));
    }
}
