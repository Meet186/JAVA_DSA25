package ATOZsheet.BinarySearch;

public class leetcode33 {
    public int search(int[] nums, int target) {
        int si = 0;
        int ei = nums.length-1;
        while (si <= ei){
            int mid = si + (ei-si)/2;
            if(nums[mid] == target) return mid;
            else if (nums[si] <= nums[mid]) {
                if(target <= nums[si] && target <= nums[mid]){
                    si = mid + 1;
                } else {
                    ei = mid - 1;

                }
            } else {
                if(target <= nums[ei] && target <= nums[mid]){
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            }

        }
        return si;
    }
}
