package ATOZsheet.SlidingWindow;

public class leetcode1358 {
    static int countSubstring(String str) {
        int[] lastSeen = {-1, -1, -1}; // a, b, c
        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            lastSeen[str.charAt(i) - 'a'] = i;

            if (lastSeen[0] != -1 &&
                    lastSeen[1] != -1 &&
                    lastSeen[2] != -1) {

                count += 1 + Math.min(lastSeen[0],
                        Math.min(lastSeen[1], lastSeen[2]));
            }
        }

        return count;
    }
    public static void main(String[] args) {

    }
}
