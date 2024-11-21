//{ Driver Code Starts
// Initial Template for Java.
import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {

            String arr[] = br.readLine().split(" ");
            int prices[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the stockBuyAndSell method
            int res = ob.maximumProfit(prices);

            // Print the result
            System.out.println(res);

            // Print the "~" symbol to match the original output
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public int maximumProfit(int prices[]) {
        // code here
        int n = prices.length;
        
        // If no prices, return 0
        if (n <= 1) return 0;
        
        // DP array to store maximum profit
        int[] dp = new int[n];
        dp[0] = 0;
        
        for (int i = 1; i < n; i++) {
            // Maximum profit is either:
            // 1. Previous day's profit 
            // 2. Profit from buying at a lower price and selling today
            dp[i] = Math.max(dp[i-1], dp[i-1] + prices[i] - prices[i-1]);
        }
        
        return dp[n-1];
    }
}

