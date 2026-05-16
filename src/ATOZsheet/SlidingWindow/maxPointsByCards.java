package ATOZsheet.SlidingWindow;

public class maxPointsByCards {
    static int maxPoints(int[] arr,int k){
        int lsum = 0;
        int rsum = 0;
        int maxSum = 0;

        for (int i = 0; i < k-1; i++) {
            lsum += arr[i];
        }
        maxSum = lsum;
        int left = 0;
        for (int i = arr.length-1; i >= k ; i--) {
            lsum -= arr[left];
            left++;
            rsum += arr[i];
            maxSum = Math.max(maxSum,lsum+rsum);
        }
        return maxSum;
    }
}
