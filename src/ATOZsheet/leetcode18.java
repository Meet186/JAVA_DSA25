package ATOZsheet;

import java.util.*;

public class leetcode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i+1; j <n ; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j+1;
                int l = n-1;
                while (k < l){
                    List<Integer> temp = new ArrayList<>();
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target) {
                        temp.addAll(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        set.add(temp);
                        k++;
                        l--;
                    }
                    if(sum > target){
                        l--;
                    } else {
                        k++;
                    }

                }

            }

        }
        return new ArrayList<>(set);
    }
}
