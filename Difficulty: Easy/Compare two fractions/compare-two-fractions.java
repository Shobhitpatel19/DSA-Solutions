//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        // Code here
        // Split the input string into two fractions
        String[] fractions = str.split(", ");
        
        // Parse the first fraction
        String[] fraction1 = fractions[0].split("/");
        int a = Integer.parseInt(fraction1[0]);
        int b = Integer.parseInt(fraction1[1]);
        
        // Parse the second fraction
        String[] fraction2 = fractions[1].split("/");
        int c = Integer.parseInt(fraction2[0]);
        int d = Integer.parseInt(fraction2[1]);
        
        // Calculate cross products to avoid floating point comparison
        int crossProduct1 = a * d;
        int crossProduct2 = c * b;
        
        // Compare cross products
        if (crossProduct1 > crossProduct2) {
            return fractions[0];
        } else if (crossProduct1 < crossProduct2) {
            return fractions[1];
        } else {
            return "equal";
        }
    }
}
