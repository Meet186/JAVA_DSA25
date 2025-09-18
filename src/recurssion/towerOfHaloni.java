package recurssion;

public class towerOfHaloni {
    static int printHaloni(int n,int from,int to,int auxalry){
        if(n == 0) return 0 ;
        if(n == 1){
            System.out.println("Move disk" + n  + "from rod" + from + "to rod" + to);
            return 1;
        }
        int count  = printHaloni(n-1,from,auxalry,to);
        System.out.println("Move disk" + n  + "from rod" + from + "to rod" + to);
        count+= 1;
        count += printHaloni(n-1,auxalry,to,from);
        return count;
    }
    public static void main(String[] args) {
        int n = 33;
        System.out.println( printHaloni(10,1,2,3));
    }
}
