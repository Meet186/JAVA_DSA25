package ATOZsheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a, b)-> a[0]-b[0]);
        List<int[]> ans = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length ; i++) {
            if(current[1] >= intervals[i][0]){
                current[1] = Math.max(current[1],intervals[i][1]);
            } else {
                ans.add(current);
                current = intervals[i];
            }
        }
        ans.add(current);
        return ans.toArray(new int[ans.size()][]);

    }
}
