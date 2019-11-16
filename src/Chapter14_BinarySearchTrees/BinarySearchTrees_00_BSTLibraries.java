package Chapter14_BinarySearchTrees;

import Chapter09_BinaryTrees.BinaryTreeNode;

import java.util.*;

public class BinarySearchTrees_00_BSTLibraries {
    public static void test(){
        TreeSet<Integer> treeSet = new TreeSet<>();
        Random r = new Random();
        List<Integer> values = new ArrayList<>(Arrays.asList(1, 23, 12, 45, 32, 67, 46));
        for (int i = 0; i < values.size(); i++){
            treeSet.add(values.get(i));
        }
        // traverse through the treeset using iterator
        // will traverse in ascending order by default:
        Iterator iter = treeSet.iterator();
        System.out.println("traverse ascending: ");
        while (iter.hasNext()){
            System.out.println((Integer) iter.next());
        }

        // traverse in descending order:
        Iterator<Integer> iterDesc = treeSet.descendingIterator();
        System.out.println("traverse descending: ");
        while (iterDesc.hasNext()){
            System.out.println(iterDesc.next());
        }

        // first and last:
        System.out.println("first = " + treeSet.first());
        System.out.println("last = " + treeSet.last());

        // floor and ceiling:
        int arbitraryVal = values.get(3);
        System.out.println(String.format("floor(%d) = %d", arbitraryVal, treeSet.floor(arbitraryVal)));
        System.out.println(String.format("ceiling(%d) = %d", arbitraryVal, treeSet.ceiling(arbitraryVal)));

        // headset
        System.out.println("headSet: ");
        TreeSet<Integer> headSet = (TreeSet<Integer>) treeSet.headSet(32);
        Iterator<Integer> headSetIter = headSet.iterator();
        while (headSetIter.hasNext()){
            System.out.println(headSetIter.next());
        }

        // tailset
        System.out.println("tailset: ");
        TreeSet<Integer> tailSet = (TreeSet<Integer>) treeSet.tailSet(32);
        Iterator<Integer> tailSetIter = tailSet.iterator();
        while (tailSetIter.hasNext()){
            System.out.println(tailSetIter.next());
        }

        // subset
        System.out.println("subset(1, 32): "); // excludes 32
        TreeSet<Integer> subSet = (TreeSet<Integer>) treeSet.subSet(1, 32);
        iter = subSet.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
    public static BSTNode<Integer> buildExampleBST(){

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
        return a;
    }
    public static BinaryTreeNode<Integer> buildExampleBinaryTree(){

        BinaryTreeNode<Integer> m = new BinaryTreeNode<>(31);
        BinaryTreeNode<Integer> l = new BinaryTreeNode<>(29, null, m);
        BinaryTreeNode<Integer> n = new BinaryTreeNode<>(41);
        BinaryTreeNode<Integer> p = new BinaryTreeNode<>(53);
        BinaryTreeNode<Integer> o = new BinaryTreeNode<>(47, null, p);
        BinaryTreeNode<Integer> k = new BinaryTreeNode<>(37, l, n);
        BinaryTreeNode<Integer> j = new BinaryTreeNode<>(23, null, k);
        BinaryTreeNode<Integer> i = new BinaryTreeNode<>(43, j, o);


        BinaryTreeNode<Integer> h = new BinaryTreeNode<>(13);
        BinaryTreeNode<Integer> g = new BinaryTreeNode<>(17, h, null);
        BinaryTreeNode<Integer> d = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> e = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> c = new BinaryTreeNode<>(3, d, e);
        BinaryTreeNode<Integer> f = new BinaryTreeNode<>(11, null, g);
        BinaryTreeNode<Integer> b = new BinaryTreeNode<>(7, c, f);

        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(19, b, i);
        return a;
    }
}
