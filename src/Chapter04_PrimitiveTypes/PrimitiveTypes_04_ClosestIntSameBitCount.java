package Chapter04_PrimitiveTypes;

public class PrimitiveTypes_04_ClosestIntSameBitCount {
    public static long closestIntSameBitCount(long x) {
        final int num_unsigned_bits = 63;
        for (int i = 0; i < num_unsigned_bits - 1; ++i) {
            long iBit = ((x >>> i) & 1);
            long iPlusOneBit = ((x >>> (i + 1)) & 1);
            if (iBit != iPlusOneBit) {
                // swap bits
                x ^= (1L << i) | (1L << (i + 1));
                return x;
            }
        }
        throw new IllegalArgumentException("all bits are either zero or one");
    }

    public static void test() {
        System.out.println("input = 0111 result = " + Long.toBinaryString(closestIntSameBitCount(7)));
    }
}
