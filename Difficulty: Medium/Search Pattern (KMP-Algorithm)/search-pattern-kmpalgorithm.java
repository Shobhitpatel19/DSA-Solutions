//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Create the longest proper prefix which is also suffix (LPS) array
        int[] lps = computeLPSArray(pat);
        
        int i = 0; // index for txt
        int j = 0; // index for pat
        
        while (i < txt.length()) {
            // If characters match, move both pointers
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            
            // If pattern is fully matched, add the starting index to result
            if (j == pat.length()) {
                result.add(i - j);
                
                // Continue searching for next occurrences
                // Move j to the position of longest proper prefix suffix
                j = lps[j - 1];
            }
            // If mismatch occurs
            else if (i < txt.length() && pat.charAt(j) != txt.charAt(i)) {
                // If j is not at the start, use LPS array to skip comparisons
                if (j != 0) {
                    j = lps[j - 1];
                }
                // If j is at the start, move to next character in text
                else {
                    i++;
                }
            }
        }
        
        return result;
    }
    
    // Compute Longest Proper Prefix which is also Suffix (LPS) array
    private int[] computeLPSArray(String pat) {
        int[] lps = new int[pat.length()];
        int len = 0; // length of the previous longest prefix suffix
        int i = 1;
        
        while (i < pat.length()) {
            // If characters match, increment length and store it
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            // If mismatch occurs
            else {
                // If len is not 0, try to find shorter prefix
                if (len != 0) {
                    len = lps[len - 1];
                }
                // If len is 0, set LPS as 0 and move to next character
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
}