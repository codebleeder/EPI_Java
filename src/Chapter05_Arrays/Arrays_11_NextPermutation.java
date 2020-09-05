package Chapter05_Arrays;

import Util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Arrays_11_NextPermutation {
    public static List<Integer> nextPermutation(List<Integer> perm){
        int k = perm.size()-1;
        while (k > 0){
            if (perm.get(k-1)<perm.get(k)) {
                break;
            }
            k--;
        }
        k--;
        if (k == -1){
            return Collections.emptyList();
        }
        // find least value in suffix which is greater than perm[k]
        int swapCandidate = Integer.MAX_VALUE;
        int swapIndex = -1;

        for (int i = perm.size()-1; i > k; i--){
            if (perm.get(i) > perm.get(k)){
                Collections.swap(perm, k, i);
                break;
            }
        }

        // reverse suffix
        Collections.reverse(perm.subList(k+1, perm.size()));
        return perm;
    }

    public static List<Integer> nextPermutation2(List<Integer> perm) {
        // find the longest increasing (from last element) sub-array
        int i = perm.size() - 1;
        while (perm.get(i) < perm.get(i - 1)) {
            --i;
            if (i == 0) return Collections.emptyList();
        }
        // find the index to swap perm[i-1]
        int j = perm.size() - 1;
        while (perm.get(j) < perm.get(i - 1)) {
            --j;
        }
        Collections.swap(perm, i - 1, j);
        // reverse from i
        j = perm.size() - 1;
        while (i < j) {
            Collections.swap(perm, i++, j--);
        }
        return perm;
    }

    public static void test(){
        List<Integer> res = nextPermutation(new ArrayList<>(Arrays.asList(6, 2, 1, 5, 4, 3, 0)));
        List<Integer> expected = new ArrayList<>(Arrays.asList(6, 2, 3, 0, 1, 4, 5));
        System.out.println("expected: ");
        Util.printCollection(expected);
        System.out.println("result: ");
        Util.printCollection(res);

        List<Integer> perm2 = new ArrayList<>(Arrays.asList(3, 2, 1));
        Util.printCollection(perm2);
        System.out.println("output: ");
        Util.printCollection(nextPermutation(perm2));
        System.out.println("expected: null");
    }

    public static void main(String[] args) {
        test();
    }
}
