package OOPS.abstractDemo;

public abstract class parent {
    int age ;

    public parent(int age) {
        this.age = age;
    }

    static void say(){
        System.out.println("hello");
    }
    void normal(){
        System.out.println("this is a normal method");
    }
    abstract void carrer();
    abstract void partner();
}
