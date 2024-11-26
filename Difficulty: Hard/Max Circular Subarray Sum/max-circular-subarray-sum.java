//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    public int circularSubarraySum(int arr[]) {
        int n = arr.length;

        // Step 1: Find the maximum subarray sum using Kadane's algorithm
        int maxKadane = kadane(arr);
        
        // Step 2: Calculate the total sum of the array
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
        
        // Step 3: Find the minimum subarray sum using Kadane's algorithm on inverted array
        int minKadane = kadaneInverted(arr);
        
        // Step 4: Handle the case where all elements are negative
        if (totalSum == minKadane) {
            return maxKadane;
        }
        
        // Step 5: Compute the maximum circular subarray sum
        int maxCircular = totalSum - minKadane;
        
        // Return the maximum of the two cases
        return Math.max(maxKadane, maxCircular);
    }

    // Function to find the maximum subarray sum using Kadane's algorithm
    private int kadane(int arr[]) {
        int maxCurrent = arr[0], maxGlobal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxCurrent = Math.max(arr[i], maxCurrent + arr[i]);
            maxGlobal = Math.max(maxGlobal, maxCurrent);
        }
        return maxGlobal;
    }

    // Function to find the minimum subarray sum (inverted Kadane's algorithm)
    private int kadaneInverted(int arr[]) {
        int minCurrent = arr[0], minGlobal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            minCurrent = Math.min(arr[i], minCurrent + arr[i]);
            minGlobal = Math.min(minGlobal, minCurrent);
        }
        return minGlobal;
    }
}

