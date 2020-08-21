package Chapter04_PrimitiveTypes;

public class PrimitiveTypes_08_Reverse {
    public static long reverse(int x) {
        long result = 0;
        int quotient = Math.abs(x);
        while (quotient != 0) {
            int remainder = quotient % 10;
            quotient = quotient / 10;
            result = result * 10 + remainder;
        }
        return x < 0 ? -result : result;
    }

    public static void test() {
        System.out.println(String.format("reverse of %d = %d", 234, reverse(234)));
    }

    public static void main(String[] args) {
        test();
    }
}
