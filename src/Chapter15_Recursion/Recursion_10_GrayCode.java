package Chapter15_Recursion;

import java.util.*;

public class Recursion_10_GrayCode {
    public static List<Integer> grayCode(int numBits){
        List<Integer> result = new ArrayList<>(Arrays.asList(0));
        helper(numBits, new HashSet<Integer>(Arrays.asList(0)), result);
        return result;
    }
    public static boolean helper(int numBits, Set<Integer> history, List<Integer> result){
        if(result.size() == (1 << numBits)){
            return differsByOneBit(result.get(0), result.get(result.size()-1));
        }
        for(int i = 0; i < numBits; ++i){
            int previousCode = result.get(result.size()-1);
            int candidateNextCode = previousCode ^ (1 << i);
            if (!history.contains(candidateNextCode)){
                history.add(candidateNextCode);
                result.add(candidateNextCode);
                if(helper(numBits, history, result)){
                    return true;
                }
                history.remove(candidateNextCode);
                result.remove(result.size()-1);
            }
        }
        return false;
    }
    public static boolean differsByOneBit(int x, int y){
        int bitDifference = x ^ y;
        return bitDifference != 0 && (bitDifference & (bitDifference - 1)) == 0;
    }
    public static List<Integer> grayCode2(int numBits){
        if(numBits == 1){
            return new ArrayList<>(Arrays.asList(0, 1));
        }
        // append zeros
        List<Integer> smallRes = grayCode2(--numBits);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < smallRes.size(); ++i){
            result.add(smallRes.get(i));
        }
        // append ones
        for(int i = smallRes.size()-1; i >= 0; --i){
            result.add((1<<numBits) ^ smallRes.get(i));
        }
        return result;
    }

    // book solution:
    public static List<Integer> grayCode3(int numBits){
        if(numBits == 0){
            return new ArrayList<>(Arrays.asList(0));
        }
        List<Integer> resMinus1 = grayCode3(numBits-1);
        int leadingBit1 = 1 << (numBits - 1);
        for(int i = resMinus1.size()-1; i >= 0; --i){
            resMinus1.add(leadingBit1 | resMinus1.get(i));
        }
        return resMinus1;
    }
    public static void test(){
        List<Integer> result = grayCode3(3);
        for(int i: result){
            String bin = Integer.toBinaryString(i);
            if(bin.length() == 1){
                bin = "00" + bin;
            }
            else if(bin.length() == 2){
                bin = "0" + bin;
            }
            System.out.println(bin);
        }
    }
}
