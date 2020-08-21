package Chapter04_PrimitiveTypes;

public class PrimitiveTypes_06_Divide {
    public static void main(String[] args) {
        test();
    }

    public static long divide(long x, long y) {
        //2^k * y < x
        long q = 0;
        long k = 0;
        long twoPowerKY = y;
        while (twoPowerKY < x) {
            twoPowerKY <<= 1;
            ++k;
        }
        --k;
        twoPowerKY = twoPowerKY >> 1;
        q += (1 << k);
        x -= twoPowerKY;
        while (x > y) {
            x -= y;
            ++q;
        }
        return q;
    }

    // book solution:
    public static long divide2(long x, long y) {
        long result = 0;
        int power = 32;
        long yPower = y << power;
        while (x >= y) {
            while (yPower > x) {
                yPower >>>= 1;
                --power;
            }
            result += 1L << power;
            x -= yPower;
        }
        return result;
    }

    public static void test() {
        long x = 11;
        long y = 2;
        System.out.println(String.format("%d/%d=%d", x, y, divide(x, y)));
    }
}
