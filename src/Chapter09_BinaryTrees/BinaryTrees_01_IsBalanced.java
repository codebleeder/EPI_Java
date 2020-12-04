package Chapter09_BinaryTrees;

public class BinaryTrees_01_IsBalanced {
    public static boolean isBalanced(BinaryTreeNode<Integer> root) {
        //System.out.println("left height: " + helper(root.left));
        //System.out.println("right height: " + helper(root.right));
        return helper(root).isBalanced;
    }

    public static BalanceStatusWithHeight helper(BinaryTreeNode<Integer> node) {
        if (node == null) return new BalanceStatusWithHeight(0, true);
        //   if(node.left == null && node.right == null) return new BalanceStatusWithHeight(1, true);
        BalanceStatusWithHeight leftRes = helper(node.left);
        BalanceStatusWithHeight rightRes = helper(node.right);
        int height = (Math.max(leftRes.height, rightRes.height)) + 1;
        boolean isBalanced = leftRes.isBalanced
                && rightRes.isBalanced
                && Math.abs(leftRes.height - rightRes.height) <= 1;
        BalanceStatusWithHeight res = new BalanceStatusWithHeight(height, isBalanced);
        return res;
    }

    public static class BalanceStatusWithHeight {
        public int height;
        public boolean isBalanced;

        public BalanceStatusWithHeight(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    // book sol:
    private static BalanceStatusWithHeight helper2(BinaryTreeNode<Integer> tree) {
        if (tree == null) return new BalanceStatusWithHeight(-1, true);
        BalanceStatusWithHeight left = helper2(tree.left);
        if (!left.isBalanced) return left;

        BalanceStatusWithHeight right = helper2(tree.right);
        if (!right.isBalanced) return right;

        boolean isBalanced = Math.abs(left.height - right.height) <= 1;
        int height = Math.max(left.height, right.height) + 1;
        return new BalanceStatusWithHeight(height, isBalanced);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.buildHeightBalancedExampleTree();
        System.out.println(isBalanced(root));

        BinaryTreeNode<Integer> root2 = BinaryTreeNode.buildExampleTree();
        System.out.println(isBalanced(root2));
    }
}
