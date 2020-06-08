package Chapter16_DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP_01_NumCombinations {
    public static int numCombinationsForFinalScore(int finalScore, List<Integer> individualPlayScore) {
        int[][] grid = new int[individualPlayScore.size()][finalScore + 1];
        for (int i = 0; i < individualPlayScore.size(); ++i) {
            grid[i][0] = 1;
            for (int j = 1; j <= finalScore; ++j) {
                int withoutThisPlay = i > 0 ? grid[i - 1][j] : 0;
                int withThisPlay = j >= individualPlayScore.get(i)
                        ? grid[i][j - individualPlayScore.get(i)]
                        : 0;
                grid[i][j] = withoutThisPlay + withThisPlay;
            }
        }
        return grid[individualPlayScore.size() - 1][finalScore];
    }

    public static void test() {
        List<Integer> individualPlayScores = new ArrayList<>(Arrays.asList(2, 3, 7));
        System.out.println("numCombinations = " + numCombinationsForFinalScore(12, individualPlayScores));
    }
}
