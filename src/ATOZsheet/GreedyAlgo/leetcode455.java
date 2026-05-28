package ATOZsheet.GreedyAlgo;

import java.util.Arrays;

public class leetcode455 {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0; // child
        int j = 0; // cookie

        while (i < g.length && j < s.length) {

            // cookie can satisfy child
            if (s[j] >= g[i]) {
                i++;
            }

            j++;
        }

        return i;
    }
}
