package ATOZsheet.BinarySearch;

public class howManyTimeArrayRotated {
    static int find(int[] nums){
        int ans = Integer.MAX_VALUE;
        int si = 0;
        int ei = nums.length-1;
        int idx = -1;
        while(si <= ei){
            int mid = si + (ei-si)/2;

            if(nums[si] <= nums[mid]){

                if(nums[si] < ans){
                    ans = nums[si];
                    idx = si;

                }
                si = mid + 1;

            } else {
                if(nums[mid] < ans){
                    ans = nums[mid];
                    idx = mid;
                }
                ei = mid - 1;
            }
        }
        return idx;
    }
}
