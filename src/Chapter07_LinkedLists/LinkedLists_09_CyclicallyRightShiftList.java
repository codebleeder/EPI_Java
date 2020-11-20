package Chapter07_LinkedLists;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedLists_09_CyclicallyRightShiftList {
    public static ListNode<Integer> cyclicallyRightShiftList(ListNode<Integer> head, int n) {
        int length = ListNode.getLength(head);
        n = n % length;
        if (n == 0) return head;
        int k = length - n;
        ListNode<Integer> dummyHead = new ListNode<>(0, head);
        ListNode<Integer> runner = dummyHead;
        while (k > 0) {
            runner = runner.next;
            --k;
        }
        ListNode<Integer> newTail = runner;
        ListNode<Integer> newHead = newTail.next;
        // find the old tail
        while (runner.next != null) {
            runner = runner.next;
        }
        newTail.next = null;
        runner.next = dummyHead.next;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        ListNode<Integer> res = cyclicallyRightShiftList(head, 1);
        ListNode.printLinkedList(res);

        head = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        ListNode<Integer> res2 = cyclicallyRightShiftList(head, 2);
        ListNode.printLinkedList(res2);

        head = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        ListNode<Integer> res3 = cyclicallyRightShiftList(head, 4);
        ListNode.printLinkedList(res3);
    }
}
