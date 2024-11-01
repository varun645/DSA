/**
Given a number x and an array of integers arr, find the smallest subarray with sum greater than the given value. If such a subarray do not exist return 0 in that case.

Examples:

Input: x = 51, arr[] = [1, 4, 45, 6, 0, 19]
Output: 3
Explanation: Minimum length subarray is [4, 45, 6]
Input: x = 100, arr[] = [1, 10, 5, 2, 7]
Output: 0
Explanation: No subarray exist
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size, x ≤ 105
0 ≤ arr[] ≤ 104
**/




class Solution {
    public static int smallestSubWithSum(int x, int[] arr) {
        int n = arr.length;
        int curr_sum = 0, min_len = n + 1;
        int start = 0, end = 0;

        while (end < n) {
            while (curr_sum <= x && end < n) curr_sum += arr[end++];

            while (curr_sum > x && start < n) {
                if (end - start < min_len) min_len = end - start;

                curr_sum -= arr[start++];
            }
        }

        if (min_len > n) return 0;
        return min_len;
    }
}
