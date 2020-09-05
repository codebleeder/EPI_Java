package Chapter05_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrays_07_BuyAndSellStockTwice {
    public static int buyAdSellStockTwice(List<Integer> prices) {
        int maxProfit = 0;
        List<Integer> firstBuySellProfits = new ArrayList<>();
        int minPriceSoFar = Integer.MAX_VALUE;

        for (int i = 0; i < prices.size(); ++i) {
            minPriceSoFar = Math.min(minPriceSoFar, prices.get(i));
            maxProfit = Math.max(maxProfit, prices.get(i) - minPriceSoFar);
            firstBuySellProfits.add(maxProfit);
        }

        int maxPriceSoFar = Integer.MIN_VALUE;
        maxProfit = 0;
        for (int i = prices.size() - 1; i > 0; --i) {
            maxPriceSoFar = Math.max(maxPriceSoFar, prices.get(i));
            maxProfit = Math.max(maxProfit,
                    firstBuySellProfits.get(i - 1) + (maxPriceSoFar - prices.get(i)));
        }
        return maxProfit;
    }

    public static void test() {
        List<Integer> testList = new ArrayList<>(
                Arrays.asList(12, 11, 13, 9, 12, 8, 14, 13, 15)
        );
        System.out.println("result: " + buyAdSellStockTwice(testList) + " expected: 10");
    }

    public static void main(String[] args) {
        test();
    }
}
