package Math;

public class power {

    public static int pow(int x,int y){
        if(y == 0) return 1;
        int half = pow(x,y/2);
        if(y % 2 == 0 ){
            return half * half;
        }
        return  x * half * half;

    }

    public static void main(String[] args) {
//        int base = 3;
//        int power = 6;
//        int ans = 1;
//        while (power > 0){
//            if((power & 1) == 1){
//                ans *= base;
//            }
//            base *= base;
//            power = power >> 1;
//        }
//        System.out.println(ans);
        System.out.println(pow(2,4));
    }
}
