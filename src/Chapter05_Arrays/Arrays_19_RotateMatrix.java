package Chapter05_Arrays;

import Util.Util;

import java.util.*;

public class Arrays_19_RotateMatrix {
    public static void rotateMatrix(List<List<Integer>> matrix) {
        // rotate starting from outermost layer
        final int matrixSize = matrix.size() - 1;
        for (int i = 0; i < matrix.size() / 2; ++i) {
            for (int j = i; j < matrixSize - i; ++j) {
                int temp1 = matrix.get(matrixSize - j).get(i);
                int temp2 = matrix.get(matrixSize - i).get(matrixSize - j); //
                int temp3 = matrix.get(j).get(matrixSize - i); // right
                int temp4 = matrix.get(i).get(j); //top

                matrix.get(i).set(j, temp1);
                matrix.get(matrixSize - j).set(i, temp2);
                matrix.get(matrixSize - i).set(matrixSize - j, temp3);
                matrix.get(j).set(matrixSize - i, temp4);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 2, 3)),
                        new ArrayList<>(Arrays.asList(4, 5, 6)),
                        new ArrayList<>(Arrays.asList(7, 8, 9))
                )
        );
        System.out.println("input: ");
        for (int i = 0; i < matrix.size(); ++i) {
            Util.printCollection(matrix.get(i));
        }
        rotateMatrix(matrix);
        System.out.println("result: ");
        for (int i = 0; i < matrix.size(); ++i) {
            Util.printCollection(matrix.get(i));
        }
    }
}
