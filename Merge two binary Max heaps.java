/**
Given two binary max heaps as arrays, merge the given heaps to form a new max heap.

Example 1:

Input  : 
n = 4 m = 3
a[] = {10, 5, 6, 2}, 
b[] = {12, 7, 9}
Output : 
{12, 10, 9, 2, 5, 7, 6}
Explanation :

 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function mergeHeaps() which takes the array a[], b[], its size n and m, as inputs and return the merged max heap. Since there can be multiple solutions, therefore, to check for the correctness of your solution, your answer will be checked by the driver code and will return 1 if it is correct, else it returns 0.

**/


class Solution{
    
    public void maxHeapify(int[] arr, int n, int idx) {
        // if index is out of bounds, return
        if (idx >= n) return;
        
        // calculate left and right child indices
        int l = 2 * idx + 1;
        int r = 2 * idx + 2;
        
        int max;
        
        // find the maximum element between current element and its left child
        if (l < n && arr[l] > arr[idx])
            max = l;
        else
            max = idx;
        
        // find the maximum element between previous maximum and right child
        if (r < n && arr[r] > arr[max]) max = r;
    
        // if maximum element is not the current element, swap and recursively call maxHeapify
        if (max != idx) {
            int temp = arr[max];
            arr[max] = arr[idx];
            arr[idx] = temp;
            maxHeapify(arr, n, max);
        }
    }
    
    public void buildMaxHeap(int[] arr, int n) {
        // iterate from last non-leaf node to the root and call maxHeapify
        for(int i = n/2-1; i >= 0; i--)
            maxHeapify(arr, n, i);
    }
    
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // create a merged array
        int[] merged = new int[n+m];
        
        // copy elements from array a to merged array
        for (int i = 0; i < n; i++) merged[i] = a[i];
        
        // copy elements from array b to merged array
        for (int i = 0; i < m; i++) merged[n + i] = b[i];
        
        // build max heap of merged array
        buildMaxHeap(merged, n + m);
        
        // return the merged array
        return merged;
    }
}
