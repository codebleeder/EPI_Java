package Chapter05_Arrays;

import java.util.*;

public class Arrays_17_IsValidSudoku {
    public static boolean isValidSudoku(List<List<Integer>> sudoku) {
        // check rows
        for (int i = 0; i < sudoku.size(); ++i) {
            if (!isValidRow(i, sudoku)) return false;
        }
        // check columns
        for (int j = 0; j < sudoku.get(0).size(); ++j) {
            if (!isValidColumn(j, sudoku)) return false;
        }
        // check 3x3 matrix
        for (int i = 0; i < sudoku.size(); i += 3) {
            for (int j = 0; j < sudoku.get(0).size(); j += 3) {
                if (!isValid3x3Matrix(i, j, sudoku)) return false;
            }
        }
        return true;
    }

    public static boolean isValidRow(int i, List<List<Integer>> sudoku) {
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < sudoku.get(i).size(); ++j) {
            int val = sudoku.get(i).get(j);
            if (val > 0) {
                if (set.contains(val)) {
                    return false;
                }
                set.add(val);
            }
        }
        return true;
    }

    public static boolean isValidColumn(int j, List<List<Integer>> sudoku) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < sudoku.get(i).size(); ++i) {
            int val = sudoku.get(i).get(j);
            if (val > 0) {
                if (set.contains(val)) {
                    return false;
                }
                set.add(val);
            }
        }
        return true;
    }

    public static boolean isValid3x3Matrix(int startI, int startJ, List<List<Integer>> sudoku) {
        Set<Integer> set = new HashSet<>();
        for (int i = startI; i < startI + 3; ++i) {
            for (int j = startJ; j < startJ + 3; ++j) {
                int val = sudoku.get(i).get(j);
                if (val > 0) {
                    if (set.contains(val)) {
                        return false;
                    }
                    set.add(val);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // valid sudoku
        List<List<Integer>> sudoku = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(5, 3, 0, 0, 7, 0, 0, 0, 0)),
                        new ArrayList<>(Arrays.asList(6, 0, 0, 1, 9, 5, 0, 0, 0)),
                        new ArrayList<>(Arrays.asList(0, 9, 8, 0, 0, 0, 0, 6, 0)),
                        new ArrayList<>(Arrays.asList(8, 0, 0, 0, 6, 0, 0, 0, 3)),
                        new ArrayList<>(Arrays.asList(4, 0, 0, 8, 0, 3, 0, 0, 1)),
                        new ArrayList<>(Arrays.asList(7, 0, 0, 0, 2, 0, 0, 0, 6)),
                        new ArrayList<>(Arrays.asList(0, 6, 0, 0, 0, 0, 2, 8, 0)),
                        new ArrayList<>(Arrays.asList(0, 0, 0, 4, 1, 9, 0, 0, 5)),
                        new ArrayList<>(Arrays.asList(0, 0, 0, 0, 8, 0, 0, 7, 9))
                )
        );
        System.out.println("case1: expected=true  result=" + isValidSudoku(sudoku));

        // duplicate row value - expected = false
        List<List<Integer>> sudoku2 = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(5, 3, 0, 0, 7, 0, 0, 0, 0)),
                        new ArrayList<>(Arrays.asList(6, 0, 0, 1, 9, 5, 0, 0, 0)),
                        new ArrayList<>(Arrays.asList(0, 9, 8, 0, 0, 0, 0, 6, 0)),
                        new ArrayList<>(Arrays.asList(8, 0, 0, 0, 6, 0, 0, 0, 3)),
                        new ArrayList<>(Arrays.asList(4, 0, 0, 8, 0, 3, 0, 0, 1)),
                        new ArrayList<>(Arrays.asList(7, 0, 0, 0, 2, 0, 7, 0, 6)),
                        new ArrayList<>(Arrays.asList(0, 6, 0, 0, 0, 0, 2, 8, 0)),
                        new ArrayList<>(Arrays.asList(0, 0, 0, 4, 1, 9, 0, 0, 5)),
                        new ArrayList<>(Arrays.asList(0, 0, 0, 0, 8, 0, 0, 7, 9))
                )
        );
        System.out.println("case2: expected=false  result=" + isValidSudoku(sudoku2));

        // duplicate column value:
        List<List<Integer>> sudoku3 = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(5, 3, 0, 0, 7, 0, 0, 0, 0)),
                        new ArrayList<>(Arrays.asList(6, 0, 0, 1, 9, 5, 0, 0, 0)),
                        new ArrayList<>(Arrays.asList(0, 9, 8, 0, 0, 0, 0, 6, 0)),
                        new ArrayList<>(Arrays.asList(8, 0, 0, 0, 6, 0, 0, 0, 3)),
                        new ArrayList<>(Arrays.asList(4, 0, 0, 8, 0, 3, 0, 0, 6)),
                        new ArrayList<>(Arrays.asList(7, 3, 0, 0, 2, 0, 0, 0, 6)),
                        new ArrayList<>(Arrays.asList(0, 6, 0, 0, 0, 0, 2, 8, 0)),
                        new ArrayList<>(Arrays.asList(0, 0, 0, 4, 1, 9, 0, 0, 5)),
                        new ArrayList<>(Arrays.asList(0, 0, 0, 0, 8, 0, 0, 7, 9))
                )
        );
        System.out.println("case3: expected=false  result=" + isValidSudoku(sudoku3));

        // duplicate value in 3x3 matrix
        List<List<Integer>> sudoku4 = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(5, 3, 0, 0, 7, 0, 0, 0, 0)),
                        new ArrayList<>(Arrays.asList(6, 0, 0, 1, 9, 5, 0, 0, 0)),
                        new ArrayList<>(Arrays.asList(0, 9, 8, 0, 0, 0, 0, 6, 0)),
                        new ArrayList<>(Arrays.asList(8, 0, 0, 0, 6, 2, 0, 0, 3)),
                        new ArrayList<>(Arrays.asList(4, 0, 0, 8, 0, 3, 0, 0, 1)),
                        new ArrayList<>(Arrays.asList(7, 0, 0, 0, 2, 0, 0, 0, 6)),
                        new ArrayList<>(Arrays.asList(0, 6, 0, 0, 0, 0, 2, 8, 0)),
                        new ArrayList<>(Arrays.asList(0, 0, 0, 4, 1, 9, 0, 0, 5)),
                        new ArrayList<>(Arrays.asList(0, 0, 0, 0, 8, 0, 0, 7, 9))
                )
        );
        System.out.println("case4: expected=false  result=" + isValidSudoku(sudoku4));
    }
}
