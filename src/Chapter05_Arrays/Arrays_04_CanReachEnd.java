package Chapter05_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrays_04_CanReachEnd {
    public static boolean canReachEnd(List<Integer> list) {
        return helper(list, 0);
    }

    public static boolean helper(List<Integer> list, int currentIndex) {
        if (currentIndex >= list.size()) return true;
        int current = list.get(currentIndex);
        for (int i = current; i > 0; --i) {
            if (helper(list, currentIndex + i)) {
                return true;
            }
        }
        return false;
    }

    // book solution:
    public static boolean canReachEnd2(List<Integer> list) {
        int furthestReachSoFar = 0, lastIndex = list.size() - 1;
        for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastIndex; ++i) {
            furthestReachSoFar = Math.max(furthestReachSoFar, i + list.get(i));
        }
        return furthestReachSoFar >= lastIndex;
    }

    public static void test() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 3, 0, 0, 2, 0, 1));
        System.out.println("result = " + canReachEnd2(list)); // expected = true

        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 2, 0, 0, 2, 0, 1));
        System.out.println("result = " + canReachEnd2(list2)); // expected = false

        List<Integer> list3 = new ArrayList<>(Arrays.asList(2, 4, 1, 1, 0, 2, 3));
        System.out.println("result = " + canReachEnd2(list3)); // expected = true
    }

    public static void main(String[] args) {
        test();
    }
}
