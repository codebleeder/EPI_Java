package Chapter15_Recursion;

import java.util.ArrayList;
import java.util.List;

public class Recursion_02_nQueens {
    public static List<List<Integer>> nQueens(int n){
        List<List<Integer>> result = new ArrayList<>();
        helper(n, 0, new ArrayList<Integer>(), result);
        return result;
    }
    public static void helper(int n, int row, List<Integer> colPlacement,
                              List<List<Integer>> result){
        if (row == n){
            result.add(new ArrayList<>(colPlacement));
        }
        else {
            for (int col = 0; col < n; ++col){
                colPlacement.add(col);
                if (isValid(colPlacement)){
                    helper(n, row + 1, colPlacement, result);
                }
                colPlacement.remove(colPlacement.size()-1);
            }
        }
    }
    // test if newly placed queen will conflict with any previously placed queens
    public static boolean isValid(List<Integer> colPlacement){
        int rowId = colPlacement.size() - 1;
        for (int i=0; i < rowId; i++){
            int colDiff = Math.abs(colPlacement.get(i) - colPlacement.get(rowId));
            int rowDiff = rowId - i;
            if (colDiff == 0 || colDiff == rowDiff) { // same column or diagonal
                return false;
            }
        }
        return true;
    }
    public static void test(){
        List<List<Integer>> result = nQueens(4);
        System.out.println("for n=4");
        for(int i = 0; i < result.size(); i++) {
            Util.Util.printCollection(result.get(i));
        }

        List<List<Integer>> result2 = nQueens(5);
        System.out.println("for n=5");
        for(int i = 0; i < result2.size(); i++) {
            Util.Util.printCollection(result2.get(i));
        }
    }
}
