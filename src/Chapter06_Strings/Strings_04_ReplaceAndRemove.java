package Chapter06_Strings;

import Util.Util;

import java.util.Arrays;

public class Strings_04_ReplaceAndRemove {
    // replace 'a' with two 'd'
    // remove 'b'
    public static int replaceAndRemove(Character[] arr, int size) {
        // forward iteration
        int writeIndex = 0, aCount = 0;
        for (int i = 0; i < size; ++i) {
            if (arr[i] != 'b') {
                arr[writeIndex++] = arr[i];
            }
            if (arr[i] == 'a') {
                ++aCount;
            }
        }

        // backward iteration
        int curIndex = writeIndex - 1;
        writeIndex = writeIndex + aCount - 1;
        final int finalSize = writeIndex + 1;
        while (curIndex >= 0) {
            if (arr[curIndex] == 'a') {
                arr[writeIndex--] = 'd';
                arr[writeIndex--] = 'd';
            } else {
                arr[writeIndex--] = arr[curIndex];
            }
            --curIndex;
        }
        return finalSize;
    }

    public static void main(String[] args) {
        Character[] arr = {'a', 'c', 'd', 'b', 'b', 'c', 'a'};
        System.out.println("case1: ");
        System.out.println("input:");
        Util.printArr(arr);
        replaceAndRemove(arr, 7);
        System.out.println("result: ");
        Util.printArr(arr);

        System.out.println("case2: ");
        arr = new Character[5];
        char[] arr2 = {'a', 'b', 'a', 'c', '_'};
        for (int i = 0; i < arr2.length; ++i) {
            arr[i] = arr2[i];
        }
        System.out.println("input: ");
        Util.printArr(arr);
        replaceAndRemove(arr, 4);
        System.out.println("output: ");
        Util.printArr(arr);
    }
}
