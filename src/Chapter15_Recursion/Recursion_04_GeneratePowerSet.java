package Chapter15_Recursion;

import Util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion_04_GeneratePowerSet {
    public static List<List<Integer>> generatePowerSet(List<Integer> inputSet){
        List<List<Integer>> powerSet = new ArrayList<>();
        helper(inputSet, 0, new ArrayList<Integer>(), powerSet);
        return powerSet;
    }
    public static void helper(List<Integer> inputSet,
                              int toBeSelected,
                              List<Integer> selectedSoFar,
                              List<List<Integer>> powerSet){
        if (toBeSelected == inputSet.size()){
            powerSet.add(new ArrayList<>(selectedSoFar));
            return;
        }
        selectedSoFar.add(inputSet.get(toBeSelected));
        helper(inputSet, toBeSelected + 1, selectedSoFar, powerSet);
        selectedSoFar.remove(selectedSoFar.size()-1);
        helper(inputSet, toBeSelected + 1, selectedSoFar, powerSet);
    }

    // non-recursive
    private static final double LOG_2 = Math.log(2);
    public static List<List<Integer>> generatePowerSet2(List<Integer> inputSet){
        List<List<Integer>> powerSet = new ArrayList<>();
        for (int intForSubset = 0; intForSubset < (1 << inputSet.size()); ++intForSubset){
            int bitArray = intForSubset;
            List<Integer> subSet = new ArrayList<>();
            while (bitArray != 0){
                subSet.add(inputSet.get((int)(Math.log(bitArray & ~(bitArray-1))/LOG_2)));
                bitArray &= bitArray - 1;
            }
            powerSet.add(subSet);
        }
        return powerSet;
    }
    public static void test(){
        List<List<Integer>> result = generatePowerSet2(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        for (List<Integer> iArr : result){
            Util.printCollection(iArr);
        }
    }
}
