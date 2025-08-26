package linklist;

public class selfLL {

    private Node head;
    private Node tail;
    private int size;


    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node() {

        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public int getTail(){
        return tail.value;
    }

    public void insertAtfirst(int val){
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    // insert with resurssion
    private Node insertRec(int val,int index,Node node){
        if(index == 0){
            Node temp = new Node(val);
            size++;
            return temp;
        }

        node.next = insertRec(val,index-1,node.next);
        return node;
    }

    public void insertRec(int val,int index){
        head = insertRec(val,index,head);
    }

    public void insertAtLast(int val){
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

    public void insertAt(int val,int index){
        Node temp = new Node();
        temp = head;
        for(int i=1; i< index; i++){
            temp = temp.next;
        }
        Node newNode = new Node(val);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public int getSize(){
        return size;
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        size--;
        return val;
    }

    public int deleteLast(){
       Node temp = new Node();
        temp = head;
        while (temp.next.next != null){
            temp = temp.next;
        }
        int value = temp.next.value;
        tail = temp;
        temp.next = null;
        size--;
        return value;
    }

    public int deleteAt(int index){
        Node temp = new Node();
        temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        int value = temp.next.value;
        temp.next = temp.next.next;
        size--;
        return value;

    }

    public void display(){
        Node temp = new Node();
        temp = head;
        while (temp != null){
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println();
    }







}
