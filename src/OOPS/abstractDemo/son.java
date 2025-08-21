package OOPS.abstractDemo;

public class son extends parent {
    public son(int age) {
        super(age);
    }

    @Override
    void carrer() {
        System.out.println("I am going to be a coder ");
    }

    @Override
    void partner() {
        System.out.println("I love my partner" );
    }
}


