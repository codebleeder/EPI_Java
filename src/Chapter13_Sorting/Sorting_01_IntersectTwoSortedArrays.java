package Chapter13_Sorting;

import Util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorting_01_IntersectTwoSortedArrays {
    public static List<Integer> intersectTwoSortedArrays(List<Integer> a, List<Integer> b){
        List<Integer> res = new ArrayList<>();
        int iA = 0, iB = 0;
        while (iA < a.size() && iB < b.size()){
            Integer aNum = a.get(iA);
            Integer bNum = b.get(iB);
            if (aNum == bNum && (iA == 0 || aNum != a.get(iA-1))){
                res.add(aNum);
                iA++;
                iB++;
            }
            else if (a.get(iA) > b.get(iB)){
                iB++;
            }
            else {
                iA++;
            }
        }
        return res;
    }
    public static List<Integer> intersectTwoSortedArrays2(List<Integer> a, List<Integer> b){
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < a.size(); i++){
            if ((i == 0 || a.get(i) != a.get(i-1)) &&
                    Collections.binarySearch(b, a.get(i)) >= 0
            ){
                res.add(a.get(i));
            }
        }
        return res;
    }
    public static void test(){
        List<Integer> a = Arrays.asList(2,3,3,5,5,6,7,7,8,12);
        List<Integer> b = Arrays.asList(5,5,6,8,8,9,10,10);
        List<Integer> res = intersectTwoSortedArrays(a, b);
        Util.printCollection(res);
    }
}
