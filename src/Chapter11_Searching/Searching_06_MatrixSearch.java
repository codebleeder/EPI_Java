package Chapter11_Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Searching_06_MatrixSearch {
    public static boolean matrixSearch(List<List<Integer>> arr, int k) {
        int colSize = arr.get(0).size();
        int rowSize = arr.size();
        int row = 0, col = colSize - 1;
        while (row < rowSize && col >= 0) {
            int val = arr.get(row).get(col);
            if (val == k) {
                return true;
            } else if (val > k) {
                --col;
            } else {
                ++row;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>(Arrays.asList(-1, 2, 4, 4, 6)));
        arr.add(new ArrayList<>(Arrays.asList(1, 5, 5, 9, 21)));
        arr.add(new ArrayList<>(Arrays.asList(3, 6, 6, 9, 22)));
        arr.add(new ArrayList<>(Arrays.asList(3, 6, 8, 10, 24)));
        arr.add(new ArrayList<>(Arrays.asList(6, 8, 9, 12, 25)));
        arr.add(new ArrayList<>(Arrays.asList(8, 10, 12, 13, 40)));

        System.out.println("search(7) = " + matrixSearch(arr, 7)); // false
        System.out.println("search(7) = " + matrixSearch(arr, 8)); // true
    }
}
