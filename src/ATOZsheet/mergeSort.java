package ATOZsheet;

import java.util.Arrays;

public class mergeSort {
    public static void mergeSort(int[]arr){
        helper(arr,0,arr.length-1);
    }
    private static void helper(int[] arr, int si, int ei){
        if(si >= ei) return;
        int mid = si + (ei-si)/2;
        helper(arr, si, mid);
        helper(arr, mid + 1, ei);
        merge(arr,si,mid,ei);
    }
    private static void merge(int[] arr,int si,int mid,int ei){
        int[] left = new int[mid-si + 1];
        int[] right = new int[ei-mid];

        for(int i=0; i<left.length; i++){ // fill left array
            left[i] = arr[si + i];
        }
        for(int i=0; i<right.length; i++){ // fill right array
            right[i] = arr[mid + 1 + i];
        }
        int l = 0; // point to left array
        int r = 0; // point to right array
        int k = si; // point to indices every time
        while(l < left.length && r < right.length){
            if(left[l] < right[r]){
                arr[k++] = left[l];
                l++;
            } else {
                arr[k++] = right[r];
                r++;
            }
        }

        while (l < left.length){
            arr[k++] = left[l];
            l++;
        }

        while (r < right.length){
            arr[k++] = right[r];
            r++;
        }

    }
    public static void main(String[] args) {
        int[] arr = {4,5,7,8,9,1,2,3,4,5,8,0,2,1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
