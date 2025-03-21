package BinarySerch;

public class leetcode_33 {
    static int piviot(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(mid < end && arr[mid] > arr[mid + 1]) return mid;
            if(mid > start && arr[mid] < arr[mid-1]) return mid-1;
            if(arr[mid] <= arr[start]){
                end = mid-1;
            } else {
                start = mid + 1;

            }
        }
        return -1;
    }

    static int binarySerchInRange(int[] arr, int target,int start,int end){
        while (start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target) return mid;
            else if (arr[mid] > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }
    static int search(int[] nums, int target) {
        int piviot = piviot(nums);
        int first_Try = binarySerchInRange(nums,target,0,piviot);
        if(first_Try != -1){
            return first_Try;
        }
        return binarySerchInRange(nums,target,piviot+1,nums.length-1);
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr,0));
    }
}
