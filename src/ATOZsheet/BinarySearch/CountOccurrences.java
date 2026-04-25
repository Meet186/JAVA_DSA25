package ATOZsheet.BinarySearch;

public class CountOccurrences {


        public static int countOccurrences(int[] arr, int target) {
            int first = firstOccurrence(arr, target);
            if (first == -1) return 0; // target not found
            int last = lastOccurrence(arr, target);
            return last - first + 1;
        }

        private static int firstOccurrence(int[] arr, int target) {
            int si = 0, ei = arr.length - 1;
            int ans = -1;

            while (si <= ei) {
                int mid = si + (ei - si) / 2;

                if (arr[mid] == target) {
                    ans = mid;
                    ei = mid - 1; // move left
                } else if (arr[mid] < target) {
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            }
            return ans;
        }

        private static int lastOccurrence(int[] arr, int target) {
            int si = 0, ei = arr.length - 1;
            int ans = -1;

            while (si <= ei) {
                int mid = si + (ei - si) / 2;

                if (arr[mid] == target) {
                    ans = mid;
                    si = mid + 1; // move right
                } else if (arr[mid] < target) {
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            }
            return ans;
        }

        public static void main(String[] args) {
            int[] arr = {1, 2, 2, 2, 3, 4};
            int target = 2;
            System.out.println(countOccurrences(arr, target)); // Output: 3
        }
    }

