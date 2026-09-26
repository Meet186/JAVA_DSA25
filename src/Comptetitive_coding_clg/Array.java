package Comptetitive_coding_clg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Array {
    // PHASE_1 : SEARCHING & TRAVERSAL

    // question-1
    // Find the first occurrence of X
    static int find_First_Accurance(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }
    // question-2
    // Find the last occurrence of X
    static int find_Last_Accurance(int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }
    // question-3
    // Count how many times X occurs
    static int Count_X(int[] arr, int x) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                count++;
        }
        return count;
    }
    // question-4
    // Print every index where X occurs
    static void print_Index(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                System.out.println("index : " + i);
            }
        }
    }
    // PHASE_2 : DELETE & SHIFT
    // question-5 && 6
    // Delete element at given index
    static int[] deleteAtIndex(int[] arr, int index) {

        if (index < 0 || index >= arr.length) {
            return arr;
        }

        int[] result = new int[arr.length - 1];

        int idx = 0;

        for (int i = 0; i < arr.length; i++) {

            if (i != index) {
                result[idx++] = arr[i];
            }
        }

        return result;
    }

    // question-7
    // Search X and delete first occurrence
    static int[] deleteFirstAccurance(int[] arr, int x) {

        int indexOfX = find_First_Accurance(arr, x);

        // X not found
        if (indexOfX == -1) {
            return arr;
        }

        int[] result = new int[arr.length - 1];

        int idx = 0;

        for (int i = 0; i < arr.length; i++) {

            if (i != indexOfX) {
                result[idx++] = arr[i];
            }
        }

        return result;
    }

    // question-8
    // Delete all occurrences of X
    static int[] deleteAllAccurance(int[] arr, int x) {

        int count = Count_X(arr, x);

        int[] result = new int[arr.length - count];

        int idx = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != x) {
                result[idx++] = arr[i];
            }
        }

        return result;
    }
    // PHASE_3 : REVERSE & ROTATE

    // question-9
    // Reverse array using another array
    static int[] reverseUsingAnotherArray(int[] arr) {

        int[] result = new int[arr.length];

        int idx = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            result[idx++] = arr[i];
        }

        return result;
    }

    // question-10
    // Reverse array in-place
    static void reverseInPlace(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    // question-11
    // Rotate array left by 1
    static void rotateLeftByOne(int[] arr) {

        if (arr.length <= 1)
            return;

        int first = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[arr.length - 1] = first;
    }

    // question-12
    // Rotate array right by 1
    static void rotateRightByOne(int[] arr) {

        if (arr.length <= 1)
            return;

        int last = arr[arr.length - 1];

        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = last;
    }

    // question-13
    // Rotate array left by K positions
    static void rotateLeftByK(int[] arr, int k) {

        if (arr.length == 0)
            return;

        k = k % arr.length;

        for (int i = 0; i < k; i++) {
            rotateLeftByOne(arr);
        }
    }

    // question-14
    // Rotate array right by K positions
    static void rotateRightByK(int[] arr, int k) {

        if (arr.length == 0)
            return;

        k = k % arr.length;

        for (int i = 0; i < k; i++) {
            rotateRightByOne(arr);
        }
    }
    // PHASE_4 : REARRANGEMENT / FILTERING
    // question-15
    // Remove all negative numbers
    static int[] removeNegative(int[] arr) {

        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < 0)
                count++;
        }

        int[] result = new int[arr.length - count];

        int idx = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] >= 0) {
                result[idx++] = arr[i];
            }
        }

        return result;
    }

    // question-16
    // Move all zeros to the end
    static void moveZerosToEnd(int[] arr) {
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0) {
                arr[idx++] = arr[i];
            }
        }
        while (idx < arr.length) {
            arr[idx++] = 0;
        }
    }
    // PHASE_5 : DUPLICATES & FREQUENCY
    // question-17
    // Find duplicate elements
    static void findDuplicates(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.print("Duplicate elements: ");

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() > 1) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }

    // question-18
    // Find first duplicate
    static int findFirstDuplicate(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!set.add(arr[i])) {
                return arr[i];
            }
        }

        return -1;
    }

    // question-19
    // Find first non-repeating element
    static int findFirstNonRepeating(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {

            if (map.get(arr[i]) == 1) {
                return arr[i];
            }
        }
        return -1;
    }

    // question-20
    // Find frequency of every element
    static void frequencyOfEveryElement(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(
                    arr[i],
                    map.getOrDefault(arr[i], 0) + 1
            );
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(
                    entry.getKey() + " -> " + entry.getValue()
            );
        }
    }



    // PHASE_6 : TWO ARRAYS


    // question-21
    // Find common elements of two arrays
    static void commonElements(int[] arr1, int[] arr2) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        System.out.print("Common elements: ");
        HashSet<Integer> printed = new HashSet<>();
        for (int i = 0; i < arr2.length; i++) {

            if (set.contains(arr2[i]) && printed.add(arr2[i])) {
                System.out.print(arr2[i] + " ");
            }
        }
    }



    // PHASE_7 : BASIC PROBLEM SOLVING


    // question-22
    // Find missing number from 1 to N
    static int findMissingNumber(int[] arr, int n) {

        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;

        for (int i = 0; i < arr.length; i++) {
            actualSum += arr[i];
        }

        return expectedSum - actualSum;

        // other way xor..
    }

    // question-23
    // Find pair whose sum is X
    static void twoSum(int[] arr, int x) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {

            int required = x - arr[i];

            if (map.containsKey(required)) {

                System.out.println(
                        "Pair = " + required + ", " + arr[i]
                );

                return;
            }

            map.put(arr[i], i);
        }
        System.out.println("Pair not found");
    }



    // PHASE_8 : TWO POINTER TECHNIQUE


    // question-24
    // Reverse array using two pointers
    static void reverseUsingTwoPointer(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int temp = arr[left];

            arr[left] = arr[right];

            arr[right] = temp;

            left++;
            right--;
        }
    }

    // question-25
    // Check whether array is palindrome
    static boolean isPalindrome(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    // question-26
    // Remove duplicates from sorted array
    static int[] removeDuplicatesFromSortedArray(int[] arr) {
        int[] temp = new int[arr.length];
        int index = 0;
        temp[index++] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {

                temp[index++] = arr[i];
            }
        }
        return Arrays.copyOf(temp, index);
    }
    // PHASE_9 : SLIDING WINDOW / SUBARRAYS

    // question-27
    // Maximum sum of K consecutive elements
    static int maxSumOfK(int[] arr, int k) {

        int l = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int r = 0; r < arr.length; r++) {
            sum += arr[r];
            while (r - l + 1 > k) {
                sum -= arr[l];
                l++;
            }
            if (r - l + 1 == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    // question-28
    // Print all subarrays
    static void printAllSubarrays(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {

                System.out.print("[");

                for (int k = i; k <= j; k++) {

                    System.out.print(arr[k]);

                    if (k < j)
                        System.out.print(", ");
                }

                System.out.println("]");
            }
        }
    }

    // question-29
    // Maximum subarray sum - Kadane's Algorithm
    static int maximumSubarraySum(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;

        int start = 0, end = 0, tempStart = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            if (currSum > maxSum) {
                maxSum = currSum;
                start = tempStart;
                end = i;
            }

            if (currSum < 0) {
                currSum = 0;
                tempStart = i + 1;
            }
        }

        System.out.println("Subarray from index " + start + " to " + end);
        return maxSum;
    }

    // question-30
    // Find a subarray with given sum
    static void findSubarrayWithSum(int[] arr, int target) {
        int l = 0;
        int sum = 0;
        for (int r = 0; r < arr.length; r++) {
            sum += arr[r];
            while (sum > target && l <= r) {
                sum -= arr[l];
                l++;
            }
            if (sum == target) {
                System.out.print("Subarray found: [");
                for (int i = l; i <= r; i++) {
                    System.out.print(arr[i]);
                    if (i < r) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
                return;
            }
        }
        System.out.println("Subarray not found");
    }
    public static void main(String[] args) {

    }
}