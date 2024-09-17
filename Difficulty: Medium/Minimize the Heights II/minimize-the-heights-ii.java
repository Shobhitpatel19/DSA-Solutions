//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);

            // Ensure input is read correctly
            inputLine = br.readLine().trim().split(" ");
            if (inputLine == null || inputLine.length == 0) {
                System.out.println("Invalid input");
                continue;
            }

            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int getMinDiff(int[] arr, int k) {
        // code here
        int n = arr.length;
        if (n == 1) {
            return 0; // If there's only one tower, the difference is always 0.
        }
        
        // Sort the array to handle the smallest and largest heights easily
        Arrays.sort(arr);
        
        // Initial difference between the maximum and minimum heights
        int ans = arr[n - 1] - arr[0];
        
        // Initialize the smallest and largest after modifying the heights
        int small = arr[0] + k;
        int large = arr[n - 1] - k;
        
        // Iterate through the array and adjust heights
        for (int i = 0; i < n - 1; i++) {
            int minHeight = Math.min(small, arr[i + 1] - k);
            int maxHeight = Math.max(large, arr[i] + k);
            
            // Avoid negative heights
            if (minHeight < 0) continue;
            
            // Update the result with the minimum difference found so far
            ans = Math.min(ans, maxHeight - minHeight);
        }
        
        return ans;

    }
}
