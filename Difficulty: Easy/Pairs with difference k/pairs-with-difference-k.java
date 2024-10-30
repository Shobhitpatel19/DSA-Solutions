//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
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

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.countPairsWithDiffK(arr, k);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    int countPairsWithDiffK(int[] arr, int k) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        // Populate the map with frequencies of each element
        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        // Iterate over the map to find pairs with difference k
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getKey();
            int frequency = entry.getValue();

            // Check if val + k exists in the map
            if (map.containsKey(val + k)) {
                count += frequency * map.get(val + k);
            }

            // Check if val - k exists in the map
            if (map.containsKey(val - k)) {
                count += frequency * map.get(val - k);
            }
        }

        // Since each pair is counted twice, divide the result by 2
        return count / 2;
    }
}