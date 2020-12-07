package Chapter09_BinaryTrees;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTrees_03_LowestCommonAncestor {
    public static BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> a,
                                              BinaryTreeNode<Integer> b,
                                              BinaryTreeNode<Integer> root) {
        Deque<BinaryTreeNode<Integer>> aPath = tracePath(root, a, new ArrayDeque<BinaryTreeNode<Integer>>());
        Deque<BinaryTreeNode<Integer>> bPath = tracePath(root, b, new ArrayDeque<BinaryTreeNode<Integer>>());
        if (aPath.size() > bPath.size()) {
            while (aPath.size() > bPath.size()) {
                aPath.removeFirst();
            }
        } else {
            while (bPath.size() > aPath.size()) {
                bPath.removeFirst();
            }
        }
        while (aPath.peekFirst() != bPath.peekFirst()) {
            aPath.removeFirst();
            bPath.removeFirst();
        }
        return aPath.removeFirst();
    }

    public static Deque<BinaryTreeNode<Integer>> tracePath(BinaryTreeNode<Integer> root,
                                                           BinaryTreeNode<Integer> x,
                                                           Deque<BinaryTreeNode<Integer>> stack) {
        if (root == null) return null;
        stack.addFirst(root);
        if (root == x) {
            return stack;
        }

        Deque<BinaryTreeNode<Integer>> left = tracePath(root.left, x, new ArrayDeque<>(stack));
        Deque<BinaryTreeNode<Integer>> right = tracePath(root.right, x, new ArrayDeque<>(stack));
        return left != null ? left : right;
    }

    // book sol:
    private static class Status {
        public int numTargetNodes;
        public BinaryTreeNode<Integer> ancestor;

        public Status(int numTargetNodes, BinaryTreeNode<Integer> ancestor) {
            this.numTargetNodes = numTargetNodes;
            this.ancestor = ancestor;
        }
    }

    public static BinaryTreeNode<Integer> LCA2(BinaryTreeNode<Integer> root,
                                               BinaryTreeNode<Integer> a,
                                               BinaryTreeNode<Integer> b) {
        return helper(root, a, b).ancestor;
    }

    private static Status helper(BinaryTreeNode<Integer> root,
                                 BinaryTreeNode<Integer> a,
                                 BinaryTreeNode<Integer> b) {
        if (root == null) return new Status(0, null);
        Status left = helper(root.left, a, b);
        if (left.numTargetNodes == 2) return left;

        Status right = helper(root.right, a, b);
        if (right.numTargetNodes == 2) return right;

        int numTargetNodes = left.numTargetNodes + right.numTargetNodes
                + (root == a ? 1 : 0) + (root == b ? 1 : 0);
        return new Status(numTargetNodes, numTargetNodes == 2 ? root : null);

    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.buildExampleTree();
        BinaryTreeNode<Integer> m = BinaryTreeNode.getNode(root, 641);
        BinaryTreeNode<Integer> n = BinaryTreeNode.getNode(root, 257);
        //BinaryTreeNode<Integer> res = LCA(m, n, root);
        BinaryTreeNode<Integer> res = LCA2(root, m, n);
        System.out.println(res.data);
    }
}
