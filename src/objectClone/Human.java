package objectClone;

import java.util.Arrays;

public class Human implements Cloneable{
    int age;
    String name;
    int[] arr;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
        this.arr = new int[] {1,2,3,4,5};
    }


    public Human(Human other){
       this.age = other.age;
       this.name = other.name;

    }

    public Object clone() throws CloneNotSupportedException{
        // create a shallo copy
        Human twin = (Human) super.clone();
        // Deep Copy
        twin.arr = new int[twin.arr.length];
        for (int i = 0; i < this.arr.length; i++) {
            twin.arr[i] = this.arr[i];
        }

        return twin;

    }


}
