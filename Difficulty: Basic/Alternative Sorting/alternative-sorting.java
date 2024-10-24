//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().alternateSort(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static ArrayList<Integer> alternateSort(int[] arr) {
        // Your code goes here
        // Step 1: Sort the array
        Arrays.sort(arr);
        
        // Step 2: Initialize result array
        ArrayList<Integer> result = new ArrayList<>();
        
        // Step 3: Use two pointers
        int i = 0; // Pointer to the smallest element
        int j = arr.length - 1; // Pointer to the largest element
        
        // Step 4: Alternate between largest and smallest
        while (i <= j) {
            if (j >= i) {
                result.add(arr[j--]); // Add the largest remaining element
            }
            if (i <= j) {
                result.add(arr[i++]); // Add the smallest remaining element
            }
        }
        
        return result;
    }
}
