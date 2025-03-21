package BinarySerch;
public class findtarget {
    static int findTarget(int arr[],int target){
        int si = 0;
        int ei = arr.length-1;
        boolean isAssinding = (si < ei) ? true : false;
        if(isAssinding){
            while (si <= ei){
                int mid = si + (ei-si)/2;
                if(arr[mid] == target) return mid;
                else if (arr[mid] < target) {
                    ei = mid-1;
                } else {
                    si = mid + 1;
                }
            }
        } else {
            while (si <= ei){
                int mid = si + (ei-si)/2;
                if(arr[mid] == target) return mid;
                else if (arr[mid] > target) {
                    si = mid + 1;
                } else {
                    ei = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr [] = {9,8,7,5,4,3,2,1};
        System.out.println(findTarget(arr,4));
    }
}
