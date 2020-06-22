package Chapter04_PrimitiveTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimitiveTypes_00_CountBits {
    public static int countBits(int x) {
        int numBits = 0;
        while (x != 0) {
            numBits += (x & 1);
            x = x >>> 1;
        }
        return numBits;
    }

    public static void test() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(5, 2, 10));
        for (int num : nums) {
            String str = String.format("num of bits in %s = %d", Integer.toBinaryString(num), countBits(num));
            System.out.println(str);
        }
    }
}
