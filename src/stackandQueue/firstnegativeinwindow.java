package stackandQueue;
import java.util.*;
public class firstnegativeinwindow {
    static List<Integer> firstNegInt(int arr[], int k) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        // fill the queue with -ve indices
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                q.add(i);
            }
        }
        for (int i = 0; i < n - k + 1; i++) {
            if (!q.isEmpty() && q.peek() < i) q.remove(); // not lie in the window
            if (!q.isEmpty() && q.peek() < i + k) { //that's mean the first -ve is the queue peek
                ans.add(arr[q.peek()]);
            } else {
                ans.add(0);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {-8, 2, 3, -6, 10};
        System.out.println(firstNegInt(arr, 2));
    }
}
