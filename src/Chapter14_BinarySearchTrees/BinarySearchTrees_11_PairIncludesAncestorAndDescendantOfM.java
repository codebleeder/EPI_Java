package Chapter14_BinarySearchTrees;

public class BinarySearchTrees_11_PairIncludesAncestorAndDescendantOfM {
    public static boolean pairIncludesAncestorAndDescendantOfM(
            BSTNode<Integer> possibleAncOrDesc0,
            BSTNode<Integer> possibleAncOrDesc1,
            BSTNode<Integer> middle){
        BSTNode<Integer> search0 = possibleAncOrDesc0, search1 = possibleAncOrDesc1;
        while (search0 != middle && search1 != middle &&
        search0 != possibleAncOrDesc1 && search1 != possibleAncOrDesc0 &&
                (search0 != null || search1 != null)){
            if (search0 != null) {
                search0 = search0.data > middle.data ? search0.left : search0.right;
            }
            if (search1 != null) {
                search1 = search1.data > middle.data ? search1.left : search1.right;
            }
        }
        if (search0 == possibleAncOrDesc1 || search1 == possibleAncOrDesc0 ||
                (search0 != middle && search1 != middle)){
            return false;
        }

        return search0 == middle ? searchTarget(middle, possibleAncOrDesc1) :
                searchTarget(middle, possibleAncOrDesc0);
    }

    private static boolean searchTarget(BSTNode<Integer> from, BSTNode<Integer> target) {
        while (from != null && from != target){
            from = from.data > target.data ? from.left : from.right;
        }
        return from == target;
    }

    public static void test(){
        // build the tree
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

        // case 1: ideal case - one ancestor and one descendant
        boolean case1Res = pairIncludesAncestorAndDescendantOfM(a, k, j);
        System.out.println("expected: true " + "result: " + case1Res);

        // case 2: one proper ancestor and other not a descendant
        boolean case2Res = pairIncludesAncestorAndDescendantOfM(a, o, j);
        System.out.println("expected: false " + "result: " + case2Res);

        // case 3: not a proper ancestor and other a proper descendant
        boolean case3Res = pairIncludesAncestorAndDescendantOfM(o, n, j);
        System.out.println("expected: false " + "result: " + case3Res);
    }
}
