//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        // Split the string by "." (dot) and store in an array.
        String[] strArr = str.split("\\.");
        
        // Use a StringBuilder to construct the reversed string.
        StringBuilder sb = new StringBuilder();
        
        // Append the words in reverse order.
        for (int j = strArr.length - 1; j >= 0; j--) {
            sb.append(strArr[j]);
            if (j != 0) {
                sb.append(".");  // Add the dot back between words.
            }
        }
        
        return sb.toString();  // Return the reversed string.
    }
}