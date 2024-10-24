/**
Given an array of strings arr. Return the longest common prefix among each and every strings present in the array. If there's no prefix common in all the strings, return "-1".

Examples :

Input: arr[] = ["geeksforgeeks", "geeks", "geek", "geezer"]
Output: gee
Explanation: "gee" is the longest common prefix in all the given strings.
Input: arr[] = ["hello", "world"]
Output: -1
Explanation: There's no common prefix in the given strings.
Expected Time Complexity: O(n*min(|arri|))
Expected Space Complexity: O(min(|arri|))

Constraints:
1 ≤ |arr| ≤ 103
1 ≤ |arr[i]| ≤ 103

**/

// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
       if(arr.length == 0 || arr == null){
           return "";
       }
       
       Arrays.sort(arr);
       
       String res= "";
       
       for(int i = 0 ; i < arr[0].length() ; i++){
           boolean flag = true ; 
           for(int j = 0 ; j < arr.length ; j++){
               if(i >= arr[j].length() || arr[j].charAt(i) != arr[0].charAt(i)){
                   flag = false ; 
                   
                   break ; 
               }
           }
           
           if(!flag) break ;
           
               res +=arr[0].charAt(i);
           
       }
       if(res =="")return "-1";
       
       return res; 
    }
}
