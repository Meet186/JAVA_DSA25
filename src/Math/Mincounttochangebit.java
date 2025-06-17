package Math;

public class Mincounttochangebit {
    public static void main(String[] args) {
        /*
         input -> start = 3 goal = 4
         Binary of 3 -> 011  Binary of 4 -> 100
         output -> 3  {we need to change all the bits to make 3 to 4}
         */

        int start = 3;
        int goal = 4;

        int ans = start ^ goal;
        int count = 0;
        for (int i = 0; i < 31; i++) {
            if ((ans & (1 << i)) != 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
