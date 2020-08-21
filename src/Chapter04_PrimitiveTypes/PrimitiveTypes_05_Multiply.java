package Chapter04_PrimitiveTypes;

public class PrimitiveTypes_05_Multiply {
    public static int multiply(int a, int b) {
        int sum = 0;
        while (a != 0) {
            if ((a & 1) != 0) {
                sum = add(sum, b);
            }
            a >>>= 1;
            b <<= 1;
        }
        return sum;
    }

    public static int add(int a, int b) {
        int tempA = a, tempB = b, k = 1, carryin = 0, sum = 0;
        while (tempA != 0 || tempB != 0) {
            int ak = a & k, bk = b & k;
            int carryout = (ak & bk) | (ak & carryin) | (bk & carryin);
            int sk = ak ^ bk ^ carryin;
            sum = sum | sk;

            carryin = carryout << 1;
            k = k << 1;
            tempA = tempA >>> 1;
            tempB = tempB >>> 1;
        }
        return sum | carryin;
    }

    public static void test() {
        System.out.println("5 x 6 = " + multiply(5, 6));
    }
}
