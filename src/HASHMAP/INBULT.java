package HASHMAP;

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

        System.out.println(map);
        return 1;
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


    }
}
