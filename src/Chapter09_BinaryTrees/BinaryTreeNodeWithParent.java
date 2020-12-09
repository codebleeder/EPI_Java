package Chapter09_BinaryTrees;

public class BinaryTreeNodeWithParent<T> extends BinaryTreeNode {
    public BinaryTreeNodeWithParent<T> parent;

    public BinaryTreeNodeWithParent(T d) {
        super(d);
    }

    public BinaryTreeNodeWithParent(T d, BinaryTreeNode left, BinaryTreeNode right) {
        super(d, left, right);
    }

    public BinaryTreeNodeWithParent(T data,
                                    BinaryTreeNodeWithParent left,
                                    BinaryTreeNodeWithParent right,
                                    BinaryTreeNodeWithParent parent) {

        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public static BinaryTreeNodeWithParent buildExampleTree() {
        BinaryTreeNodeWithParent<Integer> a = new BinaryTreeNodeWithParent<>(314);
        BinaryTreeNodeWithParent<Integer> b = new BinaryTreeNodeWithParent<>(6);
        BinaryTreeNodeWithParent<Integer> c = new BinaryTreeNodeWithParent<>(271);
        BinaryTreeNodeWithParent<Integer> d = new BinaryTreeNodeWithParent<>(28);
        BinaryTreeNodeWithParent<Integer> e = new BinaryTreeNodeWithParent<>(0);
        BinaryTreeNodeWithParent<Integer> f = new BinaryTreeNodeWithParent<>(561);
        BinaryTreeNodeWithParent<Integer> g = new BinaryTreeNodeWithParent<>(3);
        BinaryTreeNodeWithParent<Integer> h = new BinaryTreeNodeWithParent<>(17);
        BinaryTreeNodeWithParent<Integer> i = new BinaryTreeNodeWithParent<>(6);
        BinaryTreeNodeWithParent<Integer> j = new BinaryTreeNodeWithParent<>(2);
        BinaryTreeNodeWithParent<Integer> k = new BinaryTreeNodeWithParent<>(1);
        BinaryTreeNodeWithParent<Integer> l = new BinaryTreeNodeWithParent<>(401);
        BinaryTreeNodeWithParent<Integer> m = new BinaryTreeNodeWithParent<>(641);
        BinaryTreeNodeWithParent<Integer> n = new BinaryTreeNodeWithParent<>(257);
        BinaryTreeNodeWithParent<Integer> o = new BinaryTreeNodeWithParent<>(271);
        BinaryTreeNodeWithParent<Integer> p = new BinaryTreeNodeWithParent<>(28);

        a.left = b;
        a.right = i;
        b.left = c;
        b.right = f;
        b.parent = a;
        c.left = d;
        c.right = e;
        c.parent = b;
        f.right = g;
        f.parent = b;
        g.left = h;
        g.parent = f;
        i.left = j;
        i.right = o;
        i.parent = a;
        j.right = k;
        j.parent = i;
        k.left = l;
        k.right = n;
        k.parent = j;
        l.right = m;
        l.parent = k;
        o.right = p;
        o.parent = i;
        p.parent = o;
        m.parent = l;
        n.parent = k;
        h.parent = g;
        d.parent = c;
        e.parent = c;
        return a;
    }
}