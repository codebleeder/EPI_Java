package Chapter14_BinarySearchTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTrees_09_BuildMinHeightBSTFromSortedArray {
    public static BSTNode<Integer> buildMinHeightBSTFromSortedArray(List<Integer> sortedArr){
        return helper(sortedArr, 0, sortedArr.size());
    }
    public static BSTNode<Integer> helper(List<Integer> arr, int start, int end){
        if (start >= end) {
            return null;
        }
        int mid = start + (end-start)/2;
        BSTNode<Integer> root = new BSTNode<>(arr.get(mid),
                helper(arr, start, mid),
                helper(arr, mid+1, end));
        return root;
    }
    public static void test(){
        List<Integer> sortedArr = Arrays.asList(1, 3, 4,6,12,34,78);
        BSTNode<Integer> root = buildMinHeightBSTFromSortedArray(sortedArr);
    }
}
