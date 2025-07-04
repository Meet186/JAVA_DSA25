import java.util.Arrays;
public class Main {
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void cyclic_Sort(int[] arr){
        int n = arr.length;
        int i = 0;
        while (i < arr.length){
            int correct_Index = arr[i]-1;
            if(arr[i] != arr[correct_Index] ){
                swap(arr,i, correct_Index);
            } else {
                i++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,7,9,0,10,3,2};
        cyclic_Sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}