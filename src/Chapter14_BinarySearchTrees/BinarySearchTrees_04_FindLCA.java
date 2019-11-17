package Chapter14_BinarySearchTrees;

public class BinarySearchTrees_04_FindLCA {
    public static BSTNode<Integer> findLCA(BSTNode<Integer> root,
                                           BSTNode<Integer> s,
                                           BSTNode<Integer> b){
        while (root != null){
            if (root.data == s.data || root.data == b.data){
                return root;
            }
            else if (root.data > s.data && root.data > b.data){
                root = root.left;
            }
            else if (root.data < s.data && root.data < b.data){
                root = root.right;
            }
            else {
                return root;
            }
        }
        return null;
    }
    public static void test(){
        BSTNode<Integer> p = new BSTNode<>(53);
        BSTNode<Integer> o = new BSTNode<>(47, null, p);
        BSTNode<Integer> m = new BSTNode<>(31);
        BSTNode<Integer> l = new BSTNode<>(29, null, m);
        BSTNode<Integer> n = new BSTNode<>(41);
        BSTNode<Integer> k = new BSTNode<>(37, l, n);
        BSTNode<Integer> j = new BSTNode<>(23, null, k);
        BSTNode<Integer> i = new BSTNode<>(43, j, o);

        BSTNode<Integer> h = new BSTNode<>(13);
        BSTNode<Integer> g = new BSTNode<>(17, h, null);
        BSTNode<Integer> d = new BSTNode<>(2);
        BSTNode<Integer> e = new BSTNode<>(5);
        BSTNode<Integer> c = new BSTNode<>(3, d, e);
        BSTNode<Integer> f = new BSTNode<>(11, null, g);
        BSTNode<Integer> b = new BSTNode<>(7, c, f);

        BSTNode<Integer> a = new BSTNode<>(19, b, i);

        BSTNode<Integer> res = findLCA(a, c, g);
        System.out.println(String.format("LCA of c and g = %d", res.data));
    }
}
