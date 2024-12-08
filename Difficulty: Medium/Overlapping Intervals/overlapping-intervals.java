//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String temp[] = br.readLine().trim().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                String x = temp[1];
                arr[i][1] = Integer.parseInt(x);
            }
            Solution obj = new Solution();
            // The mergeOverlap function now returns a List<int[]>
            List<int[]> ans = obj.mergeOverlap(arr);

            // Printing the merged arr
            for (int[] interval : ans) {
                System.out.print(interval[0] + " " + interval[1] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // If the input array is empty or null, return empty list
        if (arr == null || arr.length <= 1) {
            return new ArrayList<>(Arrays.asList(arr));
        }
        
        // Sort the intervals based on start times
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        // List to store merged intervals
        List<int[]> merged = new ArrayList<>();
        
        // Add the first interval to the list
        merged.add(arr[0]);
        
        // Iterate through the remaining intervals
        for (int i = 1; i < arr.length; i++) {
            // Get the last interval in the merged list
            int[] lastInterval = merged.get(merged.size() - 1);
            
            // Current interval
            int[] currentInterval = arr[i];
            
            // If current interval overlaps with the last interval, merge them
            if (currentInterval[0] <= lastInterval[1]) {
                // Update the end time of the last interval to the maximum of the two
                lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
            } 
            // If no overlap, add the current interval to the list
            else {
                merged.add(currentInterval);
            }
        }
        
        return merged;
    }
}

