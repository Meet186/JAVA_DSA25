package Sorting;
import java.util.Arrays;
public class bubblesort {
   // Bubble sort also known as sinking sort or  exchange sort.
    static void bubble_Sort(int[] arr){
        // TC -> O(N*N) worst case
        // TC -> O(N) Best case
       int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 1; j < n-i; j++) {
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                return;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {8,9,10,123,45,7,2,3,0,1};
        bubble_Sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
