/**
Maximize sum after K negations
Difficulty: EasyAccuracy: 24.75%Submissions: 77K+Points: 2
Given an array of integers of size N and a number K., You must modify array arr[] exactly K number of times. Here modify array means in each operation you can replace any array element either arr[i] by -arr[i] or -arr[i] by arr[i]. You need to perform this operation in such a way that after K operations, the sum of the array must be maximum.


Example 1:

Input:
N = 5, K = 1
arr[] = {1, 2, -3, 4, 5}
Output:
15
Explanation:
We have k=1 so we can change -3 to 3 and
sum all the elements to produce 15 as output.
Example 2:

Input:
N = 10, K = 5
arr[] = {5, -2, 5, -4, 5, -12, 5, 5, 5, 20}
Output:
68
Explanation:
Here  we have k=5 so we turn -2, -4, -12 to
2, 4, and 12 respectively. Since we have
performed 3 operations so k is now 2. To get
maximum sum of array we can turn positive
turned 2 into negative and then positive
again so k is 0. Now sum is
5+5+4+5+12+5+5+5+20+2 = 68

Your Task:
You don't have to print anything, printing is done by the driver code itself. You have to complete the function maximizeSum() which takes the array A[], its size N, and an integer K as inputs and returns the maximum possible sum.


**/



public static long maximizeSum(long a[], int n, int k) {
        
        // Sort the array in non-decreasing order
        Arrays.sort(a);
        
        // Iterate through the array
        for(int i=0;i<n;i++) {
            
            // If the current element is negative and
            // we still have remaining negations (k > 0)
            if(a[i]<0 && k>0) {
                // Negate the current element
                a[i]*=-1;
                // Decrease the count of remaining negations
                k--;
            }
        }
        
        // Sort the array again after negating elements
        Arrays.sort(a);
        
        long sum = 0;
        
        // Calculate the sum of all elements in the array
        for(int i=0;i<n;i++)
            sum+=a[i];
        
        // If the count of remaining negations is odd (k%2 == 1)
        // Subtract twice the smallest element from the sum
        if(k%2==1)
            sum-=2*a[0];
        
        // Return the final sum
        return sum;
    }
