package Chapter08_Stacks_and_Queues;

import Chapter07_LinkedLists.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Stacks_and_Queues_00_PrintLinkedListInReverse {
    public static void printLinkedListInReverse(ListNode<Integer> head) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (head != null) {
            stack.push(head.data);
            head = head.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        ListNode<Integer> head = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        printLinkedListInReverse(head);
    }
}
