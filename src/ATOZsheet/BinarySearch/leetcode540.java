package ATOZsheet.BinarySearch;

public class leetcode540 {
    public int singleNonDuplicate(int[] nums) {
        int si = 0, ei = nums.length - 1;

        while (si < ei) {
            int mid = si + (ei - si) / 2;

            // make mid even
            if (mid % 2 == 1) mid--;

            if (nums[mid] == nums[mid + 1]) {
                si = mid + 2;
            } else {
                ei = mid;
            }
        }

        return nums[si];
    }
}
