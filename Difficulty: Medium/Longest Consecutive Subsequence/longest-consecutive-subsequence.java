//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int longestConsecutive(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        Arrays.sort(arr);
        int currentLen = 1;  // Start with 1 to count the first number
        int maxLen = 1;      // Initialize max to 1
        
        for (int i = 1; i < arr.length; i++) {
            // Skip duplicates
            if (arr[i] == arr[i-1]) {
                continue;
            }
            // If consecutive, increment length
            if (arr[i] == arr[i-1] + 1) {
                currentLen++;
                maxLen = Math.max(maxLen, currentLen);
            } else {
                // Reset current length if sequence breaks
                currentLen = 1;
            }
        }
        
        return maxLen;
    }
}