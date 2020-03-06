package Chapter14_BinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTrees_12_RangeLookupInBST {
    public static class Interval
    {
        public int left, right;
        public Interval(int left, int right){
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> rangeLookupInBST(BSTNode<Integer> root, Interval interval){
        List<Integer> result = new ArrayList<>();
        helper(root, interval, result);
        return result;
    }

    public static void helper(BSTNode<Integer> root, Interval interval, List<Integer> range){
        if (root == null){
            return;
        }
        else if (root.data < interval.left){
            // nothing in the left sub-tree
            helper(root.right, interval, range);
        }
        else if (root.data > interval.right){
            // nothing in the right subtree
            helper(root.left, interval, range);
        }
        else {
            range.add(root.data);
            helper(root.right, interval, range);
            helper(root.left, interval, range);
        }
    }
    public static void test(){
        BSTNode<Integer> root = BinarySearchTrees_00_BSTLibraries.buildExampleBST();
        List<Integer> result = rangeLookupInBST(root, new Interval(16, 31));
        for(Integer n: result){
            System.out.println(n + ", ");
        }
    }
}
