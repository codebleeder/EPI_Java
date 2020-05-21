package Chapter15_Recursion;

import Chapter09_BinaryTrees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class Recursion_08_GenerateAllBinaryTrees {
    public static List<BinaryTreeNode<Integer>> generateAllBinaryTrees(int n){
        List<BinaryTreeNode<Integer>> result = new ArrayList<>();
        if (n == 0){
            result.add(null);
            return result;
        }
        for(int numLeftNodes = 0; numLeftNodes < n; numLeftNodes++){
            int numRightNodes = n - 1 - numLeftNodes;
            List<BinaryTreeNode<Integer>> leftSubtrees = generateAllBinaryTrees(numLeftNodes);
            List<BinaryTreeNode<Integer>> rightSubtrees = generateAllBinaryTrees(numRightNodes);
            for(BinaryTreeNode<Integer> left: leftSubtrees){
                for(BinaryTreeNode<Integer> right: rightSubtrees){
                    result.add(new BinaryTreeNode<Integer>(0, left, right));
                }
            }
        }
        return result;
    }
    public static void test(){
        List<BinaryTreeNode<Integer>> result = generateAllBinaryTrees(3);

    }

}
