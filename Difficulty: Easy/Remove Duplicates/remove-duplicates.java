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
            String result = ob.removeDups(s);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String removeDups(String s) {
        // code here
        Map<Character,Integer> exists = new HashMap<>();
        int n = s.length();
        
        StringBuilder st = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(!exists.containsKey(s.charAt(i))){
              st.append(s.charAt(i));
              exists.put(s.charAt(i), 1);
            }
        }
        return st.toString();
    }
}