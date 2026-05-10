package ATOZsheet.BinarySearch;

public class findKthEl {

    public static int kthElement(int[] a, int[] b, int k) {

        int cnt = 0;
        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {

            int val;

            if (a[i] <= b[j]) {
                val = a[i++];
            } else {
                val = b[j++];
            }

            cnt++;

            if (cnt == k) return val;
        }

        while (i < a.length) {
            cnt++;

            if (cnt == k) return a[i];

            i++;
        }

        while (j < b.length) {
            cnt++;

            if (cnt == k) return b[j];

            j++;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};

        int k = 5;

        System.out.println(kthElement(a, b, k));
    }
}