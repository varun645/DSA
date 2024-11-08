/**
Search array with adjacent diff at most k
Difficulty: EasyAccuracy: 57.91%Submissions: 51K+Points: 2
Given a step array arr[], its step value k, and a key x, we need to find the index of key x in the array arr[]. If multiple occurrences of key x exist, return the first occurrence of the key. In case of no occurrence of key x exists return -1.

Note: A step array is an array of integers where the difference between adjacent elements is at most k. For example: arr[] = [4, 6, 7, 9] and k = 2 is a step array as the difference between the adjacent elements in the arr[] is at most 2.  

Examples

Input: arr[] = [4, 5, 6, 7, 6] , k = 1 , x = 6
Output: 2
Explanation: In an array arr 6 is present at index 2. So, return 2.
Input: arr[] = [20, 40, 50], k = 20 , x = 70
Output: -1 
Explaination: As there is no occurrence of 70. So, return -1.


**/

class Solution {
    public int findStepKeyIndex(int[] arr, int k, int x) {
        int n = arr.length;
        int i = 0;
        while (i < n) {
            if (arr[i] == x) {
                return i;
            }
            i += Math.max(1, Math.abs(arr[i] - x) / k);
        }
        return -1;
    }
}
