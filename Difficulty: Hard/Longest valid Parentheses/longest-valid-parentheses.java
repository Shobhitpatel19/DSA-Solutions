//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int maxLength(String S) {
        // Stack to store indices of parentheses
        Stack<Integer> stack = new Stack<>();
        // Push -1 as a base to calculate the length of valid parentheses
        stack.push(-1);
        int maxLength = 0;
        
        // Traverse through the string
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                // Push the index of '(' onto the stack
                stack.push(i);
            } else {
                // Pop the previous index for ')'
                stack.pop();
                if (!stack.isEmpty()) {
                    // Calculate the length of the current valid parentheses
                    maxLength = Math.max(maxLength, i - stack.peek());
                } else {
                    // If the stack is empty, push the current index
                    stack.push(i);
                }
            }
        }
        
        return maxLength;
    }
}
