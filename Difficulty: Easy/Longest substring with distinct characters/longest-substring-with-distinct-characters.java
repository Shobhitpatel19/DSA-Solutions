//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        int[] charCount = new int[26];  // to store frequency of characters
        int acquire = 0;    // right pointer
        int release = 0;    // left pointer
        int maxLen = 0;     // store maximum length
        
        while (acquire < s.length()) {
            // acquire character
            charCount[s.charAt(acquire) - 'a']++;
            
            // if current character count > 1, release characters until it becomes 1
            while (charCount[s.charAt(acquire) - 'a'] > 1) {
                charCount[s.charAt(release) - 'a']--;
                release++;
            }
            
            // update maxLen if current window is larger
            maxLen = Math.max(maxLen, acquire - release + 1);
            acquire++;
        }
        
        return maxLen;
    }
}