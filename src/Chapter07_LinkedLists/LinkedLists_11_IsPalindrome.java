package Chapter07_LinkedLists;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedLists_11_IsPalindrome {
    public static boolean isPalindrome(ListNode<Integer> head) {
        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the second half
        slow.next = LinkedLists_02_ReverseSublist.reverse(slow.next);

        ListNode<Integer> runner = head;
        slow = slow.next;
        while (slow != null) {
            if (runner.data != slow.data) return false;
            slow = slow.next;
            runner = runner.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode<Integer> even = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(1, 2, 2, 1)));
        ListNode<Integer> odd = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1)));
        ListNode<Integer> even2 = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(1, 3, 2, 1)));
        ListNode<Integer> odd2 = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(1, 3, 3, 2, 1)));
        System.out.println(isPalindrome(even));
        System.out.println(isPalindrome(odd));
        System.out.println(isPalindrome(even2));
        System.out.println(isPalindrome(odd2));
    }
}
