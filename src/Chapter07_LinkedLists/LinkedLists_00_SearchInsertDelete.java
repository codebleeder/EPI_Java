package Chapter07_LinkedLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedLists_00_SearchInsertDelete {
    public static ListNode<Integer> search(ListNode<Integer> head, int key) {
        while (head != null && head.data != key) {
            head = head.next;
        }
        return head;
    }

    public static void insertAfter(ListNode<Integer> node, ListNode<Integer> newNode) {
        newNode.next = node.next;
        node.next = newNode;
    }

    public static void deleteAfter(ListNode<Integer> node) {
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ListNode<Integer> head = ListNode.generateLinkedList(list);
        ListNode<Integer> res = search(head, 3);
        ListNode.printListNode(res);
    }
}
