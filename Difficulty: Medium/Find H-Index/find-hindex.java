//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(br.readLine().trim());

        while (test_cases-- > 0) {
            // Read the array from input line
            String[] input = br.readLine().trim().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            // Solution instance to invoke the function
            Solution ob = new Solution();
            int result = ob.hIndex(arr);

            System.out.println(result);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to find hIndex
    public int hIndex(int[] citations) {
        int n = citations.length;
        
        // Create a frequency array to count citations
        int[] freq = new int[n + 1];
        
        // Count citations in frequency array
        for (int citation : citations) {
            if (citation >= n) {
                // If citations are more than n, count in the last bucket
                freq[n]++;
            } else {
                // Count citations in appropriate buckets
                freq[citation]++;
            }
        }
        
        // Calculate h-index from right to left
        int total = 0;
        for (int i = n; i >= 0; i--) {
            total += freq[i];
            
            // If total papers with at least i citations is >= i, return i
            if (total >= i) {
                return i;
            }
        }
        
        return 0;
    }
}