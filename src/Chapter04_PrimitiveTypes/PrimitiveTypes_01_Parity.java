package Chapter04_PrimitiveTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimitiveTypes_01_Parity {
    // naive approach:
    public static int parity1(int x) {
        int res = 0;
        while (x != 0) {
            res ^= (x & 1);
            x = x >>> 1;
        }
        return res;
    }

    // x & (x-1) erases lowest set bit
    public static int parity2(int x) {
        int res = 0;
        while (x != 0) {
            res ^= 1;
            x = x & (x - 1);
        }
        return res;
    }

    // use pre-computed - stores precomputed 4-bit parities
    public static int parity3(short x) {
        final int[] precomputed = {0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0}; // from 0 to 15
        final int mask_size = 4;
        final int bit_mask = 0xF;
        return precomputed[(int) ((x >>> (3 * mask_size)) & bit_mask)]
                ^ precomputed[(int) ((x >>> (2 * mask_size)) & bit_mask)]
                ^ precomputed[(int) ((x >>> mask_size) & bit_mask)]
                ^ precomputed[(int) (x & bit_mask)];

    }

    public static short parity4(long x) {
        int shift = 32;
        while (shift > 0) {
            x ^= x >>> shift;
            shift /= 2;
        }
        return (short) (x & 0x1);
    }
    public static void test() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(5, 2, 10, 7, 234));
        for (int num : nums) {
            String str = String.format("parity of %s = %d", Integer.toBinaryString(num), parity4((long) num));
            System.out.println(str);
        }
    }
}
