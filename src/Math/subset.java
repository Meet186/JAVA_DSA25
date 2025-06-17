package Math;
import java.util.ArrayList;
import java.util.List;
public class subset {
    static List<List<Integer>> subset(int[] arr){
        // TC - O(N * 2^N)
        // SC - O(2^N * N) Approx
        int n = arr.length;
        int totalSubsets = 1 << n;  // 2^n subsets
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> set = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    set.add(arr[j]);  // Use arr[j], not arr[i]
                }
            }
            ans.add(set);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> ans = subset(arr);
        System.out.println(ans);
    }
}
