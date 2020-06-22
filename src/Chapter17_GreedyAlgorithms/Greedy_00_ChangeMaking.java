package Chapter17_GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Greedy_00_ChangeMaking {
    public static int changeMaking(int cents) {
        final int[] COINS = {100, 50, 25, 10, 5, 1};
        int numCoins = 0;
        for (int i = 0; i < COINS.length; ++i) {
            numCoins += cents / COINS[i];
            cents %= COINS[i];
        }
        return numCoins;
    }

    public static void test() {
        List<Integer> cases = new ArrayList<>(Arrays.asList(200, 201, 235));
        List<Integer> expected = new ArrayList<>(Arrays.asList(2, 3, 4));
        for (int i = 0; i < 3; ++i) {
            String output = String.format("no. of coins for %d=%d  expected=%d",
                    cases.get(i),
                    changeMaking(cases.get(i)),
                    expected.get(i));
            System.out.println(output);
        }
    }
}
