package Chapter11_Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Searching_01_SearchFirstOfK {
    public static int searchFirstOfK(int target, List<Integer> list) {
        int low = 0, high = list.size() - 1, result = -1;
        while (low <= high) {
            int mid = low + ((high - low) / 2); // many texts confuse
            if (list.get(mid) == target) {
                result = mid;
                high = mid - 1;
            } else if (list.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(-14, -10, 2, 108, 108, 243, 285, 285, 285, 401));
        Integer res1 = searchFirstOfK(108, arr);
        System.out.println(res1);

        Integer res2 = searchFirstOfK(285, arr);
        System.out.println(res2);
    }
}
