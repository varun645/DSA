/**
Given an unsorted array arr containing both positive and negative numbers. Your task is to rearrange the array and convert it into an array of alternate positive and negative numbers without changing the relative order.

Note:
- Resulting array should start with a positive integer (0 will also be considered as a positive integer).
- If any of the positive or negative integers are exhausted, then add the remaining integers in the answer as it is by maintaining the relative order.
- The array may or may not have equal number of positive and negative integers.

Examples:

Input: arr[] = [9, 4, -2, -1, 5, 0, -5, -3, 2]
Output: 9 -2 4 -1 5 -5 0 -3 2
Explanation: The positive numbers are [9, 4, 5, 0, 2] and the negative integers are [-2, -1, -5, -3]. Since, we need to start with the positive integer first
and then negative integer and so on (by maintaining the relative order as well), hence we will take 9 from the positive set of elements and then
-2 after that 4 and then -1 and so on.
Hence, the output is 9, -2, 4, -1, 5, -5, 0, -3, 2.
Input: arr[] = [-5, -2, 5, 2, 4, 7, 1, 8, 0, -8]
Output: 5 -5 2 -2 4 -8 7 1 8 0
Explanation : The positive numbers are [5, 2, 4, 7, 1, 8, 0] and the negative integers are [-5,-2,-8]. According to the given conditions we will start
from the positive integer 5 and then -5 and so on. After reaching -8 there are no negative elements left, so according to the given rule, we will
add the remaining elements (in this case positive elements are remaining) as it in by maintaining the relative order.
Hence, the output is 5, -5, 2, -2, 4, -8, 7, 1, 8, 0.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

**/




class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        ArrayList<Integer>pos=new ArrayList<>();
        ArrayList<Integer>neg=new ArrayList<>();
        ArrayList<Integer>res=new ArrayList<>();
        for(int i:arr)
        {
            if(i<0)
            {
                neg.add(i);
            }
            if(i>=0)
            {
                pos.add(i);
            }
        }
        int i=0;int j=0;
        boolean postrue=true;
        while(i<pos.size() && j<neg.size())
        {
            if(postrue)
            {
                res.add(pos.get(i++));
            }
            else
            {
            
                res.add(neg.get(j++));
            }
            postrue=!postrue;
            
        }
        while(i<pos.size())
        {
            res.add(pos.get(i++));
        }
        while(j<neg.size())
        {
            res.add(neg.get(j++));
        }
        arr.clear();
        arr.addAll(res);
    }
}
