//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int[] a = new int[s.length];
            for (int i = 0; i < s.length; i++) a[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            int res = obj.pairWithMaxSum(a);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public int pairWithMaxSum(int[] arr) {
        // code here
        // Check if array has fewer than 2 elements
        if (arr.length < 2) {
            return -1;
        }

        // Initialize max sum as the smallest possible value
        int max_sum = Integer.MIN_VALUE;

        // Iterate through the array and find the sum of each adjacent pair
        for (int i = 0; i < arr.length - 1; i++) {
            int sum = arr[i] + arr[i + 1];
            max_sum = Math.max(max_sum, sum);
        }

        // Return the maximum sum found
        return max_sum;
    }
}
