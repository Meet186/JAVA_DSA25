import java.text.CollationElementIterator;
import java.util.Arrays;

import static java.util.Collections.swap;

public class Rectangle {
    static void reverse(int[] arr,int i,int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    static void rotateArr(int arr[], int d) {
        int n = arr.length;
        reverse(arr,d,n-1);
        reverse(arr,0,d-1);
        reverse(arr,0,n-1);


    }
    public static int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max,dimensions[i][0] * dimensions[i][1]);
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] dimension = {{2,6},{5,1},{3,10},{8,4}};
        System.out.println(areaOfMaxDiagonal(dimension));

    }
}
