package ATOZsheet.BinarySearch;

public class leetcode1482 {

    private boolean ispossible(int[] bloomDay,int day,int m,int k){
        int count = 0;
        int noOfBlooms = 0;
        for(int i=0; i< bloomDay.length; i++){
            if(bloomDay[i] <= day){
                count++;
            } else {
                noOfBlooms += count/k;
                count = 0;
            }
        }
        noOfBlooms += count/k;
        return noOfBlooms >= m;
    }
    public int BruteForce(int[] bloomDay, int m, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int el : bloomDay){
            if(el > max) max = el;
            if(el < min) min = el;
        }

        for (int i = min; i <= max ; i++) {
            if(ispossible(bloomDay,i,m,k)) return i;
        }

        return -1;

    }
    public int minDays(int[] bloomDay, int m, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int el : bloomDay){
            if(el > max) max = el;
            if(el < min) min = el;
        }

        int si = min;
        int ei = max;
        int ans = -1;
        while(si <= ei){
            int mid = si + (ei-si)/2;
            if(ispossible(bloomDay,mid,m,k)){
                ans = mid;
                ei = mid-1;
            } else {
                si = mid + 1;
            }


        }

        return ans;
    }
}
