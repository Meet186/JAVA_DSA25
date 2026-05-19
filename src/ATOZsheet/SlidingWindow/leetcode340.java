package ATOZsheet.SlidingWindow;

import java.util.HashMap;

public class leetcode340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0;
        int maxLen = 0;

        for (int r = 0; r < s.length(); r++) {

            char ch = s.charAt(r);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // shrink window
            while (map.size() > k) {

                char leftChar = s.charAt(l);

                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
