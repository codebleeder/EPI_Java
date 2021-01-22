package Chapter11_Searching;

public class Searching_05_DoubleSquareRoot {
    public static Double squareRoot(Double x) {
        double left, right;
        if (x < 1.0) {
            left = x;
            right = 1.0;
        } else {
            left = 1.0;
            right = x;
        }

        while (compare(left, right) != Ordering.EQUAL) {
            double mid = left + ((right - left) / 2);
            double square = mid * mid;
            if (compare(square, x) == Ordering.LARGER) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    private static enum Ordering {SMALL, EQUAL, LARGER}

    ;

    private static Ordering compare(double a, double b) {
        final double EPSILON = 0.00001;
        double diff = (a - b) / b;
        return diff < -EPSILON
                ? Ordering.SMALL
                : (diff > EPSILON ? Ordering.LARGER : Ordering.EQUAL);

    }

    public static void main(String[] args) {
        double[] inputs = {0.25, 0.2, 25, 7.1};
        for (int i = 0; i < inputs.length; ++i) {
            System.out.println(String.format("sqrt(%f) = %f", inputs[i], squareRoot(inputs[i])));
        }
    }
}
