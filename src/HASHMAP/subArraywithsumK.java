package HASHMAP;

import java.util.ArrayList;
import java.util.HashMap;

public class subArraywithsumK {

    static ArrayList<Integer> subarraySum(int[] arr, int target) {
    ArrayList<Integer> ans = new ArrayList<>();
    ans.add(-1);
    HashMap<Integer,Integer> map = new HashMap<>();
    int sum = 0;
    map.put(sum,-1);
    for(int i=0; i<arr.length; i++){
        sum += arr[i];
        int val = sum - target;
        if(map.containsKey(val)){
            int statrtIndex = map.get(val) + 1;
            ans.set(0,statrtIndex + 1);
            ans.add(1,i+1 + 1);
            break;
        } else {
            map.put(sum,i);
        }
    }
     return ans ;

    }

    public static void main(String[] args) {

    }
}
