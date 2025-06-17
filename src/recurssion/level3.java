package recurssion;

import java.util.Arrays;

public class level3 {
    static void printPttern(int row,int col){
        if(row == 0){
            return;
        }
        if(col < row){
            System.out.print("*");
            printPttern(row, col + 1);
        } else {
            System.out.println();
            printPttern(row-1,0);
        }
    }

    static void bubbleSort(int[] arr,int length, int index){
        if(length == 0){
            return;
        }

        if(index < length){
            if(arr[index] > arr[index+1]){ // swap
                int temp = arr[index];
                arr[index] = arr[index+1];
                arr[index+1] = temp;
            }
            bubbleSort(arr,length,index+1);

        }  else {
            bubbleSort(arr,length-1,0);
        }
    }
    static void selectionSort(int[] arr, int length,int index , int max){
        if(length == 0) return;
        if(index < length){
            if(arr[index] > arr[max]){
                selectionSort(arr, length, index+1,index);
            } else {
                selectionSort(arr, length, index+1,max);
            }
        } else {
            int temp = arr[max];
            arr[max] = arr[length-1] ;
            arr[length-1] = temp;
            selectionSort(arr, length-1, 0, 0);
        }
    }
    static void recurssive_Insertation_Sort(int[] arr , int i,int j){
        if(i == arr.length) return;
        if(j > 0 && arr[j] < arr[j-1]){
            int temp = arr[j];
            arr[j] = arr[j-1];
            arr[j-1] = temp;
            recurssive_Insertation_Sort(arr, i, j-1);
        } else {
            recurssive_Insertation_Sort(arr, i+1, i+1);
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        selectionSort(arr,arr.length,0,0);
        System.out.println(Arrays.toString(arr));
    }
}
