package BinarySerch;
//https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
public class leetcode_852 {
    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        int ans = -1;

        while (start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) return mid;
            else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {0,2,1,0};
        System.out.println(peakIndexInMountainArray(arr));
    }
}
