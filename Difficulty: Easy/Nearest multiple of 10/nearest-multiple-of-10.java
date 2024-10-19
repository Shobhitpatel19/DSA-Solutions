//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public String roundToNearest(String str) {
        int n = str.length();
        // Convert the last character (the last digit) to an integer
        int lastDigit = str.charAt(n - 1) - '0';
        
        // Check the value of the last digit to determine rounding
        if (lastDigit < 5) {
            // Round down: just replace the last digit with '0'
            return str.substring(0, n - 1) + "0";
        } else if (lastDigit == 5) {
            // If last digit is 5, choose the smaller multiple, i.e., round down
            return str.substring(0, n - 1) + "0";
        } else {
            // Round up: we need to add 1 to the remaining number
            String rounded = addOne(str.substring(0, n - 1)); // add one to the part before the last digit
            return rounded + "0"; // append '0' since it's now a multiple of 10
        }
    }
    
    // Helper function to add 1 to a large number represented as a string
    private String addOne(String num) {
        StringBuilder sb = new StringBuilder();
        int carry = 1;  // start with carry 1 because we are adding 1
        int i = num.length() - 1;
        
        while (i >= 0 || carry > 0) {
            int digit = (i >= 0 ? num.charAt(i) - '0' : 0) + carry;
            carry = digit / 10;
            sb.append(digit % 10);
            i--;
        }
        
        // Reverse the string since we are building it backwards
        return sb.reverse().toString();
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends