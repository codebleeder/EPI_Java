package Chapter05_Arrays;

import Util.Util;

import java.util.*;

public class Arrays_15_RandomSubset {
    public static List<Integer> randomSubset(int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < k; ++i) {
            int randomNum = random.nextInt(n + 1);
            //System.out.println("randomNum="+randomNum);
            if (!map.containsKey(randomNum)) {
                map.put(i, randomNum);
                map.put(randomNum, i);
            } else {
                int firstKey = map.get(randomNum);
                map.put(randomNum, i);
                map.put(i, firstKey);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            result.add(map.get(i));
        }
        return result;
    }

    //book solution:
    public static List<Integer> randomSubset2(int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < k; ++i) {
            int randomNum = i + random.nextInt(n - i);
            Integer ptr1 = map.get(randomNum);
            Integer ptr2 = map.get(i);
            if (ptr1 == null && ptr2 == null) {
                map.put(randomNum, i);
                map.put(i, randomNum);
            } else if (ptr1 == null && ptr2 != null) { //
                map.put(randomNum, ptr2);
                map.put(i, randomNum);
            } else if (ptr1 != null && ptr2 == null) {
                map.put(randomNum, i);
                map.put(i, ptr1);
            } else {
                map.put(randomNum, ptr2);
                map.put(i, ptr1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            result.add(map.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = randomSubset2(100, 20);
        Util.printCollection(result);
    }
}
