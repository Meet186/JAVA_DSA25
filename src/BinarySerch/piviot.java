package BinarySerch;

public class piviot {
    static int piviot(int[] arr){
        int si = 0;
        int ei = arr.length-1;

        while (si <= ei){
            int mid = si + (ei-si)/2;
            if(mid < ei && arr[mid] > arr[mid+1]) return mid;
            if(mid > si && arr[mid] < arr[mid-1]) return mid-1;
            if(arr[si] >= arr[mid]){
                ei = mid-1;
            } else {
                si = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {3,4,5,6,7,0,1,2};
        System.out.println(piviot(arr));
    }
}
