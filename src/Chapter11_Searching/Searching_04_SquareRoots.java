package Chapter11_Searching;

public class Searching_04_SquareRoots {
    public static int squareRoot(int k) {
        int left = 0, right = k;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int square = mid * mid;
            if (square <= k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return (int) left - 1;
    }

    public static void main(String[] args) {
        System.out.println("sqrt(81) = " + squareRoot(81));
        System.out.println("sqrt(79) = " + squareRoot(79));
    }
}
