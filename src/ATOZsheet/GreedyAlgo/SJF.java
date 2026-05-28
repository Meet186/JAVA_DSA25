package ATOZsheet.GreedyAlgo;

import java.util.Arrays;

public class SJF {
    public int SJFShedulingAvg(int[] arr){
        Arrays.sort(arr);
        int t = 0;
        int w_t = 0;
        for (int i = 0; i < arr.length; i++) {
            w_t += t;
            t+=arr[i];
        }
        return w_t/arr.length;
    }
}
