package Sorting;
import java.util.Arrays;
public class selectionsort {
    static void selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min_Index = i;
            for (int j = i+1; j <n ; j++) {
                if(arr[j] < arr[min_Index]){
                    min_Index = j;
                }
            }
            if(min_Index != i){
                int temp = arr[i];
                arr[i] = arr[min_Index];
                arr[min_Index] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,5,1,2,3};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
