package Chapter05_Arrays;

import Util.Util;

import java.util.*;

public class Arrays_12_RandomSampling {
    public static void randomSampling(List<Integer> list, int n) {
        Random random = new Random();
        for (int i = 0; i < n; ++i) {
            int randomIndex = i + random.nextInt(list.size() - i);
            Collections.swap(list, i, randomIndex);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(11, 23, 24, 93, 54, 21));
        System.out.println("input: ");
        Util.printCollection(list);
        randomSampling(list, 4);
        System.out.println("output: ");
        Util.printCollection(list.subList(0, 5));
    }
}
