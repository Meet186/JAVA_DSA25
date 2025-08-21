package OOPS.abstractDemo;

public class daughter extends parent {

    public daughter(int age) {
        super(age);
    }

    @Override
    void carrer() {
        System.out.println("I am going to be a doctor");
    }

    @Override
    void partner() {
        System.out.println("I love Iron Man " );
    }
}
