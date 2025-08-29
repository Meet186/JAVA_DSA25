package linklist.leetcode707;

import linklist.selfLL;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node{
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }
    }

    public void addAtHead(int val) {
            if(head == null){
                tail = head;
            }
            Node newNode = new Node(val);
            head.next = newNode;
            size++;
    }

    public void addAtTail(int val) {
        Node temp = new Node(val);
        if(head == null){
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public int get(int index) {

        for (int i = 1; i < index; i++) {
            head = head.next;
        }
        return head.val;
    }

    public void addAtIndex(int index, int val) {
        Node temp = new Node(0);
        temp = head;
        for(int i=1; i< index; i++){
            temp = temp.next;
        }
        Node newNode = new Node(val);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        Node temp = head;
        for (int i = 0; i < index-1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;

    }
}
