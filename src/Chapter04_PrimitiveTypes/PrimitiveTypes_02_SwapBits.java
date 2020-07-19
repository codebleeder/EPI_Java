package Chapter04_PrimitiveTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PrimitiveTypes_02_SwapBits {
    public static long swapBits(long x, int i, int j) {
        if (((x >>> i) & 1) != ((x >>> j) & 1)) {
            long bitMask = (1L << i) | (1L << j);
            x ^= bitMask;
        }
        return x;
    }

    public static void test() {
        List<Integer> testCases = new ArrayList<>(Arrays.asList(10, 23, 43));
        for (int n : testCases) {
            Random random = new Random();
            Integer i = random.nextInt(5);
            Integer j = random.nextInt(5);
            String output = String.format("SwapBits(%s, %d, %d) = %s", Integer.toBinaryString(n), i, j, Long.toBinaryString(swapBits(n, i, j)));
            System.out.println(output);
        }
    }
}
