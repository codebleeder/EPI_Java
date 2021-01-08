package Chapter11_Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Searching_00_BSearch {
    public static int bsearch(int target, List<Integer> arr) {
        int low = 0, high = arr.size() - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2); // many texts confuse
            if (arr.get(mid) == target) {
                return mid;
            } else if (arr.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 5, 6, 7, 9));
        Integer res1 = bsearch(7, arr);
        System.out.println(res1);

        Integer res2 = bsearch(2, arr);
        System.out.println(res2);

        Integer res3 = bsearch(8, arr);
        System.out.println(res3);
    }
}
