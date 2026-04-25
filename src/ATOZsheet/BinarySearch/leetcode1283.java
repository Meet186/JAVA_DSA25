package ATOZsheet.BinarySearch;

public class leetcode1283 {

    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for (int el : nums) {
            max = Math.max(max, el);
        }
        int si = 1;
        int ei = max;
        int ans = -1;
        while (si <= ei){
            int mid = si + (ei-si)/2;
            int sum = 0;
            for (int el : nums) {
                sum += (el + mid - 1) / mid;
            }
            if(sum <= threshold){
                ans = mid;
                ei = mid-1;
            } else {
                si = mid + 1;
            }
        }


        return ans;
    }
}
