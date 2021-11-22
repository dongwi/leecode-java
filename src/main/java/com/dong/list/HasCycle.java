package com.dong.list;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next == null || fast.next.next == null) {
                ListNode crossNode = getCrossNode(head, fast);
                System.out.println(crossNode);
                return false;
            }
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode getCrossNode(ListNode head, ListNode cross) {
        while(head != cross) {
            head = head.next;
            cross = cross.next;
        }
        return head;
    }
}
