//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    // Function to check if current allocation is possible
    public static boolean isPossible(int[] arr, int n, int k, int maxPages) {
        int studentsUsed = 1;
        int currentPageSum = 0;
        
        for (int i = 0; i < n; i++) {
            // If a single book has more pages than maxPages, allocation is impossible
            if (arr[i] > maxPages) return false;
            
            // If adding current book exceeds maxPages, move to next student
            if (currentPageSum + arr[i] > maxPages) {
                studentsUsed++;
                currentPageSum = arr[i];
                
                // If students exceed given number, allocation is impossible
                if (studentsUsed > k) return false;
            } else {
                // Add current book to current student's allocation
                currentPageSum += arr[i];
            }
        }
        
        return true;
    }
    
    public static int findPages(int[] arr, int k) {
        // Code Here
        // If number of students is more than number of books, allocation is impossible
        if (k > arr.length) return -1;
        
        // Calculate total pages and find minimum possible maximum pages
        int start = 0;
        int end = 0;
        for (int pages : arr) {
            start = Math.max(start, pages);
            end += pages;
        }
        
        int result = -1;
        
        // Binary search to find minimum possible maximum pages
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            // Check if current mid value is a possible allocation
            if (isPossible(arr, arr.length, k, mid)) {
                result = mid;
                // Try to minimize further
                end = mid - 1;
            } else {
                // Need to increase the maximum pages
                start = mid + 1;
            }
        }
        
        return result;
    }
}