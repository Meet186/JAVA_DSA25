package linklist;

import org.w3c.dom.NodeList;

public class mergeSort {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {
       ListNode prev = null;
       ListNode slow = head;
       ListNode fast = head;

       while (fast != null && fast.next != null){
           prev = slow;
           slow = slow.next;
           fast = fast.next.next;

       }
       prev.next = null;
       return slow;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode head = new ListNode(0);
        ListNode temp = head;

        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                temp.next = temp1;
                temp = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp = temp2;
                temp2 = temp2.next;
            }
        }

        if (temp1 == null) {
            temp.next = temp2;
        } else {
            temp.next = temp1;
        }

        return head.next;
    }
    // https://leetcode.com/problems/sort-list/
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeTwoLists(left,right);

    }
}
