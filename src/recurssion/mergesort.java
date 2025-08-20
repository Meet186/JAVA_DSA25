package recurssion;
import java.util.Arrays;
public class mergesort {
    static void mergeSort(int[] arr,int startindex,int endindex){
        if(startindex >= endindex) return;
        int mid = startindex + (endindex - startindex)/2;
        mergeSort(arr, startindex, mid);
        mergeSort(arr, mid + 1, endindex);
        merge(arr,startindex,mid,endindex);
    }
    static void merge(int[] arr, int startindex,int midindex,int endindex){
        int length1 = midindex - startindex + 1;
        int length2 = endindex-midindex;

        int[] left = new int[length1];
        int[] right = new int[length2];

        for (int i = 0; i < length1; i++) {
            left[i] = arr[startindex + i];
        }
        for (int i = 0; i < length2; i++) {
            right[i] = arr[midindex + 1 + i];
        }
        int l = 0;
        int m = 0;
        int k = startindex;
        while (l < length1 && m < length2){
            if(left[l] <= right[m]){
                arr[k++] = left[l++];
            } else {
                arr[k++] = right[m++];
            }
        }
        while (l < length1){
            arr[k++] = left[l++];
        }
        while (m < length2){
            arr[k++] = right[m++];
        }
    }

    static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid)); // last index exclude
        int[] rigth = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        return mergeArray(left,rigth);

    }

     static int[] mergeArray(int[] first, int[] second) {
        int mix[] = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length){
            if(first[i] < second[j]){
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < first.length){
            mix[k++] = first[i++];
        }
        while (j < second.length){
            mix[k++] = second[j++];
        }

        return mix;
    }

    public static void main(String[] args) {
      int[] arr = {7,5,9,4,9,7,8,2,0,1,23,4,5};
      int[] ans = mergeSort(arr);
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(arr));
    }
}
