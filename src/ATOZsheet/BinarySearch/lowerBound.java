package ATOZsheet.BinarySearch;

public class lowerBound {
    static int findLowerBound(int[] arr,int k){
        int si = 0;
        int ei = arr.length-1;
        int lowerBound = -1;
        while (si <= ei){
            int mid = si + (ei-si)/2;
            if(arr[mid] == k){
                lowerBound = mid;
                ei = mid-1;
            } else if (arr[mid] > k) {
                ei = mid-1;
            } else {
                si  = mid + 1;
            }
        }
        return lowerBound;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,5};
        System.out.println(findLowerBound(arr,2));
    }
}
