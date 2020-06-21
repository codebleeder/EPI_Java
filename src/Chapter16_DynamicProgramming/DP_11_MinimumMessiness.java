package Chapter16_DynamicProgramming;

import Util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP_11_MinimumMessiness {
    public static int minimumMessiness(List<String> words, int lineLength) {
        int[] minMessiness = new int[words.size()];
        Arrays.fill(minMessiness, Integer.MAX_VALUE);
        int numRemainingBlanks = lineLength - words.get(0).length();
        minMessiness[0] = numRemainingBlanks * numRemainingBlanks;
        for (int i = 1; i < words.size(); ++i) {
            numRemainingBlanks = lineLength - words.get(i).length();
            minMessiness[i] = minMessiness[i - 1] + numRemainingBlanks * numRemainingBlanks;
            for (int j = i - 1; j >= 0; --j) {
                numRemainingBlanks -= (words.get(j).length() + 1);
                if (numRemainingBlanks < 0) {
                    break;
                }
                int firstJMessiness = j - 1 < 0 ? 0 : minMessiness[j - 1];
                int currentLineMessiness = numRemainingBlanks * numRemainingBlanks;
                minMessiness[i] = Math.min(minMessiness[i], firstJMessiness + currentLineMessiness);
            }

        }
        Util.printArr(minMessiness);
        return minMessiness[words.size() - 1];
    }

    public static void test() {
        List<String> words = new ArrayList<>(Arrays.asList(
                "aaa",
                "bbb",
                "c",
                "d",
                "ee",
                "ff",
                "ggggggg"
        ));
        System.out.println("min messiness = 36  result = " + minimumMessiness(words, 11));
    }
}
