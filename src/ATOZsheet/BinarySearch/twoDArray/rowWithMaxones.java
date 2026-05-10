package ATOZsheet.BinarySearch.twoDArray;

public class rowWithMaxones {
    static int findLowerBound(int[] arr, int endIndex, int k) {
        int si = 0;
        int ei = endIndex;
        int lowerBound = -1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (arr[mid] == k) {
                lowerBound = mid;
                ei = mid - 1;
            } else if (arr[mid] > k) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        return lowerBound;
    }

    public int rowWithMax1s(int[][] mat) {
        int max_count_one = 0;
        int index = -1;

        for (int i = 0; i < mat.length; i++) {

            int firstOne = findLowerBound(mat[i], mat[i].length - 1, 1);

            int cnt = 0;

            if (firstOne != -1) {
                cnt = mat[i].length - firstOne;
            }

            if (cnt > max_count_one) {
                max_count_one = cnt;
                index = i;
            }
        }

        return index;
    }
}
