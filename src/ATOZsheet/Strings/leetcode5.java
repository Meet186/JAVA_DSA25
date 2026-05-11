package ATOZsheet.Strings;

public class leetcode5 {
    public static boolean ispalindrome(String str,int i,int j){
        if(i >= j) return true;
        return str.charAt(i) == str.charAt(j) && ispalindrome(str,i+1,j-1);
    }
    public String longestPalindrome(String s) {
        int maxLen = 1;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                String str = s.substring(j,i+1);
                if(ispalindrome(str,0,str.length()-1)){
                    if(str.length() >= maxLen){
                        ans = str;
                        maxLen = str.length();
                    }
                }

            }

        }
        return ans;
    }

    public static void main(String[] args) {
        String ans = "appleel";
        System.out.println(ispalindrome(ans,0,ans.length()-1));
    }
}
