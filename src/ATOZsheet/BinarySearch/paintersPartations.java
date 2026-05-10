package ATOZsheet.BinarySearch;

public class paintersPartations {
    class Solution {

        public int paint(int A, int B, int[] C) {

            long si = 0;
            long ei = 0;

            for(int board : C){
                si = Math.max(si, board);
                ei += board;
            }

            long ans = ei;

            while(si <= ei){

                long mid = si + (ei - si) / 2;

                if(isPossible(C, A, mid)){
                    ans = mid;
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            }

            return (int)((ans * B) % 10000003);
        }

        private boolean isPossible(int[] C, int painters, long maxLen){

            int count = 1;
            long sum = 0;

            for(int board : C){

                if(sum + board <= maxLen){
                    sum += board;
                } else {
                    count++;
                    sum = board;
                }
            }

            return count <= painters;
        }
    }
}
