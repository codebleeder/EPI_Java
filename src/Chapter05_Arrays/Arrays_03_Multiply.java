package Chapter05_Arrays;

import Util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Arrays_03_Multiply {
    public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
        final int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;
        num1.set(0, Math.abs(num1.get(0)));
        num2.set(0, Math.abs(num2.get(0)));

        List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));
        for (int i = num1.size() - 1; i >= 0; --i) {
            for (int j = num2.size() - 1; j >= 0; --j) {
                result.set(i + j + 1, result.get(i + j + 1) + num1.get(i) * num2.get(j));
                result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10);
                result.set(i + j + 1, result.get(i + j + 1) % 10);
            }
        }

        int firstNonZero = 0;
        while (firstNonZero < result.size() && result.get(firstNonZero) == 0) {
            ++firstNonZero;
        }
        result = result.subList(firstNonZero, result.size());

        if (result.isEmpty()) {
            return Arrays.asList(0);
        }
        result.set(0, result.get(0) * sign);
        return result;
    }


    public static void test() {
        List<Integer> num1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> num2 = new ArrayList<>(Arrays.asList(9, 8, 7));
        System.out.println("num1: ");
        Util.printCollection(num1);
        System.out.println("num2: ");
        Util.printCollection(num2);
        System.out.println("product: ");
        Util.printCollection(multiply(num1, num2));
        System.out.println("expected: " + (123 * 987));
    }

    public static void main(String[] args) {
        test();
    }
}
