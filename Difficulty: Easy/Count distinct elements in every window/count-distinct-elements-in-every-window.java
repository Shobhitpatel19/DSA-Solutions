//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer> ans = new Solution().countDistinct(arr, k);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Initialize the first window
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        result.add(map.size());
        
        // Slide the window
        for (int i = k; i < arr.length; i++) {
            // Remove the first element of the previous window
            int outgoing = arr[i - k];
            if (map.get(outgoing) == 1) {
                map.remove(outgoing);
            } else {
                map.put(outgoing, map.get(outgoing) - 1);
            }
            
            // Add the new element of the current window
            int incoming = arr[i];
            map.put(incoming, map.getOrDefault(incoming, 0) + 1);
            
            // Add the count of distinct elements in the current window
            result.add(map.size());
        }
        
        return result;
    }
}



