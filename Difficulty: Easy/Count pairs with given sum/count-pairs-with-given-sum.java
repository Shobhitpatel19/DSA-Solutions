//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {

    int countPairs(int arr[], int target) {
        // Your code here
        // HashMap to store frequency of numbers
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        // Iterate through the array
        for(int num : arr) {
            // For each number, find how many numbers exist that when added to current number
            // equals target (i.e., find frequency of (target - num))
            count += map.getOrDefault(target - num, 0);
            
            // Add current number to HashMap or increase its frequency
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        return count;
    }
}


//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine());

            Solution obj = new Solution();

            System.out.println(obj.countPairs(nums, target));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends