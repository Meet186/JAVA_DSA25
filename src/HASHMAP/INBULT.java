package HASHMAP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class INBULT {
    static int mostFrequentEl(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(var el : arr){
            if(!map.containsKey(el)){
                map.put(el,1);
            } else {
                map.put(el,map.get(el) + 1);
            }
        }
        int ans = 0;
        int key = -1;
        for(var el : map.entrySet()){
            if(el.getValue() > ans){
                ans = el.getValue();
                key = el.getKey();
            }
        }
        return key;
    }

    static int mostcomeELCount(int[] arr){
        int[] freq = new int[10];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }
        int max = 0;
        for (int i = 0; i < 10; i++) {
            max = Math.max(max,freq[i]);

        }
        return max;
    }
    public static void main(String[] args) {
        // Q -> Create a HashMap class to stor the following pairs (person,Age) and display them.
        // INPUT -> Akash 21 , Yash 16, Lav 17 , Harray 18
        // OUTPUT -> Age of Akash is 21,.......
//        Map<String,Integer> map = new HashMap<>();
//        map.put("Akash",21);
//        map.put("Yash",16);
//        map.put("Lav",17);
//        map.put("Harray",18);
//
//        // Traverse the Map
//        for(Map.Entry<String,Integer> e : map.entrySet()){
//            System.out.printf("Age of %S is %d",e.getKey(),e.getValue());
//            System.out.println();
//        }
//        // Other way
//        for(String key : map.keySet()){
//            System.out.printf("Age of %s is %d",key,map.get(key));
//            System.out.println();
//        }

        int[] arr = {1,1,1,2,2,4,5,8,9};
//        mostFrequentEl(arr);
        System.out.println(mostFrequentEl(arr));
    }
}
