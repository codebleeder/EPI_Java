package Chapter11_Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Searching_09_FindMissingElement {
    private static class DuplicateAndMissing {
        public Integer duplicate;
        public Integer missing;

        public DuplicateAndMissing(Integer duplicate, Integer missing) {
            this.duplicate = duplicate;
            this.missing = missing;
        }

        public String toString() {
            return String.format("duplicate: %d, missing: %d", duplicate, missing);
        }
    }

    public static DuplicateAndMissing findDuplicateAndMissing(List<Integer> arr) {
        Integer missXORDup = 0;

        for (int i = 0; i < arr.size(); ++i) {
            missXORDup ^= i ^ arr.get(i);
        }
        System.out.println("missXorDup = " + Integer.toBinaryString(missXORDup));
        int differBit = missXORDup & (~(missXORDup - 1));
        System.out.println("differBit = " + differBit);
        int missOrDup = 0;
        for (int i = 0; i < arr.size(); ++i) {
            if ((i & differBit) != 0) {
                missOrDup ^= i;
            }
            if ((arr.get(i) & differBit) != 0) {
                missOrDup ^= arr.get(i);
            }
        }
        System.out.println("missOrDup = " + missOrDup);

        for (int a : arr) {
            if (a == missOrDup) {
                // it's a duplicate:
                DuplicateAndMissing res = new DuplicateAndMissing(missOrDup, missOrDup ^ missXORDup);
                System.out.println("result = " + res.toString());
                return res;
            }
        }
        // it's the missing value:
        DuplicateAndMissing res = new DuplicateAndMissing(missOrDup ^ missXORDup, missOrDup);
        System.out.println("result = " + res.toString());
        return res;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(5, 3, 0, 3, 1, 2));
        DuplicateAndMissing res = findDuplicateAndMissing(arr);
    }
}
