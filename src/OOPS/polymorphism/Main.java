package OOPS.polymorphism;

public class Main {
    public static void main(String[] args) {
        shapes shape = new shapes();
        shapes circle = new circle();
        square square = new square();
        Triangle triangle = new Triangle();

        shape.area();
        circle.area();

        Number obj = new Number();
        System.out.println(obj.sum(4, 5, 8));
    }
}
