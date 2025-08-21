package OOPS.Interface;

public class powerEngine implements Engine{
    @Override
    public void start() {
        System.out.println("Engine start");
    }

    @Override
    public void stop() {
        System.out.println("Engine stop");
    }

    @Override
    public void acc() {
        System.out.println("Engine accelerate");
    }
}
