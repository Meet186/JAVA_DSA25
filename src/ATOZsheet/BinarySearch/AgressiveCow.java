package ATOZsheet.BinarySearch;

import java.util.Arrays;

public class AgressiveCow {
    public int placeCowAtMaxDistance(int[] arr,int cows){
        Arrays.sort(arr);

        int low = 1;
        int high = arr[arr.length - 1] - arr[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (ispossible(arr, mid, cows)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    private boolean ispossible(int[] arr,int distance ,int cows){
        int cowCount = 1;
        int lastCow = arr[0];
        for (int i = 1; i < arr.length ; i++) {
            if(arr[i] - lastCow >= distance){
                cowCount++;
                lastCow = arr[i];
            }
        }
        if(cowCount >= cows) return true;
        return false;
    }
    public static void main(String[] args) {

    }
}
