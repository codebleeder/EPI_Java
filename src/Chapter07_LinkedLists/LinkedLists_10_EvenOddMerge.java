package Chapter07_LinkedLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedLists_10_EvenOddMerge {
    public static ListNode<Integer> evenOddMerge(ListNode<Integer> head) {
        int i = 0;
        ListNode<Integer> runner = head;
        ListNode<Integer> evenDummyHead = new ListNode<>(-1);
        ListNode<Integer> evenRunner = evenDummyHead;
        ListNode<Integer> oddDummyHead = new ListNode<>(-1);
        ListNode<Integer> oddRunner = oddDummyHead;

        while (runner != null) {
            if (i % 2 == 0) {
                evenRunner.next = new ListNode<>(runner.data);
                evenRunner = evenRunner.next;
            } else {
                oddRunner.next = new ListNode<>(runner.data);
                oddRunner = oddRunner.next;
            }
            runner = runner.next;
            ++i;
        }
        evenRunner.next = oddDummyHead.next;
        return evenDummyHead.next;
    }

    // without extra space:
    public static ListNode<Integer> evenOddMerge2(ListNode<Integer> head) {
        int i = 0;
        ListNode<Integer> runner = head;
        ListNode<Integer> evenDummyHead = new ListNode<>(-1);
        ListNode<Integer> evenRunner = evenDummyHead;
        ListNode<Integer> oddDummyHead = new ListNode<>(-1);
        ListNode<Integer> oddRunner = oddDummyHead;

        while (runner != null) {
            if (i % 2 == 0) {
                evenRunner.next = runner;
                evenRunner = evenRunner.next;
            } else {
                oddRunner.next = runner;
                oddRunner = oddRunner.next;
            }
            runner = runner.next;
            ++i;
        }
        oddRunner.next = null;
        evenRunner.next = oddDummyHead.next;
        return evenDummyHead.next;
    }

    // book method:
    public static ListNode<Integer> evenOddMerge3(ListNode<Integer> head) {
        if (head == null) return head;

        int i = 0;
        ListNode<Integer> evenDummyHead = new ListNode<>(-1);
        ListNode<Integer> oddDummyHead = new ListNode<>(-1);

        List<ListNode<Integer>> tails = Arrays.asList(evenDummyHead, oddDummyHead);
        for (ListNode<Integer> iter = head; iter != null; iter = iter.next) {
            tails.get(i).next = iter;
            tails.set(i, tails.get(i).next);
            i ^= 1;
        }
        tails.get(1).next = null;
        tails.get(0).next = oddDummyHead.next;
        return evenDummyHead.next;
    }

    // book method simplified:
    public static ListNode<Integer> evenOddMerge4(ListNode<Integer> head) {
        if (head == null) return head;

        int i = 0;
        ListNode<Integer> evenDummyHead = new ListNode<>(-1);
        ListNode<Integer> oddDummyHead = new ListNode<>(-1);
        ListNode<Integer> evenRunner = evenDummyHead;
        ListNode<Integer> oddRunner = oddDummyHead;

        for (ListNode<Integer> iter = head; iter != null; iter = iter.next) {
            if (i == 0) {
                evenRunner.next = iter;
                evenRunner = evenRunner.next;
            } else {
                oddRunner.next = iter;
                oddRunner = oddRunner.next;
            }
            i ^= 1;
        }

        oddRunner.next = null;
        evenRunner.next = oddDummyHead.next;
        return evenDummyHead.next;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4)));
        ListNode<Integer> res = evenOddMerge2(head);
        ListNode.printLinkedList(res);
    }
}
