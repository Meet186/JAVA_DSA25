package BinarySerch;

public class BookAlocation {
    public int findPages(int[] nums, int m) {
        int sum = 0;
        int max = -1;
        for(int el : nums){
            if(max < el){
                max = el;
            }
            sum += el;
        }
        int si = max;
        int ei = sum;
        while (si <= ei){
            int mid = si + (ei-si)/2;
            int noOfStudent = helper(nums,mid);
            if(noOfStudent > m) si = mid + 1;
            else ei = mid-1;
        }

        return si;
    }

    private int helper(int[] nums, int mid) {
        int students = 1;
        int pages = 0;
        for (int i = 0; i < nums.length; i++) {
            if(pages + nums[i] <= mid){
                pages += nums[i];
            } else {
                pages = nums[i];
                students++;
            }

        }
        return students;
    }
}
