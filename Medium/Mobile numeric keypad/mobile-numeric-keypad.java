//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long getCount(int N) {
        // Your code goes here
        long dp[][] = new long[N + 1][10];
 
        int[][] data
            = { { 0, 8 },          { 1, 2, 4 },
                { 1, 2, 3, 5 },    { 2, 3, 6 },
                { 1, 4, 5, 7 },    { 2, 4, 5, 6, 8 },
                { 3, 5, 6, 9 },    { 4, 7, 8 },
                { 5, 7, 8, 9, 0 }, { 6, 8, 9 } };
 
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (i == 1)
                    dp[i][j] = 1;
                else {
                    for (int prev : data[j])
                        dp[i][j] += dp[i - 1][prev];
                }
            }
        }
        long sum = 0;
        for (int j = 0; j <= 9; j++) {
            sum += dp[N][j];
        }
        return sum;
    }
}