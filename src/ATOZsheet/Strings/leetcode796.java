package ATOZsheet.Strings;

public class leetcode796 {
    public boolean rotateString(String s, String goal) {
        int m = s.length();
        int n = goal.length();

        if(m == n && (s + s).contains(goal)) return true;
        return false;
    }
}
