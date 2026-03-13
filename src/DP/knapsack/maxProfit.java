package DP.knapsack;

public class maxProfit {
    static int maxProfit(int index,int[] weight,int[] price,int C){
     if(index == weight.length) return 0;
     int skip = maxProfit(index + 1, weight, price, C);
     if(weight[index] > C) return skip;
     int take = price[index] + maxProfit(index + 1, weight, price, C);
     return Math.max(skip,take);
    }
    public static void main(String[] args) {
        int[] weight = {1,2,8,10};
        int[] profit = {5,3,9,16};
        int C = 8;
        System.out.println(maxProfit(0,weight,profit,C));
    }
}
