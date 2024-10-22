/**
Given an array arr, rotate the array by one position in clock-wise direction.

Examples:

Input: arr = [1, 2, 3, 4, 5]
Output: [5, 1, 2, 3, 4]
Explanation: If we rotate arr by one position in clockwise 5 come to the front and remaining those are shifted to the end.
Input: arr = [9, 8, 7, 6, 4, 2, 1, 3]
Output: [3, 9, 8, 7, 6, 4, 2, 1]
Explanation: After rotating clock-wise 3 comes in first position.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1<=arr.size()<=105
0<=arr[i]<=105
**/

//{ Driver Code Starts
// // Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution ob = new Solution();
            ob.rotate(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends




// // User function Template for Java

class Solution {
    public void rotate(int[] arr) {
        int size = arr.length;
        
        if(size < 2){
            return; 
        }
        if(size < 3){
            int temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp ; 
            return ; 
        }
        
        int first = arr[0];
        int second = arr[1];
        
        
        arr[0] = arr[size - 1];
        arr[size-1] = arr[size-2];
        for(int i = 1 ; i < size-1 ; i++){
            arr[i] = first ; 
            first = second ; 
            second = arr[i+1];
        }
    }
}
