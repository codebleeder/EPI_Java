package Chapter04_PrimitiveTypes;

import java.util.ArrayList;

public class PrimitiveTypes_03_ReverseBits {
    public static final int[] precomputedReverse = new int[]{
            0, 8, 4, 12, 2, 10, 6, 7, 1, 9, 5, 13, 3, 11, 7, 15
    };

    public static int reverseBits(int x) {
        final int maskSize = 4;
        final int mask = 0xF;

        int y = precomputedReverse[(x >> maskSize * 3)] |
                (precomputedReverse[((x >> maskSize * 2) & mask)] << 1 * maskSize) |
                (precomputedReverse[((x >> maskSize * 1) & mask)] << 2 * maskSize) |
                (precomputedReverse[((x >> maskSize * 0) & mask)] << 3 * maskSize);
        System.out.println("reversed = " + Integer.toBinaryString(y));
        return y;
    }

    public static void test() {
        int x = 47413;
        int expected = 44189;
        System.out.println("result = " + reverseBits(x) + " expected = " + expected);
    }
}
