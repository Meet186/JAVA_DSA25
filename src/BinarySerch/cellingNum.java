package BinarySerch;

public class cellingNum {
    static int celllingNum(int arr[],int target){

        if(target > arr[arr.length-1]) return -1;

        int si = 0;
        int ei = arr.length-1;
        while (si <= ei){
            int mid = si + (ei-si)/2;
            if(arr[mid] == target) return arr[mid];
            else if (arr[mid] > target) {
                ei = mid-1;
            } else {
                si = mid + 1;
            }
        }
        return arr[si];
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,5,14,16,18};
        System.out.println(celllingNum(arr,6));
    }
}
