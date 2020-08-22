package Chapter05_Arrays;

import static Chapter05_Arrays.Arrays_00_Utils.swap;

public class Arrays_00_EvenOdd {
    public static void evenOdd(int[] arr) {
        int evenIndex = 0;
        int oddIndex = arr.length - 1;
        while (evenIndex < oddIndex) {
            if (arr[evenIndex] % 2 == 0) {
                ++evenIndex;
            }
            if (arr[oddIndex] % 2 != 0) {
                --oddIndex;
            }
            if (arr[evenIndex] % 2 != 0 && arr[oddIndex] % 2 == 0 && evenIndex < oddIndex) {
                swap(arr, evenIndex, oddIndex);
                ++evenIndex;
                --oddIndex;
            }
        }
    }

    // book solution:
    public static void evenOdd2(int[] arr) {
        int evenIndex = 0;
        int oddIndex = arr.length - 1;
        while (evenIndex < oddIndex) {
            if (arr[evenIndex] % 2 == 0) {
                evenIndex++;
            } else {
                swap(arr, evenIndex, oddIndex);
                oddIndex--;
            }
        }
    }

    public static void test() {
        int[] arr = {1, 2, 3, 4, 5, 6, 21, 44, 46, 31, 93, 91, 12};
        System.out.println("input arr: ");
        Util.Util.printArr(arr);
        evenOdd2(arr);
        System.out.println("output: ");
        Util.Util.printArr(arr);
    }

    public static void main(String[] args) {
        test();
    }
}
