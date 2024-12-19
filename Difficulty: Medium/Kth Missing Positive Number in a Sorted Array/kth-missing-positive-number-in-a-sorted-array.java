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
            int ans = sln.kthMissing(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int kthMissing(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        
        // If k is smaller than first element minus 1,
        // then kth missing number is k itself
        if (k < arr[0]) {
            return k;
        }
        
        // If k is greater than last missing number before arr[last]
        int lastMissing = arr[arr.length - 1] - arr.length;
        if (k > lastMissing) {
            return arr[arr.length - 1] + (k - lastMissing);
        }
        
        // Binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Missing numbers before index mid
            int missing = arr[mid] - (mid + 1);
            
            if (missing < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // At this point, left is the insertion point
        return k + left;
    }
}