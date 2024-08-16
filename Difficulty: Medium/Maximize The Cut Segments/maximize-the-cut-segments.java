//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       // Initialize dp array with minimum values
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        
        // Base case: 0 length means 0 cuts
        dp[0] = 0;

        // Iterate over the lengths from 1 to n
        for (int i = 1; i <= n; i++) {
            // Check if it's possible to make a cut of size x
            if (i - x >= 0) dp[i] = Math.max(dp[i], dp[i - x]);

            // Check if it's possible to make a cut of size y
            if (i - y >= 0) dp[i] = Math.max(dp[i], dp[i - y]);

            // Check if it's possible to make a cut of size z
            if (i - z >= 0) dp[i] = Math.max(dp[i], dp[i - z]);

            // If any cut was possible, increment the count
            if (dp[i] != Integer.MIN_VALUE) dp[i]++;
        }

        // If no cuts were possible, return 0; otherwise, return the result for length n
        return dp[n] == Integer.MIN_VALUE ? 0 : dp[n];
    }
}
