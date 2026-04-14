package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class MooreVotingElement {

    public int majorityElement(int[] nums) { // leetcode 169
        int el = 0;
        int count = 0;

        for(int i=0; i<nums.length; i++){
            if(count == 0){
                el = nums[i];
                count++;
            } else if (el == nums[i]){
                count++;
            } else {
                count--;
            }
        }
        return el;
    }

    public List<Integer> majorityElement2(int[] nums) { // leetcode 229
        int n = nums.length;

        int el1 = 0, el2 = 0;
        int cnt1 = 0, cnt2 = 0;

        // Step 1: Find candidates
        for (int num : nums) {
            if (cnt1 == 0 && num != el2) {
                el1 = num;
                cnt1 = 1;
            }
            else if (cnt2 == 0 && num != el1) {
                el2 = num;
                cnt2 = 1;
            }
            else if (num == el1) {
                cnt1++;
            }
            else if (num == el2) {
                cnt2++;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }

        // Step 2: Verify counts
        int f1 = 0, f2 = 0;
        for (int num : nums) {
            if (num == el1) f1++;
            else if (num == el2) f2++;
        }

        // Step 3: Add valid results
        List<Integer> ans = new ArrayList<>();
        if (f1 > n / 3) ans.add(el1);
        if (f2 > n / 3) ans.add(el2);

        return ans;
    }
}
