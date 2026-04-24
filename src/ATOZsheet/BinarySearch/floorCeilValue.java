package ATOZsheet.BinarySearch;

public class floorCeilValue {
    static void findFloorCeilValue(int[] nums,int target){
        int si = 0;
        int ei = nums.length - 1;
        int floor = -1;
        int ceil = -1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (nums[mid] == target) {
                floor = nums[mid];
                ceil = nums[mid];
                break;
            }
            else if (nums[mid] > target) {
                ceil = nums[mid];   // possible ceil
                ei = mid - 1;
            }
            else {
                floor = nums[mid];  // possible floor
                si = mid + 1;
            }
        }

        System.out.println("Floor: " + floor);
        System.out.println("Ceil: " + ceil);


    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        findFloorCeilValue(arr,5);
    }
}
