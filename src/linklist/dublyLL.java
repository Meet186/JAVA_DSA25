package linklist;

public class dublyLL {
    private Node head;
    private Node tail;
    private Node prev;

    private int size;

    public dublyLL() {
        size = 0;
    }
    private class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
            Node next;
            Node prev;
        }

        public Node() {
        }
    }
    public void insertAtfirst(int val) {
        Node temp = new Node(val);
        if (head == null) {
            tail = temp;
        } else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
        size++;
    }
    public void insertAtLast(int val) {
        Node temp = new Node(val);
        if (tail == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
        size++;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ---> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}
