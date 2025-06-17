import java.net.InetAddress;
import java.util.Arrays;
import java.util.HashSet;
public class random {
    static int[] union(int[]arr1, int[]arr2){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        int[] ans = new int[set.size()];
        int index = 0;
        for(int el : set){
            ans[index++] = el;
        }
        return ans;

    }
    static int[] rearrange_El(int[] arr){
        int n = arr.length;
        int[] result = new int[n];
        int positive_Index = 0;
        int negative_Index = 1;

        for (int i = 0; i < n; i++) {
            if(arr[i] > 0){ // Positive
                result[positive_Index] = arr[i];
                positive_Index += 2;
            } else {
                result[negative_Index] = arr[i];
                negative_Index += 2;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println("local host name :" + localhost.getHostName());
            System.out.println("local host address :" + localhost.getHostAddress());
         } catch (Exception c ){
            c.printStackTrace();
        }
     }
}
