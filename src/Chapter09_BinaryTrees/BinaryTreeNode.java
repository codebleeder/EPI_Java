package Chapter09_BinaryTrees;

public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left, right, parent, levelNext;
    public int size;

    public BinaryTreeNode() {
    }
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

    public static BinaryTreeNode<Integer> getNode(BinaryTreeNode<Integer> root, int x) {
        if (root == null) return null;
        if (root.data == x) return root;
        BinaryTreeNode<Integer> left = getNode(root.left, x);
        BinaryTreeNode<Integer> right = getNode(root.right, x);
        return left != null ? left : right;
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
        a.size = 16;
        b.left = c;
        b.right = f;
        b.size = 7;
        c.left = d;
        c.right = e;
        c.size = 3;
        f.right = g;
        f.size = 3;
        g.left = h;
        g.size = 2;
        i.left = j;
        i.right = o;
        i.size = 8;
        j.right = k;
        j.size = 5;
        k.left = l;
        k.right = n;
        k.size = 4;
        l.right = m;
        l.size = 2;
        o.right = p;
        o.size = 2;

        d.size = 1;
        e.size = 1;
        h.size = 1;
        m.size = 1;
        n.size = 1;
        p.size = 1;

        b.parent = a;
        c.parent = b;
        f.parent = b;
        g.parent = f;
        i.parent = a;
        j.parent = i;
        k.parent = j;
        l.parent = k;
        o.parent = i;
        p.parent = o;
        m.parent = l;
        n.parent = k;
        h.parent = g;
        d.parent = c;
        e.parent = c;

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

    public static BinaryTreeNode<Integer> buildPerfectTree() {
        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> b = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> c = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> d = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> e = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> f = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> g = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> h = new BinaryTreeNode<>(8);
        BinaryTreeNode<Integer> i = new BinaryTreeNode<>(9);
        BinaryTreeNode<Integer> j = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> k = new BinaryTreeNode<>(11);
        BinaryTreeNode<Integer> l = new BinaryTreeNode<>(12);
        BinaryTreeNode<Integer> m = new BinaryTreeNode<>(13);
        BinaryTreeNode<Integer> n = new BinaryTreeNode<>(14);
        BinaryTreeNode<Integer> o = new BinaryTreeNode<>(15);

        a.left = b;
        a.right = i;
        b.left = c;
        b.right = f;
        c.left = d;
        c.right = e;
        f.left = g;
        f.right = h;
        i.left = j;
        i.right = m;
        j.left = k;
        j.right = l;
        m.left = n;
        m.right = o;

        return a;
    }
}
