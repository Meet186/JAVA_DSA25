package ATOZsheet.BinarySearch;

public class UpperBound {
    static int findUpperBound(int[] arr , int k){
        int si = 0;
        int ei = arr.length-1;
        int upperBound = -1;
        while (si <= ei){
            int mid = si + (ei-si)/2;
            if(arr[mid] == k){
                upperBound = mid;
                si = mid+1;
            } else if (arr[mid] > k) {
                ei = mid-1;
            } else {
                si  = mid + 1;
            }
        }
        return upperBound;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,5,8};
        System.out.println(findUpperBound(arr,3));
    }
}
