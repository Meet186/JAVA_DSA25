package stackandQueue;

public class selfStack {
    // size of stack.
    private int arr [] = new int[100];
    private int idx = 0;


    public void push(int x){
        arr[idx] = x;
        idx++;
    }
    public int peack(){
        if(idx == 0){
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[idx-1];

    }
    public int pop(){
        if(idx == 0){
            System.out.println("Stack is empty");
            return -1;
        }
        int top = arr[idx - 1];
        arr[idx-1] = 0;
        idx--;
        return top;
    }
    public int size(){
        return idx;
    }
    public boolean isEmpty(){
        if(idx == 0) return true;
        return  false;
    }

    public void display(){
        for (int i = 0; i < idx; i++) {
            System.out.print(  arr[i] + " ");
        }
        System.out.println();
    }
    public boolean isStackFull(){
        if(idx == arr.length) return true;
        return false;
    }

}
