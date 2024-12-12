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
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int n = arr.length;
        int idx = Arrays.binarySearch(arr, target);
        if (idx < 0) return 0; // Target not found
        
        int count = 1; // Count the first occurrence
        int left = idx - 1;
        int right = idx + 1;
        
        // Count occurrences to the left of idx
        while (left >= 0 && arr[left] == target) {
            count++;
            left--;
        }
        
        // Count occurrences to the right of idx
        while (right < n && arr[right] == target) {
            count++;
            right++;
        }
        
        return count;
    }
}
