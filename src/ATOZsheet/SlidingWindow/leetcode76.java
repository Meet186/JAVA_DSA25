package ATOZsheet.SlidingWindow;

public class leetcode76 {
    public String minWindow(String s, String t) {

        int[] hash = new int[256];

        // store frequency of characters of t
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]++;
        }

        int l = 0, r = 0;
        int count = 0;

        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        while (r < s.length()) {

            char ch = s.charAt(r);

            // useful character found
            if (hash[ch] > 0) {
                count++;
            }

            hash[ch]--;

            // all characters matched
            while (count == t.length()) {

                // update answer
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    startIndex = l;
                }

                // try shrinking window
                hash[s.charAt(l)]++;

                if (hash[s.charAt(l)] > 0) {
                    count--;
                }

                l++;
            }

            r++;
        }

        return startIndex == -1
                ? ""
                : s.substring(startIndex, startIndex + minLen);
    }
}
