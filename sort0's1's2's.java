/**
Given an array arr containing only 0s, 1s, and 2s. Sort the array in ascending order.

Examples:

Input: arr[] = [0, 2, 1, 2, 0]
Output: 0 0 1 2 2
Explanation: 0s 1s and 2s are segregated into ascending order.
Input: arr[] = [0, 1, 0]
Output: 0 0 1
Explanation: 0s 1s and 2s are segregated into ascending order.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= arr.size() <= 106
0 <= arr[i] <= 2
**/

class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        int size = arr.size();
        int min = 0 ; 
        int max = size-1 ; 
        int mid = 0 ; 
        
       while(mid <= max){
           if(arr.get(mid) == 0 ){
               swap(arr , mid , min);
               mid++ ; min++ ; 
           }else if(arr.get(mid) == 1){
               mid ++ ; 
           }else {
               swap(arr , mid , max);
               max--; 
           }
       }
        
    }
    
    void swap(ArrayList<Integer> arr , int i , int j){
        int temp = arr.get(i);
        arr.set( i , arr.get(j));
        //arr.get(i) = arr.get(j);
        arr.set(j , temp ) ; 
    }
}
