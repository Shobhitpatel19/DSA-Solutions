//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int arr[], int k) {
        // HashMap to store the prefix XOR count
        // Key: prefix XOR value, Value: count of occurrences
        HashMap<Integer, Integer> prefixXorCount = new HashMap<>();
        
        int currXor = 0;  // Keep track of current prefix XOR
        long count = 0;   // Count of valid subarrays
        
        // Initialize map with 0 having count 1 (for when the entire prefix equals k)
        prefixXorCount.put(0, 1);
        
        // Iterate through the array
        for (int num : arr) {
            // Calculate current prefix XOR
            currXor ^= num;
            
            // Calculate XOR needed from prefix to get k
            // If curr_prefix_xor ^ x = k, then x = curr_prefix_xor ^ k
            int xorNeeded = currXor ^ k;
            
            // Add the count of prefix XORs that would give us k
            count += prefixXorCount.getOrDefault(xorNeeded, 0);
            
            // Update the prefix XOR count in the map
            prefixXorCount.put(currXor, prefixXorCount.getOrDefault(currXor, 0) + 1);
        }
        
        return count;
    }
}

