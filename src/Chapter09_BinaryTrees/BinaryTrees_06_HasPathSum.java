package Chapter09_BinaryTrees;

public class BinaryTrees_06_HasPathSum {
    public static BinaryTreeNode<Integer> hasPathSum(BinaryTreeNode<Integer> root, int sum) {
        BinaryTreeNode<Integer> res = helper(root, sum);
        return res;
    }

    private static BinaryTreeNode<Integer> helper(BinaryTreeNode<Integer> node, int sum) {
        if (node == null || sum < 0) return null;
        sum -= node.data;
        if (sum == 0) return node;

        BinaryTreeNode<Integer> left = helper(node.left, sum);
        if (left != null) return left;

        BinaryTreeNode<Integer> right = helper(node.right, sum);
        if (right != null) return right;

        return null;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.buildExampleTree();
        BinaryTreeNode<Integer> res = hasPathSum(root, 884);
        if (res != null) System.out.println(res.data);

        BinaryTreeNode<Integer> res2 = hasPathSum(root, 591);
        if (res != null) System.out.println(res2.data);
    }
}
