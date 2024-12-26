//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    final static int MOD = 1000000007;
    static int uniquePaths(int n, int m, int[][] grid) {
        int[][] dp = new int[n][m];
        
        // If destination is blocked, no paths possible
        if(grid[n-1][m-1] == 0) {
            return 0;
        }
        
        for(int i=n-1; i>=0; i--) {
            for(int j=m-1; j>=0; j--) {
                if(i == n-1 && j == m-1) {
                    dp[i][j] = 1;
                }
                else if(i == n-1) {
                    dp[i][j] = grid[i][j] != 0 ? dp[i][j+1] : 0;
                }
                else if(j == m-1) {
                    dp[i][j] = grid[i][j] != 0 ? dp[i+1][j] : 0;
                }
                else {
                    if(grid[i][j] != 0) {
                        dp[i][j] = ((dp[i+1][j] + dp[i][j+1]) % MOD + MOD) % MOD;
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }
        return dp[0][0];
    }
}