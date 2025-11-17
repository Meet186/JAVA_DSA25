package Sorting;
import java.util.Arrays;
public class countSort {
    static void CountSort(int[] arr){ // UNSTABLE
        if(arr == null || arr.length <= 1){
            return;
        }
        int max = arr[0];
        for(int num : arr){
            if(num > max){
                max = num;
            }
        }
        int[] countArray = new int[max + 1];
        for(int num : arr){
            countArray[num]++;
        }
        int index = 0;
        for (int i = 0; i < max; i++) {
            while (countArray[i] > 0){
                arr[index++] = i;
                countArray[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,5,2,2,1,3,0,9};
        System.out.println(Arrays.toString(arr));
        CountSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
