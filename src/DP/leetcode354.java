package DP;

import javax.lang.model.element.ElementVisitor;
import java.util.Arrays;

public class leetcode354 {
    public class Envelope implements Comparable<Envelope> {
        int w;
        int h;
        public Envelope(int w, int h) {
            this.w = w;
            this.h = h;
        }
        @Override
        public int compareTo(Envelope e) {
            if(this.w == e.w) return e.h - this.h;
            return  this.w - e.w;
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
            int n = envelopes.length;
            Envelope[] arr = new Envelope[n];
        for (int i = 0; i < n; i++) {
            int w = envelopes[i][0];
            int h = envelopes[i][i];
            arr[i] = new Envelope(w,h);
        }

        Arrays.sort(arr);
        // LIS
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j].h < arr[i].h){
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            dp[i] += 1;
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
