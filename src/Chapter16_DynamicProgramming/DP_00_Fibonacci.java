package Chapter16_DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class DP_00_Fibonacci {
    private static Map<Integer, Integer> cache = new HashMap<>();

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else if (!cache.containsKey(n)) {
            cache.put(n, fibonacci(n - 2) + fibonacci(n - 1));
        }
        return cache.get(n);
    }

    // reduce cache space complexity to O(1)
    public static int fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }
        int fMinus2 = 0;
        int fMinus1 = 1;
        for (int i = 2; i <= n; ++i) {
            int f = fMinus2 + fMinus1;
            fMinus2 = fMinus1;
            fMinus1 = f;
        }
        return fMinus1;
    }

    public static void test() {
        // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
        /*
        System.out.println(fibonacci(9));
        for(Map.Entry<Integer, Integer> e : cache.entrySet()){
            System.out.println(e.getValue());
        }
        */
        System.out.println(fibonacci2(10));
    }
}
