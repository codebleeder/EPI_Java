package Chapter07_LinkedLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LinkedLists_05_OverlappingLists {
    public static ListNode<Integer> overlappingLists(ListNode<Integer> a, ListNode<Integer> b) {
        ListNode<Integer> a_CycleStart = LinkedLists_03_HasCycle.hasCycle(a);
        ListNode<Integer> b_CycleStart = LinkedLists_03_HasCycle.hasCycle(b);

        // case 1: one of them has cycle and the other one doesn't have a cycle:
        if ((a_CycleStart == null && b_CycleStart != null) || (a_CycleStart != null && b_CycleStart == null)) {
            return null;
        }

        // case 2: neither have cycles
        if (a_CycleStart == null && b_CycleStart == null) {
            return LinkedLists_04_OverlappingNoCycleLists.overlappingNoCycleLists(a, b);
        }

        // case 3: both have cycles; join before cycle begins
        if (a_CycleStart != null && b_CycleStart != null && a_CycleStart == b_CycleStart) {
            int aLength = 1, bLength = 1; // lengths before cycle start
            ListNode<Integer> runner = a;
            while (runner != a_CycleStart) {
                ++aLength;
                runner = runner.next;
            }
            runner = b;
            while (runner != a_CycleStart) {
                ++bLength;
                runner = runner.next;
            }
            ListNode<Integer> longer = aLength > bLength ? a : b;
            ListNode<Integer> shorter = aLength < bLength ? a : b;
            int difference = Math.abs(aLength - bLength);
            while (difference > 0) {
                longer = longer.next;
                --difference;
            }
            while (longer != shorter) {
                longer = longer.next;
                shorter = shorter.next;
            }
            return longer;
        }

        // case 4: both have cycles; join at different node in the cycle
        // return one of the starts:
        return a_CycleStart;
    }

    public static void main(String[] args) {
        // case 1: no overlap - A has cycle and B doesn't
        ListNode<Integer> a1 = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(0, 1, 2, 3)));
        ListNode<Integer> b1 = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(4, 5, 6, 7)));
        b1.next.next.next.next = b1.next;

        ListNode<Integer> res1 = overlappingLists(a1, b1);
        if (res1 == null) {
            System.out.println("case1: pass");
        }

        List<Integer> list_a = IntStream.rangeClosed(0, 4).boxed().collect(toList());
        ListNode<Integer> a2 = ListNode.generateLinkedList(list_a);
        ListNode<Integer> b2 = new ListNode<>(0);
        b2.next = a2.next.next;
        ListNode<Integer> res2 = overlappingLists(a2, b2);
        System.out.println();
        System.out.print("case2: ");
        if (res2 != null) {
            System.out.print(res2.data);
            System.out.print(" pass ");
        } else {
            System.out.print("null ");
        }

        // case 3
        System.out.println();
        System.out.println("case 3: ");
        ListNode<Integer> a3 = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        ListNode<Integer> a3_4 = ListNode.traverse(a3, 4);
        ListNode<Integer> a3_6 = ListNode.traverse(a3, 6);
        a3_6.next = a3_4;
        ListNode<Integer> a3_3 = ListNode.traverse(a3, 3);

        ListNode<Integer> b3 = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(7, 8, 9)));
        ListNode<Integer> b3_9 = ListNode.traverse(b3, 9);
        b3_9.next = a3_3;
        ListNode<Integer> res3 = overlappingLists(a3, b3);
        if (res3 != null) {
            System.out.println("expected: 3, result: " + res3.data);
            System.out.println(res3.data == 3 ? "pass" : "fail");
        } else System.out.println("fail");

        // case 4:
        System.out.println("\ncase 4: ");
        ListNode<Integer> a4 = ListNode.generateLinkedList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        ListNode<Integer> a4_5 = ListNode.traverse(a4, 5);
        ListNode<Integer> a4_3 = ListNode.traverse(a4, 3);
        a4_5.next = a4_3;
        ListNode<Integer> b4 = new ListNode<>(6);
        b4.next = a4_5;
        ListNode<Integer> res4 = overlappingLists(a4, b4);
        System.out.println("expected: 3 or 5");
        System.out.println("result: " + (res4 != null ? res4.data : "null"));
        if (res4 != null) {
            System.out.println(res4.data == 3 || res4.data == 5 ? "pass" : "fail");
        }
    }
}
