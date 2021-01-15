package Chapter11_Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Searching_02_SearchEntryEqualToIndex {
    public static int searchEntryEqualToIndex(List<Integer> list) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2); // many texts confuse
            if (list.get(mid) == mid) {
                return mid;
            } else if (list.get(mid) > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(-2, 0, 2, 3, 6, 7));
        Integer res1 = searchEntryEqualToIndex(arr);
        System.out.println(res1);
    }
}
