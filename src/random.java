import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class random {

    public String getHappyString(int n, int k) {
            String ans = "";
            List<String> result = new ArrayList<>();
            solve(ans,result,n);
            if(result.size() < k) return "";
            return result.get(k - 1);
    }
    private void  solve(String curr,List<String> result,int n){
        if(curr.length() == n){
            result.add(curr);
            return;
        }
        // try all possible combination for happy String abc
        for (int i = 'a'; i <= 'c' ; i++) {
            if( !curr.isEmpty() && curr.charAt(i) == curr.charAt(i)) continue; // for lexicographical order
            curr += i;
            solve(curr,result,n);
        }
    }

}
