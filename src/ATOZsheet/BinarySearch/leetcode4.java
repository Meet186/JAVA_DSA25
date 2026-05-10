package ATOZsheet.BinarySearch;

public class leetcode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[m+n];
        int i = 0; // point to nums1
        int j = 0; // points to nums2
        int idx = 0; // point to ans array index
        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                ans[idx++] = nums1[i++];
            } else {
                ans[idx++] = nums2[j++];
            }
        }

        while (i < m){
            ans[idx++] = nums1[i++];
        }
        while (j < n){
            ans[idx++] = nums2[j++];
        }
        int len = ans.length;
        // even mean 2 mid point median
        if(len % 2 == 0) return ans[len / 2] + ans[len - 1 / 2];
        return ans[len/2];

    }
}
