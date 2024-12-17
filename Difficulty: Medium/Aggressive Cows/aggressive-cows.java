//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // Sort the stalls array to work with ordered positions
        Arrays.sort(stalls);
        
        // Define the search space
        int left = 1; // Minimum possible distance
        int right = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        
        // Binary search to find the maximum minimum distance
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Check if we can place k cows with mid as minimum distance
            if (canPlaceCows(stalls, k, mid)) {
                // If possible, try to maximize the distance
                result = mid;
                left = mid + 1;
            } else {
                // If not possible, reduce the distance
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    // Helper method to check if k cows can be placed with given minimum distance
    private static boolean canPlaceCows(int[] stalls, int k, int minDistance) {
        // Place the first cow at the first stall
        int cowsPlaced = 1;
        int lastPlacedPosition = stalls[0];
        
        // Try to place remaining cows
        for (int i = 1; i < stalls.length; i++) {
            // If distance between current stall and last placed cow is >= minDistance
            if (stalls[i] - lastPlacedPosition >= minDistance) {
                // Place a cow here
                cowsPlaced++;
                lastPlacedPosition = stalls[i];
                
                // If all cows are placed, return true
                if (cowsPlaced == k) {
                    return true;
                }
            }
        }
        
        // Return false if we couldn't place all k cows
        return false;
    }
}