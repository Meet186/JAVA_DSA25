package BinarySerch;
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/1569982073/
public class leetcode_34 {
    public int serch(int[] arr,int target, boolean findFirstIndex){
        int si = 0;
        int ei = arr.length-1;
        int ans = -1;
        while(si <= ei){
            int mid = si + (ei-si)/2;
            if(arr[mid] < target){
                si = mid + 1;
            } else if (arr[mid] > target){
                ei = mid-1;
            } else {
                ans = mid;
                if(findFirstIndex){
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int start = serch(nums,target,true);
        int end = serch(nums,target,false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }
    public static void main(String[] args) {

    }
}
