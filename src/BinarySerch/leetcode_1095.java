package BinarySerch;
// https://leetcode.com/problems/find-in-mountain-array/
public class leetcode_1095 {
    static int peak(int[] mountainArr){
        int l = 0;
        int r = mountainArr.length-1;

        while(l < r){
            int mid = l + (r-l)/2;
            if(mountainArr[mid] > mountainArr[mid+1]){ // we are in decreasing part
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    static int binarySerch(int arr[],int target,int start,int end){
        boolean check = arr[start]< arr[end];
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(check){
                if(arr[mid]>target){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else{
                if(arr[mid]<target){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }

        }
        return -1;
    }

    static int findInMountainArray(int target, int[] mountainArr) {
        int peak_El = peak(mountainArr);
        int first_Try = binarySerch(mountainArr,target,0,peak_El);
        if(first_Try != -1){
            return first_Try;
        }
        return binarySerch(mountainArr,target,peak_El+1,mountainArr.length-1);
    }

    public static void main(String[] args) {
        leetcode_1095 obj = new leetcode_1095();
        int[] arr = {0,1,2,4,2,1};
        System.out.println(findInMountainArray(3,arr));
    }
}
