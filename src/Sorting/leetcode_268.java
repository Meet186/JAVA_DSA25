package Sorting;
//https://leetcode.com/problems/missing-number/description/
public class leetcode_268 {
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int missing_num(int[] arr){
        int i = 0;
        while (i < arr.length){
            int correct_index = arr[i];
            if( arr[i] < arr.length && arr[i] != arr[correct_index]){
                swap(arr,i,correct_index);
            } else {
                i++;
            }
        }
        for (int j = 1; j < arr.length; j++) {
            if(arr[j] != j){
                return j;
            }
        }
        return arr.length;
    }
    public static void main(String[] args) {
        int[] arr = {4,1,2,5};
        System.out.println(missing_num(arr));
    }
}
