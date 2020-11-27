package Chapter08_Stacks_and_Queues;

import Chapter09_BinaryTrees.BinaryTreeNode;
import Datastructures.TreeNode;

import java.util.*;

public class Stacks_and_Queues_07_BinaryTreeDepthOrder {
    public static List<List<Integer>> binaryTreeDepthOrder(BinaryTreeNode root) {
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!q.isEmpty()) {
            Queue<BinaryTreeNode<Integer>> nextDepthNodes = new LinkedList<>();
            List<Integer> thisLevel = new ArrayList<>();
            while (!q.isEmpty()) {
                BinaryTreeNode<Integer> curr = q.poll();
                if (curr != null) {
                    thisLevel.add(curr.data);
                    nextDepthNodes.add(curr.left);
                    nextDepthNodes.add(curr.right);
                }
            }
            if (!thisLevel.isEmpty()) {
                result.add(thisLevel);
            }
            q = nextDepthNodes;
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> a = BinaryTreeNode.buildExampleTree();
        List<List<Integer>> res = binaryTreeDepthOrder(a);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
