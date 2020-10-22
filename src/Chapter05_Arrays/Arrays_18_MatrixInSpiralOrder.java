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

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 2, 3)),
                        new ArrayList<>(Arrays.asList(4, 5, 6)),
                        new ArrayList<>(Arrays.asList(7, 8, 9))
                )
        );
        List<Integer> result = matrixInSpiralOrder(matrix);
        Util.printCollection(result);
        System.out.println("expected: 1,2,3,6,9,8,7,4,5");
    }
}
