package Chapter07_LinkedLists;

import java.util.Arrays;
import java.util.Random;

public class LinkedLists_01_MergeTwoSortedLists {
    public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> a, ListNode<Integer> b){
        ListNode<Integer> dummyNode = new ListNode<>(0);
        ListNode<Integer> iter = dummyNode;
        while (a != null && b != null){
            if (a.data > b.data){
                iter.next = b;
                b = b.next;
            }
            else {
                iter.next = a;
                a = a.next;
            }
            iter = iter.next;
        }
        iter.next = a == null ? (b == null ? null : b ) : a;
        return dummyNode.next;
    }
    public static void test(){
        Random r = new Random();
        ListNode<Integer> a = ListNode.generateLinkedList(Arrays.asList(1, 3, 5, 7, 9));
        ListNode<Integer> b = ListNode.generateLinkedList(Arrays.asList(2, 4, 8, 16));
        ListNode.printLinkedList(mergeTwoSortedLists(a, b));

    }
}
