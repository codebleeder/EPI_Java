package Chapter13_Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorting_04_SmallestNonConstructibleValue {
    public static int smallestNonConstructibleValue(List<Integer> a){
        int maxConstructibleValue = 0;
        Collections.sort(a);
        for (int i = 0; i < a.size(); i++){
            int n = a.get(i);
            if (n > maxConstructibleValue + 1){
                break;
            }
            maxConstructibleValue += n;
        }
        return maxConstructibleValue + 1;
    }
    public static void test(){
        List<Integer> t1 = Arrays.asList(12, 2, 1, 15, 2, 4);
        System.out.println(smallestNonConstructibleValue(t1));
    }
}
