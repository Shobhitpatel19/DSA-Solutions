//{ Driver Code Starts
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            double b = sc.nextDouble();
            int e = sc.nextInt();
            Solution ob = new Solution();
            System.out.printf("%.5f\n", ob.power(b, e));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    double power(double b, int e) {
        if (e == 0) return 1.0;
        long exp = e; // Convert to long to handle Integer.MIN_VALUE correctly
        if (exp < 0) {
            exp = -exp;
            double result = helper(b, exp);
            return 1.0 / result;
        } else {
            return helper(b, exp);
        }
    }
    
    private double helper(double b, long exp) {
        double result = 1.0;
        double currentBase = b;
        while (exp > 0) {
            if ((exp % 2) == 1) {
                result *= currentBase;
            }
            currentBase *= currentBase;
            exp /= 2;
        }
        return result;
    }
}



//{ Driver Code Starts.
// } Driver Code Ends