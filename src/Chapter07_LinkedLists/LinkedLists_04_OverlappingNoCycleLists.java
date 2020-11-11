package Chapter07_LinkedLists;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LinkedLists_04_OverlappingNoCycleLists {
    public static ListNode<Integer> overlappingNoCycleLists(ListNode<Integer> a, ListNode<Integer> b) {
        int length_a = 0, length_b = 0;
        ListNode<Integer> aIter = a;
        while (aIter != null) {
            aIter = aIter.next;
            ++length_a;
        }
        ListNode<Integer> bIter = b;
        while (bIter != null) {
            bIter = bIter.next;
            ++length_b;
        }
        ListNode<Integer> longer = length_a > length_b ? a : b;
        ListNode<Integer> shorter = length_a < length_b ? a : b;
        int difference = Math.abs(length_a - length_b);
        while (difference > 0) {
            longer = longer.next;
            --difference;
        }
        while (longer != null && shorter != null && longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }
        if (shorter != null) return shorter;
        return null;
    }

    public static void main(String[] args) {
        List<Integer> list_a = IntStream.rangeClosed(0, 4).boxed().collect(toList());
        ListNode<Integer> a = ListNode.generateLinkedList(list_a);
        ListNode<Integer> b = new ListNode<>(0);
        b.next = a.next.next;
        ListNode<Integer> res = overlappingNoCycleLists(a, b);
        if (res != null) {
            System.out.println(res.data);
        } else {
            System.out.println("null");
        }
    }
}
