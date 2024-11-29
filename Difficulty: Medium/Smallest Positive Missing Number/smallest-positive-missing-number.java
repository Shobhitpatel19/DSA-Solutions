//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // Read the line of integers (prices)
            String input = br.readLine().trim();

            // Split the input line into integers and store in an array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the missingNumber method
            int res = ob.missingNumber(arr);

            // Print the result
            System.out.println(res);

            // Print the "~" symbol to match the original output
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        
        // Step 1: Ignore non-positive and numbers greater than n
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = n + 1;
            }
        }
        
        // Step 2: Mark presence of numbers in the array
        for (int i = 0; i < n; i++) {
            int num = Math.abs(arr[i]);
            if (num <= n) {
                arr[num - 1] = -Math.abs(arr[num - 1]);
            }
        }
        
        // Step 3: Find the first missing positive number
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        
        // If all numbers from 1 to n are present
        return n + 1;
    }
}
