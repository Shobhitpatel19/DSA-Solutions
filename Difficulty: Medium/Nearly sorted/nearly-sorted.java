//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    // Non-static method, so you need to call it on an instance of the class
    public void nearlySorted(int[] arr, int k) {
        // code
        // Min-heap to store at most k+1 elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Add the first k+1 elements to the heap
        int n = arr.length;
        for (int i = 0; i <= k && i < n; i++) {
            minHeap.add(arr[i]);
        }

        // Start placing elements in sorted order
        int index = 0;
        for (int i = k + 1; i < n; i++) {
            arr[index++] = minHeap.poll(); // Place the smallest element at the correct position
            minHeap.add(arr[i]); // Add the current element to the heap
        }

        // Extract remaining elements from the heap and place them
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }
            int k = Integer.parseInt(br.readLine());
            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            // Create an instance of the Solution class
            Solution obj = new Solution();
            // Call nearlySorted on the instance
            obj.nearlySorted(arr, k);

            // Print the sorted array
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();

            // System.out.println("~");
        }
    }
}

// } Driver Code Ends