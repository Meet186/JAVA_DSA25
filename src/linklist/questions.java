package linklist;

import org.w3c.dom.Node;

import java.util.List;

public class questions {


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

    // leetcode 83
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        if (node == null) return head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    //https://leetcode.com/problems/merge-two-sorted-lists/
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

    //  https://leetcode.com/problems/linked-list-cycle/
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == null) return false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }

    // Find the length of cycle
    public static int lengthOfCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int length = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode temp = slow;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != fast);
                return length;
            }
        }
        return 0;
    }

    //https://leetcode.com/problems/linked-list-cycle-ii/
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        ListNode temp = head;
        while (temp != slow) {
            temp = temp.next;
            slow = slow.next;
        }

        return slow;
    }

    //https://leetcode.com/problems/happy-number/
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = squareOfnum(slow);
            fast = squareOfnum(squareOfnum(n));
        } while (slow != fast);

        if (slow == 1) {
            return true;
        }
        return false;
    }

    private int squareOfnum(int number) {
        int ans = 0;
        while (number > 0) {
            int rem = number % 10;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }

    // https://leetcode.com/problems/middle-of-the-linked-list/description/
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // reverse a linklist
    //https://leetcode.com/problems/reverse-linked-list/
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode after = null;
        ListNode prev = null;

        while (curr != null) {
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        return prev;
    }
    // https://leetcode.com/problems/palindrome-linked-list/
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = reverseList(slow.next);
        slow.next = temp;
        ListNode p1 = head;
        ListNode p2 = slow.next;

        while (p2 != null) {
            if (p2.val != p1.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    // https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
    public int pairSum(ListNode head) {
        int MAX = Integer.MIN_VALUE;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = reverseList(slow.next);
        slow.next = temp;
        ListNode p1 = head;
        ListNode p2 = slow.next;

        while (p2 != null) {
            int sum = p1.val + p2.val;
            p2 = p2.next;
            p1 = p1.next;
            MAX = Math.max(MAX, sum);
        }
        return MAX;
    }
    //https://leetcode.com/problems/odd-even-linked-list/
    public ListNode oddEvenList(ListNode head) {
        ListNode temp = head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenStart = head.next;

        while (temp != null && temp.next != null){
           odd.next = even.next;
           even.next = even.next.next;
           odd = odd.next;
           even = even.next;
        }
        odd.next = evenStart;
        return head;
    }

    // https://leetcode.com/problems/add-two-numbers/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode newHead = new ListNode();
        ListNode current = newHead;
        while (l1 != null || l2 != null || carry != 0){
           int  sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            } if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode(sum % 10);
            carry = sum/10;
            current = current.next;
        }
        return newHead.next;
    }

    //https://leetcode.com/problems/partition-list/
    public ListNode partition(ListNode head, int x) {
        ListNode s = new ListNode();
        ListNode sStart = s;
        ListNode g = new ListNode();
        ListNode gStart =g;

        ListNode temp = head;
        while (temp != null){
            if(temp.val < x){
                s.next = temp;
                s = temp;
            } else {
                g.next = temp;
                g = temp;
            }
            temp = temp.next;
        }
        g.next = null; // clear the cycle {remember . }
        s.next = gStart.next;

        return sStart.next;
    }

    //https://leetcode.com/problems/remove-linked-list-elements/
    public ListNode removeElements(ListNode head, int val) {
            ListNode temp = new ListNode();
            ListNode curr = temp;
            curr.next = head;
            while (curr.next != null){
                if(curr.next.val == val) curr.next = curr.next.next;
                else curr = curr.next;
            }

            return temp.next;

    }

    public static void main(String[] args) {

    }
}
