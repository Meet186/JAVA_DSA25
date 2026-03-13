package DP.knapsack;

public class subsetTarget {

    static boolean isTagertExist(int[] arr,int target){
        return helper(0,arr,target);
    }

    private static boolean helper(int i, int[] arr, int target) {
       if(i == arr.length){
           if(target == 0) return true;
           return false;
       }
       boolean pick = helper(i+1 ,arr,target-arr[i]);
       boolean skip = helper(i+1,arr,target);
       return  pick || skip;

    }

    public static void main(String[] args) {
        int[] arr = {1,8,5,3,4,7};
        int target = 88;
        System.out.println(isTagertExist(arr,target));
    }
}
