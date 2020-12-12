package Chapter09_BinaryTrees;

public class BinaryTrees_04_LCA_WithParentPointer {
    public static BinaryTreeNodeWithParent LCA(BinaryTreeNodeWithParent<Integer> a,
                                               BinaryTreeNodeWithParent<Integer> b) {
        int dist_a = getDepth(a);
        int dist_b = getDepth(b);

        BinaryTreeNodeWithParent<Integer> deeper = dist_a > dist_b ? a : b;
        BinaryTreeNodeWithParent<Integer> shallow = dist_a < dist_b ? a : b;

        int diff = Math.abs(dist_a - dist_b);
        while (diff > 0) {
            deeper = deeper.parent;
            --diff;
        }

        while (deeper != shallow) {
            deeper = deeper.parent;
            shallow = shallow.parent;
        }

        return deeper;
    }

    public static int getDepth(BinaryTreeNodeWithParent<Integer> a) {
        int depth = 0;
        while (a.parent != null) {
            depth++;
            a = a.parent;
        }
        return depth;
    }

    public static void main(String[] args) {
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

        BinaryTreeNodeWithParent<Integer> res = LCA(m, n);
        System.out.println("LCA(m,n): " + res.data);
        System.out.println("LCA(m,p) = " + LCA(m, p).data);
        System.out.println("LCA(h,m) = " + LCA(h, m).data);
    }
}
