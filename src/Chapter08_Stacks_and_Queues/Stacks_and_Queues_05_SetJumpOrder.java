package Chapter08_Stacks_and_Queues;

import Chapter07_LinkedLists.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stacks_and_Queues_05_SetJumpOrder {
    public static class PostingListNode {
        public Integer order;
        public PostingListNode next;
        public PostingListNode jump;

        public PostingListNode() {
        }

        public PostingListNode(int order, PostingListNode next, PostingListNode jump) {
            this.order = order;
            this.next = next;
            this.jump = jump;
        }
    }

    // recursive:
    public static void setJumpOrder(PostingListNode head) {
        helper(head, 0);
    }

    public static int helper(PostingListNode node, int order) {
        if (node != null && node.order == -1) {
            node.order = order + 1;
            order = helper(node.jump, order + 1);
            order = helper(node.next, order + 1);
        }
        return order;
    }

    // iterative using stacks:
    public static void setJumpOrder2(PostingListNode node) {
        Deque<PostingListNode> s = new ArrayDeque<>();
        int order = 0;
        if (node != null) {
            s.addLast(node);
        }
        while (!s.isEmpty()) {
            PostingListNode curr = s.removeLast();
            if (curr.order == -1) {
                curr.order = order++;
                if (curr.next != null) {
                    s.addLast(curr.next);
                }
                if (curr.jump != null) {
                    s.addLast(curr.jump);
                }
            }
        }
    }

    public static void main(String[] args) {
        PostingListNode a = new PostingListNode(-1, null, null);
        PostingListNode b = new PostingListNode(-1, null, null);
        PostingListNode c = new PostingListNode(-1, null, null);
        PostingListNode d = new PostingListNode(-1, null, null);
        a.next = b;
        b.next = c;
        c.next = d;

        a.jump = c;
        b.jump = d;
        c.jump = b;
        d.jump = d;
        setJumpOrder(a);
        StringBuilder sb = new StringBuilder();
        while (a != null) {
            sb.append(a.order + "-> ");
            a = a.next;
        }
        System.out.println(sb.toString());
    }
}
