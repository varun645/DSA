/**
Given an unsorted array arr of positive integers. One number a from the set [1, 2,....,n] is missing and one number b occurs twice in the array. Find numbers a and b.

Note: The test cases are generated such that there always exists one missing and one repeating number within the range [1,n].

Examples:

Input: arr[] = [2, 2]
Output: [2, 1]
Explanation: Repeating number is 2 and smallest positive missing number is 1.
Input: arr[] = [1, 3, 3] 
Output: [3, 2]
Explanation: Repeating number is 3 and smallest positive missing number is 2.
Input: arr[] = [4, 3, 6, 2, 1, 1]
Output: [1, 5]
Explanation: Repeating number is 1 and the missing number is 5.


**/


//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            int[] ans = new Solve().findTwoElement(arr);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        // code here
        
        int[] ans = new int[2];
        
        int n = arr.length;

        // Creating visited vector of size n+1 with
        // initial values as false. Note that array
        // values will go upto n, that is why we
        // have taken the size as n+1
        boolean[] visited = new boolean[n + 1];
      
        int repeating = -1, missing = -1;

        Arrays.fill(visited, false);

        for (int i = 0; i < n; i++) {
            if (visited[arr[i]]) {
                repeating = arr[i];
            }
            else {
                visited[arr[i]] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                missing = i;
                break;
            }
        }
        
        ans[0] = repeating;
        ans[1] = missing;
        
        return ans;
    }
}

