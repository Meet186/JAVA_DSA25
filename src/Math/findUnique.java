package Math;
public class findUnique {
    public static void main(String[] args) {
        int[] arr = {2,3,3,4,2,6,4};
        System.out.println(uinque_InArray(arr));
    }
    public static int uinque_InArray(int[] arr) {
        int unique = 0;
        for(int n : arr){
            unique ^= n;
        }
        return unique;
    }
}
