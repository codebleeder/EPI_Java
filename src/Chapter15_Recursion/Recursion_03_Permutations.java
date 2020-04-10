package Chapter15_Recursion;

import Chapter05_Arrays.Arrays_11_NextPermutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Recursion_03_Permutations {
    public static List<List<Integer>> permutations(List<Integer> a){
        List<List<Integer>> result = new ArrayList<>();
        directedPermutations(0, a, result);
        return result;
    }
    public static void directedPermutations(int index, List<Integer> a, List<List<Integer>> result){
        if (index == a.size()-1){
            result.add(new ArrayList<>(a));
            return;
        }
        for (int j = index; j < a.size(); j++){
            Collections.swap(a, index, j);
            directedPermutations(index + 1, a, result);
            Collections.swap(a, index, j);
        }
    }
    // implementation 2:
    public static List<List<Integer>> permutations2(List<Integer> arr){
        List<List<Integer>> result = new ArrayList<>();
        Collections.sort(arr);
        do {
            result.add(new ArrayList<>(arr));
            arr = Arrays_11_NextPermutation.nextPermutation(arr);
        } while (!arr.isEmpty());
        return result;
    }
    public static void test(){
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<List<Integer>> res = permutations2(a);
        for (int i = 0; i < res.size(); i++){
            Util.Util.printCollection(res.get(i));
        }
    }
}
