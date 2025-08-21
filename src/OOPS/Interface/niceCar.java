package OOPS.Interface;

public class niceCar {
    private Engine engine ;
    private mediaplayer cdplayer = new mediaplayer();

    public niceCar() {
        this.engine = new powerEngine();
    }

    public void start(){
        engine.start();
    }
    public void stop(){
        engine.stop();
    }

    public void startMusic(){
        cdplayer.start();
    }

    public void stopMusic(){
        cdplayer.stop();
    }
}
