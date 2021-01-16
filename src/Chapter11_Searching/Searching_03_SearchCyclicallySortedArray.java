package Chapter11_Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Searching_03_SearchCyclicallySortedArray {
    public static int searchSmallest(List<Integer> arr) {
        int left = 0, right = arr.size() - 1;
        while (left < right) {
            int mid = left + ((right - left) / 2);
            if (arr.get(mid) > arr.get(right)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(378, 478, 550, 631, 103, 203, 220, 234, 279, 368));
        System.out.println(searchSmallest(arr));
    }
}
