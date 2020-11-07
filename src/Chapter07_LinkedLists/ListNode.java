package Chapter07_LinkedLists;

import java.util.List;

public class ListNode<T> {
    public T data;
    public ListNode<T> next;
    public ListNode(T v){
        data = v;
    }
    public ListNode(T v, ListNode<T> n){
        data = v;
        next = n;
    }
    public static void printLinkedList(ListNode<Integer> n){
        StringBuilder sb = new StringBuilder();
        while (n != null){
            sb.append(n.data + "-> ");
            n = n.next;
        }
        System.out.println(sb.toString());
    }
    public static ListNode<Integer> generateLinkedList(List<Integer> arr){
        ListNode<Integer> dummy = new ListNode<>(0);
        ListNode<Integer> iter = dummy;
        for (int n: arr){
            iter.next = new ListNode<>(n);
            iter = iter.next;
        }
        return dummy.next;
    }

    public static void printListNode(ListNode<Integer> n) {
        System.out.println("-> (" + n.data + ") -> " + (n.next == null ? "null" : n.next.data.toString()));
    }
}
