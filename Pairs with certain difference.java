/**
Pairs with certain difference
Difficulty: EasyAccuracy: 63.41%Submissions: 36K+Points: 2
Given an array of integers, arr[] and a number, K.You can pair two numbers of the array if the difference between them is strictly less than K. The task is to find the maximum possible sum of such disjoint pairs (i.e., each element of the array can be used at most once). The Sum of P pairs is the sum of all 2P elements of pairs.

 

Example 1:

Input  : 
arr[] = {3, 5, 10, 15, 17, 12, 9}
K = 4
Output : 
62
Explanation :
Then disjoint pairs with difference less
than K are, (3, 5), (10, 12), (15, 17)
max sum which we can get is 
3 + 5 + 10 + 12 + 15 + 17 = 62
Note that an alternate way to form 
disjoint pairs is,(3, 5), (9, 12), (15, 17)
but this pairing produces less sum.
 

Example 2:

Input  : 
arr[] = {5, 15, 10, 300}
K = 12
Output : 
25
 

Your Task:  
You don't need to read, input, or print anything. Your task is to complete the function maxSumPairWithDifferenceLessThanK() which takes the array arr[], its size N, and an integer K as inputs and returns the maximum possible sum of disjoint pairs.

 

Expected Time Complexity: O(N. log(N))
Expected Auxiliary Space: O(N)

**/


class Solution {
    // method to return maximum sum we can get by 
    // finding less than K difference pair 
    public static int maxSumPairWithDifferenceLessThanK(int arr[], int N, int K) 
    {
        // Sort input array in ascending order. 
        Arrays.sort(arr); 
      
        // dp[i] denotes the maximum disjoint pair sum 
        // we can achieve using first i elements 
        int dp[] = new int[N]; 
      
        // if no element then dp value will be 0 
        dp[0] = 0; 
      
        for (int i = 1; i < N; i++) 
        { 
            // first give previous value to dp[i] i.e. 
            // no pairing with (i-1)th element 
            dp[i] = dp[i-1]; 
      
            // if current and previous element can form a pair 
            if (arr[i] - arr[i-1] < K) 
            { 
                  
                // update dp[i] by choosing maximum between 
                // pairing and not pairing 
                if (i >= 2) 
                    dp[i] = Math.max(dp[i], dp[i-2] + arr[i] + 
                                                    arr[i-1]); 
                else
                    dp[i] = Math.max(dp[i], arr[i] + arr[i-1]); 
            } 
        } 
      
        // last index will have the result 
        return dp[N - 1]; 
    } 
    
}
