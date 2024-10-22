/**
Given an integer array arr, return all the unique pairs [arr[i], arr[j]] such that i != j and arr[i] + arr[j] == 0.

Note: The pairs must be returned in sorted order, the solution array should also be sorted, and the answer must not contain any duplicate pairs.

Examples:

Input: arr = [-1, 0, 1, 2, -1, -4]
Output: [[-1, 1]]
Explanation: arr[0] + arr[2] = (-1)+ 1 = 0.
arr[2] + arr[4] = 1 + (-1) = 0.
The distinct triplets are [-1,1].
Input: arr = [6, 1, 8, 0, 4, -9, -1, -10, -6, -5]
Output: [[-6, 6],[-1, 1]]
Explanation: The distinct triplets are [-1, 1] and [-6, 6].
Expected Time Complexity: O(n log n)
Expected Auxiliary Space: O(n).

Constraints:
3 <= arr.size <= 105
-105 <= arr[i] <= 105

// User function Template for Java
**/
class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int left = 0 ; 
        int right = arr.length -1 ; 
        while(left < right){
            int sum = arr[left] + arr[right] ; 
            
            if(sum < 0 ) {
                left++ ; 
                
            }else if(sum > 0 ) 
            {
                right--;    
            }else{
                ArrayList<Integer> subset = new ArrayList<>();
                subset.add(arr[left]);
                subset.add(arr[right]);
                result.add(subset);
                left++ ; 
                right--; 
                
                while( left < right  && arr[left] == arr[left - 1]){
                    left ++ ; 
                }
                   while(left < right && right < arr.length - 1 && arr[right] == arr[right + 1]){
                    right ++ ; 
                }
                
            }
            
        }
        return result ; 
    }
}
