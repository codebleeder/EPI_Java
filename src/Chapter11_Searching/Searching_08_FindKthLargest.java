package Chapter11_Searching;

import java.util.*;

public class Searching_08_FindKthLargest {

    private static class GreaterThan implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return (a > b) ? -1 : ((a.equals(b)) ? 0 : 1);
        }
    }

    public static int findKthLargest(List<Integer> arr, int k, GreaterThan cmp) {
        int left = 0, right = arr.size() - 1;
        Random r = new Random(0);
        while (left <= right) {
            int pivotIndex = r.nextInt(right - left + 1);
            System.out.println("random pivot index = " + pivotIndex);
            System.out.println("pivot val = " + arr.get(pivotIndex));

            int newPivotIndex = partitionAroundPivot(left, right, pivotIndex, arr, cmp);
            if (newPivotIndex == k - 1) {
                return arr.get(newPivotIndex);
            } else if (newPivotIndex > k - 1) {
                right = newPivotIndex - 1;
            } else {
                left = newPivotIndex + 1;
            }
        }
        return -1;
    }

    private static int partitionAroundPivot(int left, int right,
                                            int pivotIndex, List<Integer> arr,
                                            Comparator<Integer> cmp) {
        int pivotVal = arr.get(pivotIndex);
        int newPivotIndex = left;
        Collections.swap(arr, pivotIndex, right);
        for (int i = left; i < right; ++i) {
            if (cmp.compare(arr.get(i), pivotVal) < 0) {
                Collections.swap(arr, i, newPivotIndex++);
            }
        }
        Collections.swap(arr, right, newPivotIndex);
        return newPivotIndex;
    }

    private static void testPartitionAroundPivot() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 4, 2, 6, 3, 7, 4, 8));
        int left = 0, right = arr.size() - 1, pivotIndex = 1;
        System.out.println(arr);
        int newPivotIndex = partitionAroundPivot(left, right, pivotIndex, arr, new GreaterThan());
        System.out.println("newPivotIndex = " + newPivotIndex);
        System.out.println(arr);
    }

    private static int findKthLargest2(List<Integer> arr, int k) {
        int left = 0, right = arr.size() - 1;
        Random r = new Random(0);
        while (left <= right) {
            int pivotIndex = left + r.nextInt(right - left);
            // pivot array around pivotIndex
            int newPivotIndex = partitionAroundPivot(left,
                    right,
                    pivotIndex,
                    arr,
                    new GreaterThan());
            if (newPivotIndex + 1 == k) {
                return arr.get(newPivotIndex);
            } else if (newPivotIndex < k) {
                left = newPivotIndex + 1;
            } else {
                right = newPivotIndex - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //testPartitionAroundPivot();

        List<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 4, 2, 6, 3, 7, 5, 8));

        //System.out.println("5 largest: " + findKthLargest(arr1, 5, new GreaterThan()));
        System.out.println("5 largest: " + findKthLargest2(arr1, 5));
        System.out.println(arr1);

    }
}
