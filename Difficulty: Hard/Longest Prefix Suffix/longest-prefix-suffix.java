//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int lps(String str) {
        // code here
        int n = str.length();
        
        // Array to store the longest prefix suffix values
        int[] lps = new int[n];
        
        // Length of the previous longest prefix suffix
        int len = 0;
        
        // Start from index 1 (since lps[0] is always 0)
        int i = 1;
        
        // Fill the lps array
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // Mismatch after len matches
                if (len != 0) {
                    // Fall back to the previous valid prefix
                    len = lps[len - 1];
                } else {
                    // No valid prefix found
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        // The value at the last index of lps[] will be the answer
        return lps[n - 1];
    }
}