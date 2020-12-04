package Chapter09_BinaryTrees;

public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left, right;

    public BinaryTreeNode(T d){
        data = d;
    }
    public BinaryTreeNode(T d, BinaryTreeNode<T> left, BinaryTreeNode<T> right){
        data = d;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public static BinaryTreeNode<Integer> buildExampleTree() {
        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(314);
        BinaryTreeNode<Integer> b = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> c = new BinaryTreeNode<>(271);
        BinaryTreeNode<Integer> d = new BinaryTreeNode<>(28);
        BinaryTreeNode<Integer> e = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> f = new BinaryTreeNode<>(561);
        BinaryTreeNode<Integer> g = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> h = new BinaryTreeNode<>(17);
        BinaryTreeNode<Integer> i = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> j = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> k = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> l = new BinaryTreeNode<>(401);
        BinaryTreeNode<Integer> m = new BinaryTreeNode<>(641);
        BinaryTreeNode<Integer> n = new BinaryTreeNode<>(257);
        BinaryTreeNode<Integer> o = new BinaryTreeNode<>(271);
        BinaryTreeNode<Integer> p = new BinaryTreeNode<>(28);

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

        return a;
    }

    public static BinaryTreeNode<Integer> buildHeightBalancedExampleTree() {
        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(314);
        BinaryTreeNode<Integer> b = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> c = new BinaryTreeNode<>(271);
        BinaryTreeNode<Integer> d = new BinaryTreeNode<>(28);
        BinaryTreeNode<Integer> e = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> f = new BinaryTreeNode<>(561);
        BinaryTreeNode<Integer> g = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> h = new BinaryTreeNode<>(17);
        BinaryTreeNode<Integer> i = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> j = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> k = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> l = new BinaryTreeNode<>(401);
        BinaryTreeNode<Integer> m = new BinaryTreeNode<>(641);
        BinaryTreeNode<Integer> n = new BinaryTreeNode<>(257);
        BinaryTreeNode<Integer> o = new BinaryTreeNode<>(271);
        BinaryTreeNode<Integer> p = new BinaryTreeNode<>(28);

        a.left = b;
        a.right = k;
        b.left = c;
        b.right = h;
        c.left = d;
        c.right = g;
        d.left = e;
        d.right = f;
        h.left = i;
        h.right = j;
        k.left = l;
        k.right = o;
        l.left = m;
        l.right = n;
        return a;
    }
}
