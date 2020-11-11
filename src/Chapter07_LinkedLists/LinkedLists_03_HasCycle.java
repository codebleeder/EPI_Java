package Chapter07_LinkedLists;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinkedLists_03_HasCycle {
    public static ListNode<Integer> hasCycle(ListNode<Integer> n) {
        ListNode<Integer> slow = n;
        ListNode<Integer> fast = n;
        do {
            slow = slow.next;

            fast = fast.next.next;
            if (slow == fast) {
                // there is a cycle
                slow = n;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // cycle starts from here
            }
        }
        while (fast != null && fast.next != null && slow != null);
        return null;
    }

    public static void main(String[] args) {
        List<ListNode<Integer>> listNodes = IntStream.rangeClosed(0, 10)
                .mapToObj(i -> new ListNode<Integer>(i))
                .collect(Collectors.toList());
        for (int i = 0; i < listNodes.size() - 1; ++i) {
            listNodes.get(i).next = listNodes.get(i + 1);
        }
        listNodes.get(listNodes.size() - 1).next = listNodes.get(2);
        ListNode<Integer> res = hasCycle(listNodes.get(0));
        System.out.println("result = " + res != null ? res.data : "null");
        System.out.println("expected = true");

        listNodes.get(listNodes.size() - 1).next = null;
        ListNode<Integer> res2 = hasCycle(listNodes.get(0));
        if (res2 == null) {
            System.out.println("null");
        } else {
            System.out.println(res2.data);
        }
        System.out.println("expected = false");
    }
}
