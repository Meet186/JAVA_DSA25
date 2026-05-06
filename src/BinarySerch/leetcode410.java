package BinarySerch;

public class leetcode410 {
    private int helper(int[] arr,int mid){
        int parts = 1;
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            if(sum + arr[i] <= mid){
                sum += arr[i];
            } else {
                sum = arr[i];
                parts++;
            }
        }
        return parts;
    }
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int max = -1;
        for(int el : nums){
            if(max < el){
                max = el;
            }
            sum += el;
        }
        int si = max;
        int ei = sum;
        while (si <= ei){
            int mid = si + (ei-si)/2;
            int parts = helper(nums,mid);
            if(parts > k) si = mid + 1;
            else ei = mid-1;
        }

        return si;
    }
}
