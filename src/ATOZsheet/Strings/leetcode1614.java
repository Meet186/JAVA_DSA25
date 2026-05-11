package ATOZsheet.Strings;

public class leetcode1614 {
    public int maxDepth(String s) {
        int count = 0;
        int ans = Integer.MIN_VALUE;
        for(var ch : s.toCharArray()){
            if(ch == '('){
                count++;
            } else if (ch == ')'){
                count--;
            }
            ans = Math.max(count,ans);
        }
        return ans;
    }
}
