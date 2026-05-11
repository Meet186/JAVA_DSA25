package ATOZsheet.Strings;

public class leetcode1781 {
    public int beautySum(String s) {
        int ans = 0;
        // generate all substring
        for(int i=0; i<s.length(); i++){
            // make count of every substring every time to find beauty string
            int[] freq = new int[26];
            for(int j=i; j<s.length(); j++){
                char ch = s.charAt(j);
                freq[ch-'a']++;
                // find max and fin freq character
                int max=Integer.MIN_VALUE;
                int min=Integer.MAX_VALUE;
                // iterate over freq array
                for(int k=0; k<26; k++){
                    if(freq[k] != 0){
                        max = Math.max(max,freq[k]);
                        min = Math.min(min,freq[k]);
                    }
                }
                ans += (max-min);
            }

        }

        return ans;
    }
}
