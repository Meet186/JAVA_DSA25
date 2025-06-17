package Sorting;

import java.util.Arrays;

public class cyclicSort {
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void cyclic_Sort(int[] arr){
        int i = 0;
        while (i < arr.length){
            int correct_index = arr[i] - 1;
            if(arr[i] <= arr.length && arr[i] > 0 && arr[i] != arr[correct_index]){
                swap(arr,i,correct_index);
            } else {
                i++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,4,-1,1};
        cyclic_Sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
