package Chapter13_Sorting;

import Util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorting_02_MergeTwoSortedArrays {
    public static void mergeTwoSortedArrays(List<Integer> A, int m,
                                            List<Integer> B, int n){
        int iWriter = m+n-1, iB = n - 1, iA = m - 1;
        while (iA >= 0 && iB >= 0 && iWriter >= 0){
            Integer itemA = A.get(iA);
            Integer itemB = B.get(iB);
            if (itemA > itemB){
                A.set(iWriter, itemA);
                iA--;
            }
            else {
                A.set(iWriter, itemB);
                iB--;
            }
            iWriter--;
        }
        while (iB >= 0){
            A.set(iWriter--, B.get(iB--));
        }
    }
    public static void test(){
        List<Integer> A = new ArrayList<>(7);
        A.add(5);
        A.add(13);
        A.add(17);
        for(int i = 0; i < 4; i++){
            A.add(null);
        }
        List<Integer> B = Arrays.asList(3, 7, 11, 19);
        mergeTwoSortedArrays(A, 3, B, 4);
        Util.printCollection(A);
    }
}
