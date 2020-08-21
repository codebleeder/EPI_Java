package Chapter04_PrimitiveTypes;

public class PrimitiveTypes_07_Power {
    public static double power(double x, int y) {
        double result = 1.0;
        long power = y;
        if (y < 0) {
            power = -power;
            x = 1.0 / x;
        }
        while (power != 0) {
            if ((power & 1) != 0) { // if LSB != 0
                result *= x;
            }
            x *= x;
            power >>>= 1;
        }
        return result;
    }

    public static void test() {
        double x = 2.0;
        int y = 0b1010;
        System.out.println(String.format("%f^%d=%f", x, y, power(x, y)));

        x = 2.0;
        y = -4;
        System.out.println(String.format("%f^%d=%f", x, y, power(x, y)));

        x = 2.0;
        y = 3;
        System.out.println(String.format("%f^%d=%f", x, y, power(x, y)));
    }

    public static void main(String[] args) {
        test();
    }
}
