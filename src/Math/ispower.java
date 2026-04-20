package Math;

public class ispower {
    public boolean isPower(int x, int y) {
        if(y == 1) return true;
        if(x == 1) return y == 1;

        while(y % x == 0){
            y =  y/x;
        }

        return y == 1;

    }
}
