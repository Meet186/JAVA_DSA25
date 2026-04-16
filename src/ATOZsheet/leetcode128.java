package ATOZsheet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class leetcode128 {
    class Solution {
        public int longestConsecutive(int[] nums) {
            if(nums.length == 0 ) return 0;
            Arrays.sort(nums);
            int longest = 1;
            int count = 0;
            int lastSmall = Integer.MIN_VALUE;
            for(int i=0; i<nums.length; i++){
                if(nums[i]-1 == lastSmall){
                    count += 1;
                    lastSmall = nums[i];
                } else if (lastSmall != nums[i]) {
                    count = 1;
                    lastSmall = nums[i];
                }
                longest = Math.max(count,longest);
            }
            return longest;
        }
        public int longestConsecutive2(int[] nums) {
            if(nums.length == 0 ) return 0;
            Set<Integer> set = new HashSet<>();
            for(int num : nums) set.add(num);
            int maxStreak = 0;
            for(int num : nums){
                if(!set.contains(num-1)){
                    int currStreak = 1;
                    int currNum = num;
                    while (set.contains(currNum + 1)){
                        currNum++;
                        currStreak++;
                    }
                    maxStreak = Math.max(maxStreak,currStreak);
                }
            }
            return maxStreak;
        }
    }
}
