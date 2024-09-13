//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            long[] a = new long[input.length];

            for (int i = 0; i < input.length; i++) {
                a[i] = Long.parseLong(input[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.minCost(a));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    // Function to return the minimum cost of connecting the ropes.
    public long minCost(long[] arr) {
        // Create a priority queue (min-heap)
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        
        // Insert all ropes into the min-heap
        for (long rope : arr) {
            minHeap.add(rope);
        }
        
        long totalCost = 0;
        
        // While there are more than one rope to connect
        while (minHeap.size() > 1) {
            // Extract the two smallest ropes
            long first = minHeap.poll();
            long second = minHeap.poll();
            
            // Cost to connect these two ropes
            long cost = first + second;
            totalCost += cost;
            
            // Add the new rope (combined length) back into the min-heap
            minHeap.add(cost);
        }
        
        // Return the total cost
        return totalCost;
    }
}