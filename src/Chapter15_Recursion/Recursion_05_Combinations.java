package Chapter15_Recursion;

import Util.Util;

import java.util.ArrayList;
import java.util.List;

public class Recursion_05_Combinations {
    public static List<List<Integer>> getAllCombinations(int n, int k){
        List<List<Integer>> powerset = new ArrayList<>();
        helper(n, k, 1, new ArrayList<>(), powerset);
        return powerset;
    }
    public static void helper(int n,
                              int k,
                              int index,
                              List<Integer> subset,
                              List<List<Integer>> powerset){
        if (subset.size() == k){
            powerset.add(new ArrayList<>(subset));
            return;
        }
        for(int i=index; i <= n; i++){
            subset.add(i);
            helper(n, k, i+1, subset, powerset);
            subset.remove(subset.size()-1);
        }
    }
    public static void test(){
        List<List<Integer>> res = new ArrayList<>();
        res = getAllCombinations(5, 3);
        for(List<Integer> subset: res){
            Util.printCollection(subset);
        }
    }
}
