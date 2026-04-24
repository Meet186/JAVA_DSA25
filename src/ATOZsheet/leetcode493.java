package ATOZsheet;

public class leetcode493 {
    public int reversePairs(int[] nums) {
        return mergeSort(nums);
    }
    public static int mergeSort(int[]arr){
        return  helper(arr,0,arr.length-1);
    }
    private static int helper(int[] arr, int si, int ei){
        int cnt = 0;
        if(si >= ei) return cnt;
        int mid = si + (ei-si)/2;
        cnt +=  helper(arr, si, mid);
        cnt +=   helper(arr, mid + 1, ei);
        cnt +=  countPair(arr,si,mid,ei);
        merge(arr,si,mid,ei);
        return cnt;
    }
    private static int countPair(int[] nums, int si, int mid, int ei){
        int right = mid+1;
        int cnt = 0;
        for (int i = si; i <= mid ; i++) {
            while (right <= ei && (long) nums[i] > 2 * (long) nums[right]){
                right++;
            }
            cnt += right - (mid+1);

        }
        return cnt;
    }
    private static void merge(int[] arr,int si,int mid,int ei){
        int[] left = new int[mid-si + 1];
        int[] right = new int[ei-mid];

        for(int i=0; i<left.length; i++){ // fill left array
            left[i] = arr[si + i];
        }
        for(int i=0; i<right.length; i++){ // fill right array
            right[i] = arr[mid + 1 + i];
        }
        int l = 0; // point to left array
        int r = 0; // point to right array
        int k = si; // point to indices every time
        while(l < left.length && r < right.length){
            if(left[l] < right[r]){
                arr[k++] = left[l];
                l++;
            } else {
                arr[k++] = right[r];
                r++;
            }
        }

        while (l < left.length){
            arr[k++] = left[l];
            l++;
        }

        while (r < right.length){
            arr[k++] = right[r];
            r++;
        }

    }
}
