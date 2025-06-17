package recurssion;

import java.util.Arrays;

public class quickSort {
    static void quickSort(int[]arr,int si,int ei){
        if(si >= ei) return;
        int pivot = partation(arr,si,ei);
        quickSort(arr, si, pivot-1);
        quickSort(arr, pivot+1, ei);
    }
    static int partation(int[] arr,int si,int ei){
        int piviot = arr[si];
        int count = 0;
        for (int i = si + 1; i <= ei ; i++) {
            if(arr[i] <= piviot) {
                count++;
            }
        }
        int piviotIndex = si + count;
        swap(arr,si,piviotIndex);
        int i = si;
        int j = ei;
        while (i < piviotIndex && j > piviotIndex){
            while (arr[i] <= piviot) i++;
            while (arr[j] >= piviot) j--;

            if(i < piviotIndex && j > piviotIndex){
                swap(arr, j, i);
                i++;
                j--;
            }
        }


        return piviotIndex;
    }

    static void swap(int[] arr,int si,int ei){
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei]  = temp;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,7,8,9,1,0,2,3};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
