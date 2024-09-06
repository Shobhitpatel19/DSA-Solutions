//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.maxSubarraySum(arr));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int[] arr) {
        // Initialize variables to track the maximum sum.
        long max_so_far = Long.MIN_VALUE;
        long max_ending_here = 0;
        
        // Iterate through the array.
        for (int num : arr) {
            // Add current element to the current subarray sum.
            max_ending_here += num;
            
            // Update max_so_far if we have found a new maximum sum.
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }
            
            // If the current subarray sum becomes negative, reset it to 0.
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        
        return max_so_far;
    }
}
