package recurssion;

import java.util.ArrayList;
import java.util.List;

public class level2Array {
    static boolean isSorted(int[] arr,int index){
        if(index == arr.length-1) return true; // Base Case
        return arr[index] < arr[index + 1] && isSorted(arr, index + 1);
    }
    static int findTarget(int[] arr,int target){
        return helper(arr,target,0);
    }

    private static int helper(int[] arr, int target, int index) {
        if(index == arr.length) return -1;
        return arr[index] == target ? index : helper(arr,target,index+1);
    }

    static List<Integer> findAllIndex(int[] arr, int target, int index,List<Integer> list){
        if(index == arr.length) return list;
        if(arr[index] == target) list.add(index);
        return findAllIndex(arr, target, index+1, list);
    }
    static List<Integer> findAllIndex2(int[] arr, int target, int index){
        List<Integer> list = new ArrayList<>();
        if(index == arr.length) return list;
        // Contain only its function call ans
        if(arr[index] == target){
            list.add(index);
        }
        List<Integer> allAnsBelow = findAllIndex2(arr, target, index+1);
        list.addAll(allAnsBelow);
        return list;
    }
    static int serchInRotatedArray(int[] arr,int target,int s , int e){
        if(s > e){
            return -1;
        }
        int m = s + (e-s)/2;
        if(arr[m] == target) return m;
        if(arr[s] <= arr[m]){
            if(target >= arr[s] && target <= arr[m]){
                return serchInRotatedArray(arr, target, s, m-1);
            } else {
                return serchInRotatedArray(arr, target, m+1, e);
            }
        }
        if(target >= arr[m] && target <= arr[e]){
            return serchInRotatedArray(arr, target, m+1, e);
        }
        return serchInRotatedArray(arr, target, s, m+1);
    }
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,1,2,3};
        System.out.println(serchInRotatedArray(arr,3,0,arr.length-1));
    }
}
