package ATOZsheet.BinarySearch;

public class leetcode81 {
    public boolean search(int[] nums, int target) {
        int si = 0;
        int ei = nums.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (nums[mid] == target) return true;

            // handle duplicates
            if (nums[si] == nums[mid] && nums[mid] == nums[ei]) {
                si++;
                ei--;
                continue;
            }

            // left half sorted
            if (nums[si] <= nums[mid]) {
                if (nums[si] <= target && target < nums[mid]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            }
            // right half sorted
            else {
                if (nums[mid] < target && target <= nums[ei]) {
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            }
        }

        return false;
    }
}
