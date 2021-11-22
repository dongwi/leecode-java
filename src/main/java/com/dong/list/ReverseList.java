package com.dong.list;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode current = head;
        ListNode next;

        while (current!=null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 返回的是head.next链表的头节点
        ListNode listNode = reverseListRecursion(head.next);
        // head的next的next就是listNode.next
        listNode.next = head;
        //head.next.next = head;
        head.next =null;
        return listNode;
    }
}
