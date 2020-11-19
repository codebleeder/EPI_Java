package Chapter07_LinkedLists;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedLists_06_DeleteFromLists {
    public static void deleteFromList(ListNode<Integer> head, int i) {
        ListNode<Integer> dummyHead = new ListNode<>(0);
        dummyHead.next = head;

        while (dummyHead.next.data != i) {
            dummyHead = dummyHead.next;
        }
        dummyHead.next = dummyHead.next.next;
    }

    // book problem: a node is given instead of data
    // copy data from next node and point to node after next
    public static void deleteFromList2(ListNode<Integer> node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        // case 1: delete a middle node
        deleteFromList(head, 3);
        ListNode.printLinkedList(head);

        // case 2: delete last node
        head = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        deleteFromList(head, 4);
        ListNode.printLinkedList(head);

        // test book implementation:
        // case 1: delete a middle node
        System.out.println("test book implementation");
        head = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        deleteFromList2(ListNode.traverse(head, 3));
        ListNode.printLinkedList(head);

    }
}
