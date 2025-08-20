package OOPS.singleton;

public class singleton {
    private singleton (){

    }
    private static singleton instance;
    public static singleton getsingleton(){
        if(instance == null){
            instance = new singleton();
        }
        return instance;
    }
}
