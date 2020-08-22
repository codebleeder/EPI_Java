package Chapter05_Arrays;

import Util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static Chapter05_Arrays.Arrays_00_Utils.swap;

public class Arrays_01_DutchFlagPartition {
    public static void dutchFlagPartition3(int pivotIndex, List<Integer> list) {
        // move pivot to last index
        swap(list, pivotIndex, list.size() - 1);
        pivotIndex = list.size() - 1;
        int smallIndex = 0;
        int largerIndex = list.size() - 2;
        int equalIndex = list.size() - 1;
        while (smallIndex < largerIndex) {
            if (list.get(smallIndex) > list.get(pivotIndex)) {
                swap(list, smallIndex, largerIndex);
                --largerIndex;
            } else if (list.get(smallIndex) < list.get(pivotIndex)) {
                ++smallIndex;
            } else {
                swap(list, smallIndex, equalIndex);
                --equalIndex;
            }
        }
        int pivot = list.get(list.size() - 1);
        while (equalIndex < list.size() - 1) {
            if (list.get(largerIndex) > pivot) {
                swap(list, equalIndex + 1, largerIndex);
                ++largerIndex;
                ++equalIndex;
            } else {
                ++largerIndex;
            }
        }

    }

    // book solutions:
    public static void dutchFlagPartition2(int pivotIndex, List<Integer> arr) {
        int pivot = arr.get(pivotIndex);

        // first pass
        for (int i = 0; i < arr.size(); ++i) {
            for (int j = i + 1; j < arr.size(); ++j) {
                if (arr.get(j) < pivot) {
                    swap(arr, i, j);
                    break;
                }
            }
        }

        // second pass
        for (int i = arr.size() - 1; i >= 0 && arr.get(i) >= pivot; --i) {
            for (int j = i - 1; j >= 0 && arr.get(j) >= pivot; --j) {
                if (arr.get(j) > pivot) {
                    swap(arr, i, j);
                    break;
                }
            }
        }
    }

    public static void dutchFlagPartition4(int pivotIndex, List<Integer> list) {
        int pivot = list.get(pivotIndex);
        int smaller = 0;
        // group smaller
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) < pivot) {
                Collections.swap(list, smaller++, i);
            }
        }
        // group larger
        int larger = list.size() - 1;
        for (int j = list.size() - 1; j >= smaller; --j) {
            if (list.get(j) > pivot) {
                Collections.swap(list, larger--, j);
            }
        }
    }

    public static void dutchFlagPartition5(int pivotIndex, List<Integer> list) {
        int pivot = list.get(pivotIndex);
        /* invariants during partition:
         *   bottom group: list[0, smaller-1]
         *   middle group: list[smaller, equal-1]
         *   unclassified group: list[equal, larger-1]
         *   top group: list[larger, list.size()-1]
         * */
        int smaller = 0, equal = 0, larger = list.size();
        while (equal < larger) {
            if (list.get(equal) < pivot) {
                Collections.swap(list, smaller++, equal++);
            } else if (list.get(equal) == pivot) {
                ++equal;
            } else {
                Collections.swap(list, --larger, equal);
            }
        }
    }

    public static void test() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 10, 2, 7, 10, 4, 17, 13, 20));
        System.out.println("input arr: (partition around index 5)");
        Util.printCollection(arr);
        dutchFlagPartition5(5, arr);
        System.out.println("result: ");
        Util.printCollection(arr);

        System.out.println();
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(8, 7, 6, 0, 4, 5, 9, 5, 7));
        System.out.println("input arr: (partition around index 5)");
        Util.printCollection(arr2);
        dutchFlagPartition5(5, arr2);
        System.out.println("result: ");
        Util.printCollection(arr2);
    }

    public static void main(String[] args) {
        test();
    }
}
