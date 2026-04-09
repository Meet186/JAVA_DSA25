package HEAP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class leetcode56 {
   static class pair implements Comparable<pair> {

        int first;
        int second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(pair o) {
            return this.first - o.second;
        }
    }
    public static int[][] merge(int[][] intervals) {
        PriorityQueue<pair> queue = new PriorityQueue<>();

        // push all intervals
        for (int[] interval : intervals) {
            queue.offer(new pair(interval[0], interval[1]));
        }

        List<int[]> result = new ArrayList<>();

        pair current = queue.poll();

        while (!queue.isEmpty()) {
            pair next = queue.poll();

            if (current.second >= next.first) {
                // merge
                current.second = Math.max(current.second, next.second);
            } else {
                result.add(new int[]{current.first, current.second});
                current = next;
            }
        }


        result.add(new int[]{current.first, current.second});


        int[][] ans = new int[result.size()][2];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{4, 7}, {1, 4}};
//        merge(arr);

    }
}
