package ATOZsheet.BinarySearch;

public class leetcode875 {
    public int BruteForce(int[] piles, int h) {
        int max = 0;
        for (int el : piles) {
            if (el > max) {
                max = el;
            }
        }

        for (int i = 1; i <= max; i++) {
            int hours_take = 0;

            for (int j = 0; j < piles.length; j++) {

                hours_take += (piles[j] + i - 1) / i;


                if (hours_take > h) break;
            }


            if (hours_take <= h) return i;
        }

        return -1;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int el : piles) {
            if (el > max) {
                max = el;
            }
        }

        int ans = -1;
        int si = 1;
        int ei = max;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            long hours_take = 0;

            for (int el : piles) {
                hours_take += (el + mid - 1) / mid;


                if (hours_take > h) break;
            }
            if (hours_take <= h) {
                ans = mid;
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        return ans;
    }
}
