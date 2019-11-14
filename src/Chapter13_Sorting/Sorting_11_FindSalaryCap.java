package Chapter13_Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorting_11_FindSalaryCap {
    public static double findSalaryCap(int targetPayroll, List<Integer> salaries){
        Collections.sort(salaries);
        int sumOfPrevItems = 0;
        for (int i = 0; i < salaries.size(); i++){
            int totalPayrollWithCurrentItemAsCap = sumOfPrevItems + (salaries.size() - i) * salaries.get(i);
            if (totalPayrollWithCurrentItemAsCap > targetPayroll){
                double res = (targetPayroll - sumOfPrevItems)/(salaries.size()-i-1);
                return res;
            }
            sumOfPrevItems += salaries.get(i);
        }
        return -1;
    }
    public static void test(){
        List<Integer> salaries = new ArrayList<Integer>(Arrays.asList(90, 30, 100, 40, 20));
        double res = findSalaryCap(210, salaries);
        System.out.println(res);
    }
}
