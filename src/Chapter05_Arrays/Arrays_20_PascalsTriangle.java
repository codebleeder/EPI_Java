package Chapter05_Arrays;

import Util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrays_20_PascalsTriangle {
    public static List<List<Integer>> pascalsTriangle(int n) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(1)));
        for (int i = 1; i < n; ++i) {
            List<Integer> subList = new ArrayList<>();
            List<Integer> prevList = result.get(i - 1);
            for (int j = 0; j < prevList.size() + 1; ++j) {
                if (j == 0 || j == prevList.size()) {
                    subList.add(1);
                } else {
                    subList.add(prevList.get(j - 1) + prevList.get(j));
                }
            }
            result.add(subList);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = pascalsTriangle(5);
        for (int i = 0; i < result.size(); ++i) {
            System.out.println(result.get(i));
        }
    }
}
