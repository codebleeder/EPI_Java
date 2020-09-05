package Chapter05_Arrays;

import Util.Util;

import java.util.*;

public class Arrays_14_ComputeRandomPermutation {
    public static List<Integer> computeRandomPermutation(int n) {
        List<Integer> perm = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            perm.add(i);
        }
        Arrays_12_RandomSampling.randomSampling(perm, n);
        return perm;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; ++i) {
            Util.printCollection(computeRandomPermutation(4));
        }

    }
}
