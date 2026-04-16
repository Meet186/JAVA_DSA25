package ATOZsheet;

import java.util.ArrayList;
import java.util.List;

public class leedersInArray {
    public static List<Integer> leaders(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i= nums.length-1; i >= 0;  i--){
            if(nums[i] > max){
                max = nums[i];
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-3, 4, 5, 1, -4, -5};
        List<Integer> ans = leaders(arr);
        System.out.println(ans);
    }
}
