package Chapter07_LinkedLists;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedLists_07_RemoveKthLast {
    public static void removeKthLast(ListNode<Integer> head, int k) {
        ListNode<Integer> frontRunner = head;
        ListNode<Integer> backRunner = head;
        int i = 1;
        while (frontRunner.next != null) {
            if (i >= k) {
                backRunner = backRunner.next;
            }
            frontRunner = frontRunner.next;
            ++i;
        }
        // backRunner is at k-th last
        LinkedLists_06_DeleteFromLists.deleteFromList2(backRunner);
    }

    // book solution:
    public static ListNode<Integer> removeKthLast2(ListNode<Integer> head, int k) {
        ListNode<Integer> dummyHead = new ListNode<>(0, head);
        ListNode<Integer> first = dummyHead.next;
        while (k-- > 0) {
            first = first.next;
        }
        ListNode<Integer> second = dummyHead;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        // remove 2-nd last element
        ListNode<Integer> head = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        removeKthLast(head, 2);
        ListNode.printLinkedList(head);

        // remove 3rd last element (2)
        head = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        removeKthLast(head, 3);
        ListNode.printLinkedList(head);

        System.out.println("test book sol:");
        // remove 2-nd last element
        head = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        ListNode<Integer> res1 = removeKthLast2(head, 2);
        ListNode.printLinkedList(res1);

        // remove 3rd last element (2)
        head = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        ListNode<Integer> res2 = removeKthLast2(head, 3);
        ListNode.printLinkedList(res2);
    }
}
