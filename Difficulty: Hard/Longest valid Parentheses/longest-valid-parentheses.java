//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String S = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    static int maxLength(String s) {
        int maxLen = 0;
        int open = 0, close = 0;
        
        // Left to Right scan
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') open++;
            else close++;
            
            if (open == close) {
                maxLen = Math.max(maxLen, 2 * close);
            } else if (close > open) {
                open = close = 0;
            }
        }
        
        // Reset counters
        open = close = 0;

        // Right to Left scan
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') close++;
            else open++;

            if (open == close) {
                maxLen = Math.max(maxLen, 2 * open);
            } else if (open > close) {
                open = close = 0;
            }
        }

        return maxLen;
    }
}
