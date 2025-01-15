//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans = ob.longestSubarray(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Map to store the first occurrence of each prefix sum
        Map<Long, Integer> prefixSum = new HashMap<>();
        
        long currentSum = 0;
        int maxLength = 0;
        
        // Add initial sum of 0 at index -1 to handle subarrays starting from index 0
        prefixSum.put(0L, -1);
        
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            
            // Check if there exists a prefix sum that when subtracted from current sum gives k
            // currentSum - x = k
            // x = currentSum - k
            long target = currentSum - k;
            
            // If we found such a prefix sum, update maxLength if applicable
            if (prefixSum.containsKey(target)) {
                maxLength = Math.max(maxLength, i - prefixSum.get(target));
            }
            
            // Only add current sum to map if it's not already there
            // We want the earliest occurrence for maximum length
            if (!prefixSum.containsKey(currentSum)) {
                prefixSum.put(currentSum, i);
            }
        }
        
        return maxLength;
    }
}
