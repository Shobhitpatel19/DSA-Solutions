//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String addBinary(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            
            if (i >= 0) {
                sum += s1.charAt(i) - '0';
                i--;
            }
            
            if (j >= 0) {
                sum += s2.charAt(j) - '0';
                j--;
            }
            
            sb.append(sum % 2);
            carry = sum / 2;
        }
        
        // Reverse the string to get correct order
        String result = sb.reverse().toString();
        
        // Remove leading zeros
        int start = 0;
        while (start < result.length() - 1 && result.charAt(start) == '0') {
            start++;
        }
        
        return result.substring(start);
    }
}