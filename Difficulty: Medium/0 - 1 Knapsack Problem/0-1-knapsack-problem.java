//{ Driver Code Starts
import java.io.*;
import java.util.*;

class gfg {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int w = Integer.parseInt(br.readLine());

            String line = br.readLine();
            String[] tokens = line.split(" ");
            List<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] val = new int[array.size()];
            int idx = 0;
            for (int i : array) val[idx++] = i;

            String lin = br.readLine();
            String[] toke = lin.split(" ");
            List<Integer> array1 = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : toke) {
                array1.add(Integer.parseInt(token));
            }

            int[] wt = new int[array1.size()];
            idx = 0;
            for (int i : array1) wt[idx++] = i;

            // calling method knapSack() of class Solution
            System.out.println(new Solution().knapSack(w, wt, val));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int help(int n,int w,int wt[],int val[],int index,int dp[][]){
        if(index==n)return 0;
        if(dp[index][w]!=-1)return dp[index][w];
        int nonPick=0,pick=0;
        nonPick = help(n,w,wt,val,index+1,dp);
        if(w>=wt[index]){
            pick = val[index]+help(n,w-wt[index],wt,val,index+1,dp);
        }
        return dp[index][w] = Math.max(nonPick,pick);
    }
    
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        // your code here
        int n = wt.length;
        int dp[][] = new int[n][W+1];
        for(int temp[]:dp){
            Arrays.fill(temp,-1);
        }
        return help(n,W,wt,val,0,dp);
    }
}
