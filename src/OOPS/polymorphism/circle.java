package OOPS.polymorphism;

public class circle extends shapes{
    @Override
    void area(){
        System.out.println("Area is pie * r * r");
    }
    // OVERIGHT {Dynamic poly-morphism}
    int sum(int a , int b){
        return a * b;
    }
}
