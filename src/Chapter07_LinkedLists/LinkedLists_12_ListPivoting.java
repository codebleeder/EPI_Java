package Chapter07_LinkedLists;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedLists_12_ListPivoting {
    public static ListNode<Integer> listPivoting(ListNode<Integer> head, int k) {
        ListNode<Integer> lessDummyHead = new ListNode<>(-1), lessIter = lessDummyHead;
        ListNode<Integer> equalDummyHead = new ListNode<>(-1), equalIter = equalDummyHead;
        ListNode<Integer> highDummyHead = new ListNode<>(-1), highIter = highDummyHead;

        ListNode<Integer> iter = head;
        while (iter != null) {
            if (iter.data > k) {
                highIter.next = iter;
                highIter = highIter.next;
            } else if (iter.data == k) {
                equalIter.next = iter;
                equalIter = equalIter.next;
            } else {
                lessIter.next = iter;
                lessIter = lessIter.next;
            }
            iter = iter.next;
        }
        lessIter.next = equalDummyHead.next;
        equalIter.next = highDummyHead.next;
        return lessDummyHead.next;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(3, 2, 2, 11, 7, 5, 7, 11)));
        ListNode<Integer> res = listPivoting(head, 7);
        ListNode.printLinkedList(res);
    }
}
