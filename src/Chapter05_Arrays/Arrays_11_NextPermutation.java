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
    public static void test(){
        List<Integer> res = nextPermutation(new ArrayList<>(Arrays.asList(6, 2, 1, 5, 4, 3, 0)));
        List<Integer> expected = new ArrayList<>(Arrays.asList(6, 2, 3, 0, 1, 4, 5));
        System.out.println("expected: ");
        Util.printCollection(expected);
        System.out.println("result: ");
        Util.printCollection(res);
    }
}
