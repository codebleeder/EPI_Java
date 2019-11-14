package Chapter13_Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorting_09_ValidPlacementExists {
    public static boolean validPlacementExists(List<Integer> a, List<Integer> b){
        Collections.sort(a);
        Collections.sort(b);
        boolean aTallerThanB = true;
        if (!(a.get(a.size()-1) > b.get(b.size()-1))){
            aTallerThanB = false;
        }
        for (int i = a.size()-1; i >= 0; i--){
            if (aTallerThanB){
                if (!(a.get(a.size()-1) >= b.get(b.size()-1))){
                    return false;
                }
            }
            else {
                if (a.get(a.size()-1) >= b.get(b.size()-1)){
                    return false;
                }
            }
        }
        return true;
    }
    public static void test(){
        List<Integer> a = new ArrayList<>(Arrays.asList(
              3, 2, 3, 2
        ));
        List<Integer> b = new ArrayList<>(Arrays.asList(
                2, 2, 1, 1
        ));
        System.out.println("expected: true; result: " + validPlacementExists(a, b));
        b = new ArrayList<>(Arrays.asList(
                2, 3, 1, 1
        ));
        System.out.println("expected: false; result: " + validPlacementExists(a, b));
    }
}
