package Sorting;

import java.util.Arrays;

public class StableCountSort {
    static int MAX_EL(int[] arr){
        int max = arr[0];
        for(int num : arr){
            if(max < num){
                max = num;
            }
        }
        return max;
    }
    static void countSort(int[] arr){
        int max = MAX_EL(arr);
        int[] output = new int[arr.length];
        int[] frequency = new int[max + 1];
        for(int el : arr){
            frequency[el]++;
        }
        // convert to prefix array
        for (int i = 1; i < frequency.length; i++) {
            frequency[i] += frequency[i-1];
        }
        for(int i=arr.length-1; i>=0; i--){
            int lastIndex = frequency[arr[i]]-1;
            output[lastIndex] = arr[i];
            frequency[arr[i]]--; // decrease the value for upcoming same value for previous index
        }
        // copy to original array
        for (int i=0; i<arr.length; i++){
            arr[i] = output[i];
        }

    }
    public static void main(String[] args) {
        int[] arr = {5,8,7,9,1,2,3,3,4,2,0};
        countSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
