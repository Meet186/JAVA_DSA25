package ATOZsheet.SlidingWindow;

import java.util.HashMap;

public class leetcode3 {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0;
        int maxLen = 0;

        for (int r = 0; r < s.length(); r++) {

            char ch = s.charAt(r);

            // duplicate found
            if (map.containsKey(ch)) {
                l = Math.max(l, map.get(ch) + 1);
            }

            map.put(ch, r);

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
