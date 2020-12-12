package Chapter09_BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTrees_05_SumRootToLeaf {
    public static int sumRootToLeaf(BinaryTreeNode<Integer> root) {
        Integer sum = 0;
        return helper(root, sum);
    }

    public static int helper(BinaryTreeNode<Integer> node, Integer sum) {
        if (node == null) return 0;
        sum = (sum * 2) + node.data;
        if (node.left == null && node.right == null) {
            return sum;
        }
        return helper(node.left, sum) + helper(node.right, sum);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> b = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> c = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> d = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> e = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> f = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> g = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> h = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> i = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> j = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> k = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> l = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> m = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> o = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> p = new BinaryTreeNode<>(0);

        a.left = b;
        a.right = i;
        b.left = c;
        b.right = f;
        c.left = d;
        c.right = e;
        f.right = g;
        g.left = h;
        i.left = j;
        i.right = o;
        j.right = k;
        k.left = l;
        k.right = n;
        l.right = m;
        i.right = o;
        o.right = p;

        int sum = sumRootToLeaf(a);
        System.out.println("sum = " + sum);
    }
}
