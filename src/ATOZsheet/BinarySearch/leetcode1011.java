package ATOZsheet.BinarySearch;

public class leetcode1011 {
    private int find_Capacity(int[] arr, int capacity) {
        int days = 1;
        int curr_Capacity = 0;

        for (int i = 0; i < arr.length; i++) {
            if (curr_Capacity + arr[i] > capacity) {
                days++;
                curr_Capacity = arr[i];
            } else {
                curr_Capacity += arr[i];
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int max = 0, sum = 0;

        for (int num : weights) {
            max = Math.max(max, num);
            sum += num;
        }

        int si = max;
        int ei = sum;
        int ans = -1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            int requiredDays = find_Capacity(weights, mid);

            if (requiredDays <= days) {
                ans = mid;
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        return ans;
    }
}
