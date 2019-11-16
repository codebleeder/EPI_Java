package Chapter14_BinarySearchTrees;

public class BinarySearchTrees_02_FindFirstGreaterThanK {
    public static BSTNode<Integer> findFirstGreaterThanK(BSTNode<Integer> tree, int k){
        BSTNode<Integer> res = null;
        while (tree != null){
            if (tree.data > k){
                res = tree;
                tree = tree.left;
            }
            else {
                tree = tree.right;
            }
        }
        return res;
    }
    public static void test(){
        BSTNode<Integer> tree = BinarySearchTrees_00_BSTLibraries.buildExampleBST();
        BSTNode<Integer> res = findFirstGreaterThanK(tree, 23);
        System.out.println(res.data);
    }
}
