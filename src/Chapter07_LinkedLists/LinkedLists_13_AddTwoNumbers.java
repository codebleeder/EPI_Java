package Chapter07_LinkedLists;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedLists_13_AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        ListNode<Integer> dummyHead = new ListNode<>(-1);
        ListNode<Integer> runner = dummyHead;
        ListNode<Integer> aRunner = a;
        ListNode<Integer> bRunner = b;
        int carry = 0;
        while (aRunner != null && bRunner != null) {
            int sum = aRunner.data + bRunner.data + carry;
            carry = sum / 10;
            runner.next = new ListNode<>(sum % 10);
            runner = runner.next;
            aRunner = aRunner.next;
            bRunner = bRunner.next;
        }
        ListNode<Integer> remainingRunner = aRunner != null ? aRunner : bRunner;
        if (remainingRunner != null) {
            while (remainingRunner != null) {
                int sum = remainingRunner.data + carry;
                carry = sum / 10;
                runner.next = new ListNode<>(sum % 10);
                runner = runner.next;
                remainingRunner = remainingRunner.next;
            }
        }
        if (carry > 0) runner.next = new ListNode<>(carry);
        return dummyHead.next;
    }

    // book sol - more elegant:
    public static ListNode<Integer> addTwoNumbers2(ListNode<Integer> a, ListNode<Integer> b) {
        ListNode<Integer> dummyHead = new ListNode<>(-1), iter = dummyHead;
        int carry = 0;
        while (a != null || b != null || carry != 0) {
            int sum = carry + (a != null ? a.data : 0) + (b != null ? b.data : 0);
            a = a != null ? a.next : null;
            b = b != null ? b.next : null;
            iter.next = new ListNode<>(sum % 10);
            carry = sum / 10;
            iter = iter.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode<Integer> a = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(3, 1, 4)));
        ListNode<Integer> b = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(7, 0, 9)));
        ListNode<Integer> res = addTwoNumbers(a, b);
        ListNode.printLinkedList(res);
        ListNode<Integer> res2 = addTwoNumbers2(a, b);
        ListNode.printLinkedList(res2);

    }
}
