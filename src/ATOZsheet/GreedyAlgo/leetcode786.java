package ATOZsheet.GreedyAlgo;

public class leetcode786 {
    private Boolean[][] dp;

//    private boolean fn(String s, int idx, int cnt) {
//        if (cnt < 0) return false;

//        if (idx == s.length()) {
//            return cnt == 0;
//        }
//
//        if (dp[idx][cnt] != null) {
//            return dp[idx][cnt];
//        }
//
//        boolean ans;
//
//        if (s.charAt(idx) == '(') {
//            ans = fn(s, idx + 1, cnt + 1);
//        }
//        else if (s.charAt(idx) == ')') {
//            ans = fn(s, idx + 1, cnt - 1);
//        }
//        else {
//            ans = fn(s, idx + 1, cnt + 1)
//                    || fn(s, idx + 1, cnt - 1)
//                    || fn(s, idx + 1, cnt);
//        }
//
//        return dp[idx][cnt] = ans;
//    }
//
//    public boolean checkValidString(String s) {
//        int n = s.length();
//        dp = new Boolean[n][n + 1];
//        return fn(s, 0, 0);
//    }

    public boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0) return false;
            if (leftMin < 0) leftMin = 0;
        }

        return leftMin == 0;
    }
}
