package DP.knapsack;

public class maxProfit {
    static int maxProfit(int index,int[] weight,int[] profit,int C){
        if(index == weight.length) return 0;
        int skip = maxProfit(index + 1, weight, profit, C);
        if(weight[index] > C) return skip;
        int take = profit[index] + maxProfit(index + 1, weight, profit, C-weight[index]);
        return Math.max(skip,take);


    }
    static void main() {
        int[] weight = {1,2,8,10};
        int[] profit = {5,3,9,16};
        int C = 8;
        maxProfit(0,weight,profit,C);
    }
}
