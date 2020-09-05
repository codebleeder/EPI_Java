package Chapter05_Arrays;

import Util.Util;

import java.util.*;

public class Arrays_10_ApplyPermutation {
    public static void applyPermutation(List<Integer> permutation, List<Character> list) {

        for (int i = 0; i < list.size(); ++i) {
            int next = i;
            while (permutation.get(next) >= 0) {
                Collections.swap(list, i, permutation.get(next));
                int temp = permutation.get(next);
                permutation.set(next, permutation.get(next) - permutation.size());
                next = temp;
            }
        }
        for (int i = 0; i < permutation.size(); ++i) {
            permutation.set(i, permutation.get(i) + permutation.size());
        }
    }

    public static void applyPermutation2(List<Integer> permutation, List<Character> list) {
        for (int i = 0; i < list.size(); ++i) {
            boolean isMin = true;
            int j = permutation.get(i);
            while (j != i) {
                if (j < i) {
                    isMin = false;
                    break;
                }
                j = permutation.get(j);
            }
            if (isMin) {
                cyclicPermutation(i, permutation, list);
            }
        }
    }

    public static void cyclicPermutation(int start, List<Integer> permutation, List<Character> list) {
        int i = start;
        char temp = list.get(start);
        do {
            int nextI = permutation.get(i);
            char nextTemp = list.get(nextI);
            list.set(nextI, temp);
            i = nextI;
            temp = nextTemp;
        } while (i != start);
    }

    public static void main(String[] args) {
        List<Integer> permutation = new ArrayList<>(
                Arrays.asList(3, 0, 1, 2)
        );
        List<Character> list = new ArrayList<>(
                Arrays.asList('a', 'b', 'c', 'd')
        );
        System.out.println("permutation: ");
        Util.printCollection(permutation);
        System.out.println("before permutation: ");
        Util.printCollection(list);
        System.out.println("result: ");
        applyPermutation2(permutation, list);
        Util.printCollection(list);
        System.out.println("expected: ");
        System.out.println("b, c, d, a");
    }
}
