package Chapter09_BinaryTrees;

public class BinaryTrees_02_IsSymmetric {
    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
        return helper(root.left, root.right);
    }

    public static boolean helper(BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2) {
        if (node1 == null && node2 == null) return true;
        if ((node1 != null && node2 == null) || (node1 == null && node2 != null)) return false;
        // basic: node1 and node2 are leaves
        if (node1.isLeaf() && node2.isLeaf()) return true;
        // node1.left is symmetric to node2.right
        boolean res1 = helper(node1.left, node2.right);
        boolean res2 = helper(node1.right, node2.left);
        return (node1.data.equals(node2.data)) && res1 && res2;
    }

    public static void main(String[] args) {

        BinaryTreeNode<Integer> root1 = buildExample1();
        System.out.println("isSymmetric: " + isSymmetric(root1));

        BinaryTreeNode<Integer> root2 = buildExample2();
        System.out.println("isSymmetric: " + isSymmetric(root2));

        BinaryTreeNode<Integer> root3 = buildExample3();
        System.out.println("isSymmetric: " + isSymmetric(root3));
    }

    private static BinaryTreeNode<Integer> buildExample1() {
        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(314);
        BinaryTreeNode<Integer> b = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> c = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> d = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> e = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> f = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> g = new BinaryTreeNode<>(3);

        a.left = b;
        a.right = e;
        b.right = c;
        c.right = d;
        e.left = f;
        f.left = g;

        return a;
    }

    private static BinaryTreeNode<Integer> buildExample2() {
        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(314);
        BinaryTreeNode<Integer> b = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> c = new BinaryTreeNode<>(561);
        BinaryTreeNode<Integer> d = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> e = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> f = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> g = new BinaryTreeNode<>(1);

        a.left = b;
        a.right = e;
        b.right = c;
        c.right = d;
        e.left = f;
        f.left = g;

        return a;
    }

    private static BinaryTreeNode<Integer> buildExample3() {
        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(314);
        BinaryTreeNode<Integer> b = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> c = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> d = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> e = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> f = new BinaryTreeNode<>(2);


        a.left = b;
        a.right = e;
        b.right = c;
        c.right = d;
        e.left = f;


        return a;
    }
}
