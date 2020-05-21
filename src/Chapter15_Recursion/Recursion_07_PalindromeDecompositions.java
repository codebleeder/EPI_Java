package Chapter15_Recursion;

import Util.Util;

import java.util.ArrayList;
import java.util.List;

public class Recursion_07_PalindromeDecompositions {
    public static List<List<String>> palindromeDecompositions(String input){
        List<List<String>> result = new ArrayList<>();
        helper(input, 0, new ArrayList<String>(), result);
        return result;
    }
    public static void helper(String input, int offset, List<String> partialPartition,
                              List<List<String>> result){
        if (offset == input.length()){
            result.add(new ArrayList<>(partialPartition));
            return;
        }
        for (int i = offset + 1; i <= input.length(); i++){
            String prefix = input.substring(offset, i);
            if (isPalindrome(prefix)){
                partialPartition.add(prefix);
                helper(input, i, partialPartition, result);
                partialPartition.remove(partialPartition.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String prefix){
        for(int i = 0, j = prefix.length() - 1; i < j; i++, j--){
            if(prefix.charAt(i) != prefix.charAt(j)){
                return false;
            }
        }
        return true;
    }
    public static void test(){
        String input = "0204451881";
        List<List<String>> result = new ArrayList<>();
        result = palindromeDecompositions(input);
        for(List<String> e: result){
            Util.printCollection(e);
        }
    }
}
