package ATOZsheet.SlidingWindow;

import java.util.HashMap;

public class fruitsInBucket {

    public static int totalFruits(int[] fruits) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int l = 0;
        int maxLen = 0;

        for (int r = 0; r < fruits.length; r++) {

            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            // more than 2 fruit types
            while (map.size() > 2) {

                map.put(fruits[l], map.get(fruits[l]) - 1);

                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }

                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 2, 2};

        System.out.println(totalFruits(arr)); // 4
    }
}