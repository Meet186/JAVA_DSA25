package BinarySerch;

public class floorNum {

    static int floorNum(int arr[],int target){
        if(target < arr[0]) return -1;
        int si = 0;
        int ei = arr.length-1;
        while (si <= ei){
            int mid = si + (ei-si)/2;
            if(arr[mid] == target) return arr[mid];
            else if (arr[mid] < target) {
                si = mid+1;
            } else {
               ei = mid-1;
            }
        }
        return arr[ei];

    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,5,14,16,18};
        System.out.println(floorNum(arr,17));
    }
}
