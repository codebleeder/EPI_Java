package Chapter14_BinarySearchTrees;

import Chapter07_LinkedLists.ListNode;

import java.util.*;

public class BinarySearchTrees_05_RebuildBSTFromPreorder {
    public static BSTNode<Integer> rebuildBSTFromPreorder(List<Integer> sequence){
        return rebuildHelper(sequence, 0, sequence.size());
    }
    public static BSTNode<Integer> rebuildHelper(List<Integer> sequence, int start, int end){
        if (start >= end){
            return null;
        }
        int iter = start + 1;
        while (iter < end && sequence.get(iter) < sequence.get(start)){
            iter++;
        }
        return new BSTNode<Integer>(sequence.get(start),
                rebuildHelper(sequence, start+1,iter),
                rebuildHelper(sequence, iter, end));
    }
    public static void test(){
        List<Integer> seq = new ArrayList<>(Arrays.asList(43, 23, 37, 29, 31, 41, 47, 53));
        BSTNode<Integer> root = rebuildBSTFromPreorder(seq);
        System.out.println("result is valid BST: " + BinarySearchTrees_01_IsBinaryTreeBST.isValidBST(root));
    }
}
