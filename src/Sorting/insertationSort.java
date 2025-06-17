package Sorting;

import java.util.Arrays;

public class insertationSort {

    static void insertation_sort(int[] arr){
        for (int i =1 ; i <arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {5,4,1,7,2,3,0};
        insertation_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
