package ATOZsheet.BinarySearch;

public class leetcode162 {
    public int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            int mid = start + (end-start)/2;
            if(arr[mid] > arr[mid+1]){
                // mean we are in decreasing part.
                // May possible mid will ans or lie in left part
                // that's why end is != mid + 1;
                end = mid;
            } else if (arr[mid] < arr[mid + 1]){
                // ans will lie in right part
                start = mid + 1;
            }
        }
        // return any start/end {lie at same index}
        return start;
    }
}

