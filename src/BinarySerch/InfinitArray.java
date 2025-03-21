package BinarySerch;
// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/#finding-bound-and-then-binary-search-ologk-time-and-o1-space
public class InfinitArray {


    static int findRange(int[] arr,int target){
        int start = 0;
        int end = 1;
        while (target > arr[end]){
            int newstart = end + 1;
            end = end + (end-start+1) * 2;
            start = newstart;
        }
        return binarySerch(arr,target,start,end);

    }
    static int binarySerch(int[] arr, int target,int start,int end){
        while (start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] < target){
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid-1;
            } else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,7,8,9,10,12,14,15,78,79,80,91,100,110,220,300};
        System.out.println(findRange(arr,100));
    }
}
