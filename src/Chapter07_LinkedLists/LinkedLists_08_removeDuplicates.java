package Chapter07_LinkedLists;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedLists_08_removeDuplicates {
    public static ListNode<Integer> removeDuplicates(ListNode<Integer> head) {

        ListNode<Integer> runner = head;
        while (runner != null) {
            ListNode<Integer> nextDistinct = runner.next;
            while (nextDistinct != null && nextDistinct.data == runner.data) {
                nextDistinct = nextDistinct.next;
            }
            runner.next = nextDistinct;
            runner = nextDistinct;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(2, 2, 3, 5, 7, 11, 11)));
        ListNode<Integer> res = removeDuplicates(head);
        ListNode.printLinkedList(res);
    }
}
