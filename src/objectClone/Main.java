package objectClone;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human meet = new Human(21,"meet");
        Human kunal = (Human) (meet.clone());
        System.out.println(kunal.age + " " + kunal.name);
        kunal.arr[0] = 100;
        kunal.name = "banda";
        System.out.println(Arrays.toString(kunal.arr));
        System.out.println(Arrays.toString(meet.arr));
        System.out.println(kunal.name);
        System.out.println(meet.name);



    }
}
