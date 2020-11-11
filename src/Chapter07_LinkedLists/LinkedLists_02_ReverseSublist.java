package Chapter07_LinkedLists;

public class LinkedLists_02_ReverseSublist {
    public static ListNode reverse(ListNode a) {
        ListNode a1 = a;
        ListNode a2 = a.next;
        ListNode a3 = a2.next;
        a1.next = null;
        while (a1 != null && a2 != null && a3 != null) {
            a2.next = a1;
            a1 = a2;
            a2 = a3;
            a3 = a2.next;
        }

        a2.next = a1;
        return a2;
    }

    // book sol:
    public static ListNode<Integer> reverse2(ListNode<Integer> l, int start, int finish) {
        ListNode<Integer> dummyHead = new ListNode<>(0, l);
        ListNode<Integer> sublistHead = dummyHead;
        int k = 1;
        while (k++ < start) {
            sublistHead = sublistHead.next;
        }

        //reverse sublist
        ListNode<Integer> iter = sublistHead.next;
        while (start++ < finish) {
            ListNode<Integer> iter2 = iter.next;
            iter.next = iter2.next;
            iter2.next = sublistHead.next;
            sublistHead.next = iter2;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode<Integer> a = new ListNode<Integer>(0);
        ListNode<Integer> b = new ListNode<Integer>(1);
        ListNode<Integer> c = new ListNode<Integer>(2);
        ListNode<Integer> d = new ListNode<Integer>(3);
        ListNode<Integer> e = new ListNode<Integer>(4);
        ListNode<Integer> f = new ListNode<Integer>(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        ListNode res = reverse(a);
        ListNode.printLinkedList(res);
    }
}
