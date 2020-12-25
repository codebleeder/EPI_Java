package Chapter09_BinaryTrees;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class BinaryTrees_15_ExteriorBinaryTree {
    public static List<BinaryTreeNode<Integer>> exteriorBinaryTree(BinaryTreeNode<Integer> root) {
        List<BinaryTreeNode<Integer>> res = new LinkedList<>();
        if (root != null) {
            res.add(root);
            res.addAll(leftBoundaryAndLeaves(root.left, true));
            res.addAll(rightBoundaryAndLeaves(root.right, true));
        }
        return res;
    }

    private static List<BinaryTreeNode<Integer>> leftBoundaryAndLeaves(BinaryTreeNode<Integer> root, boolean isBoundary) {
        List<BinaryTreeNode<Integer>> res = new LinkedList<>();
        if (root != null) {
            if (isBoundary || isLeaf(root)) {
                res.add(root);
            }
            res.addAll(leftBoundaryAndLeaves(root.left, isBoundary));
            res.addAll(leftBoundaryAndLeaves(root.right, isBoundary && root.left == null));
        }
        return res;
    }

    private static List<BinaryTreeNode<Integer>> rightBoundaryAndLeaves(BinaryTreeNode<Integer> root, boolean isBoundary) {
        List<BinaryTreeNode<Integer>> res = new LinkedList<>();
        if (root != null) {
            res.addAll(rightBoundaryAndLeaves(root.left, isBoundary && root.right == null));
            res.addAll(rightBoundaryAndLeaves(root.right, isBoundary));
            if (isBoundary || isLeaf(root)) {
                res.add(root);
            }
        }
        return res;
    }

    private static boolean isLeaf(BinaryTreeNode<Integer> node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.buildExampleTree();
        List<BinaryTreeNode<Integer>> res = exteriorBinaryTree(root);
        for (BinaryTreeNode<Integer> node : res) {
            System.out.println(node.data);
        }
    }
}
