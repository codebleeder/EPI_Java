package Chapter14_BinarySearchTrees;

import Util.Util;

import java.util.*;

public class BinarySearchTrees_03_FindKLargestElements {
    public static List<Integer> findKLargestInBST(BSTNode<Integer> root, int k){
        Deque<Integer> stack = new ArrayDeque<>();
        inorderTraversal(stack, root);
        List<Integer> res = new ArrayList<>();
        while (k > 0) {
            res.add(stack.pop());
            k--;
        }
        return res;
    }
    public static void inorderTraversal(Deque<Integer> stack, BSTNode<Integer> root){
        if (root == null) {
            return;
        }
        if (root.left != null){
            //stack.add(root.left.data);
            inorderTraversal(stack, root.left);
        }
        stack.push(root.data);

        if (root.right != null){
            inorderTraversal(stack, root.right);
        }
    }
    // book solution:
    public static List<Integer> findKLargestInBST2(BSTNode<Integer> root, int k){
        List<Integer> results = new ArrayList<>();
        reverseInorderTraversal(results, root, k);
        return results;
    }
    public static void reverseInorderTraversal(List<Integer> results, BSTNode<Integer> root, int k){
        if (root == null || results.size() >= k) {
            return;
        }
        reverseInorderTraversal(results, root.right, k);
        if (results.size() < k){
            results.add(root.data);
            reverseInorderTraversal(results, root.left, k);
        }
    }
    public static void test(){
        BSTNode<Integer> root = BinarySearchTrees_00_BSTLibraries.buildExampleBST();
        List<Integer> res = findKLargestInBST2(root, 5);
        Util.printCollection(res);
    }
}
