package HASHMAP;

import java.util.HashMap;
import java.util.Map;

public class leetcode169 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
               int val = map.get(nums[i]);
               val += 1;
               map.put(nums[i],val);
            } else {
                map.put(nums[i],1);
            }
        }

        for(int key : map.keySet()){
           if(map.get(key) > n/2 ){
               return key;
           }
        }

        return -1;

    }
}
