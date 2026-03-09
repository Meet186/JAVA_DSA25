import java.utils.*;
 public class maxprofit {
    static int maxProfit(iint index,int[] weight,int[] profit,int C){
        if(index == weight.length) return 0;
        int skip = maxProfit(index + 1, weight, profit, C);
        if(weight[i] > C) return skip;
        int take = profit[i] + maxProfit(index + 1, weight, profit, C-weight[i]);
        return Math.max(skip,pick);
        

    }
    static void main() {
        int[] weight = {1,2,8,10};
        int[] profit = {5,3,9,16};
        int C = 8;
        maxProfit(0,weight,profit,C);
    }
}