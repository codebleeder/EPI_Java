package Chapter15_Recursion;

import Util.Util;

import java.util.ArrayList;
import java.util.List;

public class Recursion_06_GenerateBalancedParanthesis {
    // my solution before referring the book:
    public static List<String> generateBalancedParanthesis(int n){
        List<String> results = new ArrayList<>();
        helper(n, "", 0, 0, results);
        return results;
    }
    public static void helper(int n,
                              String candidate,
                              int leftCount,
                              int rightCount,
                              List<String> results){
        if ((leftCount < rightCount) || leftCount > n) {
            return;
        }
        if ((leftCount == rightCount && leftCount == n)){
            results.add(candidate);
            return;
        }
        if (candidate.equals("")){
            results.add(candidate);
        }
        leftCount++;
        helper(n, candidate + "(", leftCount, rightCount, results);
        leftCount--;
        rightCount++;
        helper(n, candidate + ")", leftCount, rightCount, results);
    }

    // book solution:
    public static List<String> generateBalancedParanthesis2(int numPairs){
        List<String> result = new ArrayList<>();
        helper2(numPairs, numPairs, "", result);
        return result;
    }
    public static void helper2(int numLeftParensNeeded,
                               int numRightParensNeeded,
                               String validPrefix,
                               List<String> result){
        if (numRightParensNeeded == 0){
            result.add(validPrefix);
            return;
        }
        if (numLeftParensNeeded > 0){
            helper2(numLeftParensNeeded-1,
                    numRightParensNeeded,
                    validPrefix + "(",
                    result);
        }
        if (numLeftParensNeeded < numRightParensNeeded){
            helper2(numLeftParensNeeded,
                    numRightParensNeeded-1,
                    validPrefix + ")",
                    result);
        }
    }
    public static void test(){
        List<String> result = new ArrayList<>();
        result = generateBalancedParanthesis2(3);
        Util.printCollection(result);
    }
}
