//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            out.println(ob.decodedString(s));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String decodedString(String s){
        // code here
        Stack<String> stack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); // accumulate the digit

            } else if (ch == '[') {
                // push the current string and the number into the stack
                stack.push(currentString.toString());
                stack.push(String.valueOf(k));
                currentString = new StringBuilder(); // reset for next string
                k = 0; // reset the number

            } else if (ch == ']') {
                // pop the number and previous string
                int repeatTimes = Integer.parseInt(stack.pop());
                StringBuilder prevString = new StringBuilder(stack.pop());
                
                // repeat the current string and append to the previous one
                for (int j = 0; j < repeatTimes; j++) {
                    prevString.append(currentString);
                }
                currentString = prevString;

            } else {
                currentString.append(ch); // build the current string
            }
        }

        return currentString.toString();
    }
}