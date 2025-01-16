//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int T = Integer.parseInt(br.readLine());

        // Process each test case
        while (T-- > 0) {
            // Read the entire line containing the array elements
            String line = br.readLine();

            // Split the line into an array of strings, then parse them as integers
            String[] tokens = line.split("\\s+");
            int[] a = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                a[i] = Integer.parseInt(tokens[i]);
            }

            // Create the Solution object
            Solution obj = new Solution();

            // Call maxLen function and print the result
            System.out.println(obj.maxLen(a));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxLen(int[] arr) {
        // HashMap to store the running sum and its first occurrence index
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        
        // Replace 0s with -1s
        int[] modified = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            modified[i] = arr[i] == 0 ? -1 : 1;
        }
        
        int sum = 0;
        int maxLen = 0;
        
        // Add 0 sum with -1 index to handle case when entire array has sum 0
        sumMap.put(0, -1);
        
        for (int i = 0; i < modified.length; i++) {
            sum += modified[i];
            
            // If this sum was seen before, we found a subarray with sum 0
            if (sumMap.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - sumMap.get(sum));
            } else {
                // Store first occurrence of this sum
                sumMap.put(sum, i);
            }
        }
        
        return maxLen;
    }
}
