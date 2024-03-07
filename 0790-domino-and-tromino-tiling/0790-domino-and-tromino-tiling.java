class Solution {
    // Tabulation
    int MOD = 1000000007;
    public int numTilings(int n) {
        if (n <= 2)
            return n;
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for (int i = 4; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] % MOD + dp[i - 3] % MOD) % MOD;
        }

        return dp[n];
    }
}


// Memoization : 
// class Solution {
//     int MOD = 1000000007;

//     public int solve(int[] dp, int n) {
//         if (dp[n] != -1) {
//             return dp[n];
//         }

//         dp[n] = (2 * solve(dp, n - 1) % MOD + solve(dp, n - 3) % MOD) % MOD;
//         return dp[n];
//     }

//     public int numTilings(int n) {
//         if (n <= 2) {
//             return n;
//         }

//         int[] dp = new int[n + 1];
//         Arrays.fill(dp, -1);
//         dp[0] = 1; // Base case for n=0, there's only oneway to tile (empty board)
//         dp[1] = 1; // Base case for n=1, there's only one way to tile (one vertical domino)
//         dp[2] = 2; // Base case for n=2, there are two ways to tile (two horizontal dominoes or one tromino)

//         return solve(dp, n);
//     }
// }
