package ATOZsheet.SlidingWindow;

import java.util.HashMap;

public class leetcode992 {
    private int atMostK(int[] nums, int k) {
        int l = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int r = 0; r < nums.length; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }

            count += (r - l + 1);
        }

        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
}
