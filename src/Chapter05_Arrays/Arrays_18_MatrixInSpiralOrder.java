package Chapter05_Arrays;

import Util.Util;

import java.util.*;

public class Arrays_18_MatrixInSpiralOrder {
    public static List<Integer> matrixInSpiralOrder(List<List<Integer>> matrix) {
        List<Integer> result = new ArrayList<>();
        int x = 0;
        int y = 0;
        int fullLength = matrix.size() * matrix.size();
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int currentDir = 0;
        for (int i = 0; i < fullLength; ++i) {
            result.add(matrix.get(x).get(y));
            matrix.get(x).set(y, 0);
            int nextX = x + dir[currentDir][0];
            int nextY = y + dir[currentDir][1];
            if (
                    nextX >= matrix.size() ||
                            nextX < 0 ||
                            nextY >= matrix.size() ||
                            nextY < 0 ||
                            matrix.get(nextX).get(nextY) == 0
            ) {
                currentDir = (currentDir + 1) % 4;
                nextX = x + dir[currentDir][0];
                nextY = y + dir[currentDir][1];
            }
            x = nextX;
            y = nextY;
        }
        return result;
    }

    public static List<Integer> matrixInSpiralOrder2(List<List<Integer>> matrix) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < Math.ceil(matrix.size() * 0.5); ++i) {
            spiral(matrix, i, res);
        }
        return res;
    }

    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static void spiral(List<List<Integer>> matrix, int depth, List<Integer> result) {
        int r = depth;
        int c = depth;
        boolean rowDir = true;
        int rowCount = matrix.size() - (depth * 2);
        int colCount = matrix.get(0).size() - (depth * 2);
        if (rowCount == 1 && colCount == 1) {
            result.add(matrix.get(r).get(c));
            return;
        }
        for (int currentDir = 0; currentDir < 4; ++currentDir) {
            if (rowDir) {
                for (int i = 0; i < rowCount - 1; ++i) {
                    result.add(matrix.get(r).get(c));
                    r += dirs[currentDir][0];
                    c += dirs[currentDir][1];
                }
            } else {
                for (int i = 0; i < colCount - 1; ++i) {
                    result.add(matrix.get(r).get(c));
                    r += dirs[currentDir][0];
                    c += dirs[currentDir][1];
                }
            }
            rowDir = !rowDir;
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 2, 3)),
                        new ArrayList<>(Arrays.asList(8, 9, 4)),
                        new ArrayList<>(Arrays.asList(7, 6, 5))
                )
        );
        List<Integer> result = matrixInSpiralOrder2(matrix);
        Util.printCollection(result);
        System.out.println("expected: 1,2,3,4,5,6,7,8,9");
    }
}
