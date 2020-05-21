package Chapter15_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion_09_SolveSudoku {
    private static final int EMPTY_ENTRY = 0;
    public static boolean solveSudoku(List<List<Integer>> grid){
        return helper2(0, 0, grid);
    }
    public static boolean helper(int i, int j, List<List<Integer>> grid){
        if(i == grid.size()){
            i = 0; // start a new row
            if(++j == grid.get(i).size()){
                return true;
            }
        }

        if(grid.get(i).get(j) != EMPTY_ENTRY){
            return helper(i+1, j, grid);
        }

        for(int val=1; val <= grid.size(); val++){
            if(isValidToAddVal(grid, i, j, val)){
                grid.get(i).set(j, val);
                if (helper(i+1, j, grid)){
                    return true;
                }
            }
        }

        grid.get(i).set(j, EMPTY_ENTRY);
        return false;
    }
    public static boolean isValidToAddVal(List<List<Integer>> grid, int i, int j, int val){
        // check row constraints
        for(List<Integer> row : grid){
            if(val == row.get(j)){
                return false;
            }
        }

        // check column constraints
        for(int e: grid.get(i)){
            if(val == e){
                return false;
            }
        }

        // check region constraints
        int regionSize = (int)Math.sqrt(grid.size());
        int I = i/regionSize;
        int J = j/regionSize;
        for (int a = 0; a < regionSize; a++){
            for(int b = 0; b < regionSize; b++){
                if (val == grid
                        .get(regionSize * I + a)
                .get(regionSize * J + b)){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean helper2(int i, int j, List<List<Integer>> grid){
        if(i == grid.size()){
            i = 0;
            if(++j == grid.size()){
                return true;
            }
        }
        // skip
        if(grid.get(i).get(j) != EMPTY_ENTRY){
            return helper2(i+1, j, grid);
        }

        for(int val = 1; val <= grid.size(); val++){
            if(isValidToAddVal(grid, i, j, val)){
                grid.get(i).set(j, val);
                if(helper2(i+1, j, grid)){
                    return true;
                }
            }
        }

        grid.get(i).set(j, EMPTY_ENTRY);
        return false;
    }
    public static void test() {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList(4,0,0,0,0,0,8,0,5)));
        grid.add(new ArrayList<>(Arrays.asList(0,3,0,0,0,0,0,0,0)));
        grid.add(new ArrayList<>(Arrays.asList(0,0,0,7,0,0,0,0,0)));
        grid.add(new ArrayList<>(Arrays.asList(0,2,0,0,0,0,0,6,0)));
        grid.add(new ArrayList<>(Arrays.asList(0,0,0,0,8,0,4,0,0)));
        grid.add(new ArrayList<>(Arrays.asList(0,0,0,0,1,0,0,0,0)));
        grid.add(new ArrayList<>(Arrays.asList(0,0,0,6,0,3,0,7,0)));
        grid.add(new ArrayList<>(Arrays.asList(5,0,0,2,0,0,0,0,0)));
        grid.add(new ArrayList<>(Arrays.asList(1,0,4,0,0,0,0,0,0)));
        System.out.println("unsolved grid: ");
        printGrid(grid);
        solveSudoku(grid);
        System.out.println("Solved grid: ");
        printGrid(grid);
    }
    public static void printGrid(List<List<Integer>> grid){
        for(int iRow=0; iRow < grid.size(); iRow++){
            StringBuilder sb = new StringBuilder();
            for(int iCol = 0; iCol < grid.size(); iCol++){
                String divider = (iCol + 1)%3 == 0 ? "| " : "";
                sb.append(grid.get(iRow).get(iCol) + " " + divider);
            }
            System.out.println(sb.toString());
            if((iRow + 1)%3 == 0){
                System.out.println("------+-------+-------");
            }
        }
    }
}
