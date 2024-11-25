//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        // code here
        // Handle edge case of empty array
        if (arr == null || arr.length == 0) return 0;
        
        // Variables to track max and min product ending at current position
        int maxSoFar = arr[0];
        int minSoFar = arr[0];
        int result = maxSoFar;
        
        // Iterate through the array starting from second element
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            
            // Compute temporary max and min
            int tempMax = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
            int tempMin = Math.min(curr, Math.min(maxSoFar * curr, minSoFar * curr));
            
            // Update max and min product
            maxSoFar = tempMax;
            minSoFar = tempMin;
            
            // Update overall result
            result = Math.max(result, maxSoFar);
        }
        
        return result;
    }
}