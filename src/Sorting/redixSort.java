package Sorting;
import java.util.Arrays;
public class redixSort {
    static int MAX_EL(int[] arr){
        int max = arr[0];
        for(int num : arr){
            if(max < num){
                max = num;
            }
        }
        return max;
    }
    static void redixSort(int[] arr){
        int max = MAX_EL(arr);
        for (int place = 1; max/place > 0 ; place *= 10) {
            countsort(arr,place);
        }
    }
    private static void countsort(int[] arr, int place) { // TC - O(N)
        int n = arr.length;
        int[] output = new int[arr.length];
        int[] frequency = new int[10];
        for (int i = 0; i < arr.length; i++) {
            frequency[(arr[i]/place) % 10]++;
        }
        // create a prefix sum
        for (int i = 1; i < frequency.length; i++) {
            frequency[i] += frequency[i-1];
        }
        for (int i = n-1; i >=0 ; i--) {
            int lastIndex = frequency[(arr[i]/place) % 10]-1;
            output[lastIndex] = arr[i];
            frequency[(arr[i]/place) % 10]--;
        }
        // copy to original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];

        }
    }
    public static void main(String[] args) {
        int[] arr = {785,123,45,789,111,2,232};
        redixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
