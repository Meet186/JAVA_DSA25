package OOPS.Interface;

public class car implements Engine, Break , Media{
    @Override
    public void brake() {
        System.out.println("I break like a normal car");
    }

    @Override
    public void start() {
        System.out.println("I Start  engine like  a normal car");
    }

    @Override
    public void stop() {
        System.out.println("I Stop engine like engin a normal car");
    }

    @Override
    public void acc() {
        System.out.println("I accelerate like a normal car");
    }
}
