public class matrixChainMultiplication {

    public static int mcm(int i,int j,int[][] arr){
        if(i == j) return 0;
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int x = arr[i][0] * arr[j][1] * arr[k][0];
            int totalCost = mcm(i,k,arr) + mcm(k+1,j,arr) + x;
            minCost = Math.min(minCost,totalCost);
        }
        return minCost;
    }


    public static void main(String[] args) {
        int[][] arr = {{1,2},{2,3},{3,4},{4,5}};
        System.out.println(mcm(0, arr.length-1,arr));
    }
}
