import java.util.Arrays;
import java.util.HashSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int[] applyOperations(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                nums[i] *= 2;
                nums[i+1] = 0;
            } else {
                continue;
            }
        }

        int idx = 0;
        for(int i=0; i < nums.length; i++){
            if(nums[i] != 0) ans[idx++] = nums[i];
        }

        return ans;

    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4};



    }
}