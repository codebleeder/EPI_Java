package Chapter05_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrays_06_ComputeMaxProfit {
    public static int computeMaxProfit(List<Integer> prices) {
        int maxProfit = 0;
        int minSoFar = Integer.MAX_VALUE;
        for (Integer price : prices) {
            maxProfit = Math.max(maxProfit, price - minSoFar);
            minSoFar = Math.min(price, minSoFar);
        }
        return maxProfit;
    }

    public static void test() {
        List<Integer> prices = new ArrayList<>(Arrays.asList(310, 315, 275, 295, 260, 270, 290, 230, 255, 250));
        System.out.println("result: " + computeMaxProfit(prices));
    }

    public static void main(String[] args) {
        test();
    }
}
