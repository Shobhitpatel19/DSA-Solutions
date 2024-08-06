//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String str) {
        // Split the string by '.'
        String[] parts = str.split("\\.");
        
        // There must be exactly 4 parts
        if (parts.length != 4) {
            return false;
        }
        
        for (String part : parts) {
            // Each part must be a number with no leading zeros (unless it is "0")
            if (part.length() == 0 || part.length() > 3) {
                return false;
            }
            if (part.length() > 1 && part.charAt(0) == '0') {
                return false;
            }
            // Check if the part is a valid number and in the range 0-255
            try {
                int number = Integer.parseInt(part);
                if (number < 0 || number > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        
        return true;
    }
}
