//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minRemoval(a);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minRemoval(int intervals[][]) {
        // code here
        // If there are no intervals or only one interval, no removal needed
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }
        
        // Sort intervals based on end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        // Keep track of the count of removals and the end of the last non-overlapping interval
        int removals = 0;
        int prevEnd = intervals[0][1];
        
        // Iterate through sorted intervals
        for (int i = 1; i < intervals.length; i++) {
            // If current interval starts before previous interval ends, it's overlapping
            if (intervals[i][0] < prevEnd) {
                // Increment removals
                removals++;
            } else {
                // Update previous end to current interval's end
                prevEnd = intervals[i][1];
            }
        }
        
        return removals;
    }
}
