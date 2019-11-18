package Chapter14_BinarySearchTrees;

import Chapter07_LinkedLists.ListNode;

import java.util.*;

public class BinarySearchTrees_05_RebuildBSTFromPreorder {
    public static BSTNode<Integer> rebuildBSTFromPreorder(List<Integer> sequence){
        return rebuildHelper(sequence, 0, sequence.size());
    }
    private static BSTNode<Integer> rebuildHelper(List<Integer> sequence, int start, int end){
        if (start >= end){
            return null;
        }
        int iter = start + 1;
        while (iter < end && sequence.get(iter) < sequence.get(start)){
            iter++;
        }
        return new BSTNode<>(sequence.get(start),
                rebuildHelper(sequence, start+1,iter),
                rebuildHelper(sequence, iter, end));
    }
    // solution 2:
    private static int rootIndex;
    public static BSTNode<Integer> rebuildBSTFromPreorder2(List<Integer> sequence){
        rootIndex = 0;
        return rebuildHelper2(sequence, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static BSTNode<Integer> rebuildHelper2(List<Integer> sequence, int minValue, int maxValue) {
        if (rootIndex == sequence.size()){
            return null;
        }
        BSTNode<Integer> root = new BSTNode<>(sequence.get(rootIndex));
        if (root.data < minValue || root.data > maxValue) {
            return null;
        }

        rootIndex++;
        root.left = rebuildHelper2(sequence, minValue, root.data);
        root.right = rebuildHelper2(sequence, root.data, maxValue);
        return root;
    }

    public static void test(){
        List<Integer> seq = new ArrayList<>(Arrays.asList(43, 23, 37, 29, 31, 41, 47, 53));
        BSTNode<Integer> root = rebuildBSTFromPreorder(seq);
        System.out.println("result is valid BST: " + BinarySearchTrees_01_IsBinaryTreeBST.isValidBST(root));
    }
}
