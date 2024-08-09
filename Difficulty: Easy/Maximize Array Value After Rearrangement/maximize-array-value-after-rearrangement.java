//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
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

            // int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().Maximize(arr));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int mod = 1000000007;

    int Maximize(int arr[]) {
        Arrays.sort(arr);
        int n = arr.length;

        // Precompute prefix sum
        long[] prefixSum = new long[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = (prefixSum[i - 1] + arr[i]) % mod;
        }

        // Calculate the final sum
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + (prefixSum[i] - (i > 0 ? prefixSum[i - 1] : 0)) * i) % mod;
        }

        return (int) sum;
    }
}

