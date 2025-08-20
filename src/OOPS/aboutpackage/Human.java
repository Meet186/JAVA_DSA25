package OOPS.aboutpackage;
public class Human {
    int age;
    String name;
    int salary;
    static long popullation;
     void greet(){
        System.out.println("hello " + this.name);
        fun();
    }
    static void fun(){
        System.out.println("funnnn");

    }
    public Human(int age, String name, int salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        Human.popullation +=1;
    }
}
