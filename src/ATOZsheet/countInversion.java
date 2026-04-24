package ATOZsheet;

public class countInversion {
    public long numberOfInversions(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private long helper(int[] nums, int si, int ei) {
        long count = 0;
        if (si >= ei) return count;

        int mid = si + (ei - si) / 2;

        count += helper(nums, si, mid);
        count += helper(nums, mid + 1, ei);
        count += merge(nums, si, mid, ei);

        return count;
    }

    private long merge(int[] nums, int si, int mid, int ei) {
        long count = 0;

        int length1 = mid - si + 1;
        int length2 = ei - mid;

        int[] left = new int[length1];
        int[] right = new int[length2];

        for (int i = 0; i < length1; i++) {
            left[i] = nums[si + i];
        }
        for (int i = 0; i < length2; i++) {
            right[i] = nums[mid + 1 + i];
        }

        int l = 0, m = 0, k = si;

        while (l < length1 && m < length2) {
            if (left[l] <= right[m]) {
                nums[k++] = left[l++];
            } else {
                count += (length1 - l);
                nums[k++] = right[m++];
            }
        }

        while (l < length1) {
            nums[k++] = left[l++];
        }
        while (m < length2) {
            nums[k++] = right[m++];
        }

        return count;
    }

    public static void main(String[] args) {
        countInversion obj = new countInversion();
        int[] nums = {2, 3, 7, 1, 3, 5};
        System.out.println(obj.numberOfInversions(nums));
    }
}