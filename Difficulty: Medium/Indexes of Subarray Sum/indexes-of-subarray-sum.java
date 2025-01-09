//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int i = 0;  // Start from 0
        int j = 0;
        int n = arr.length;
        int sum = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(j < n) {
            sum += arr[j];  // Add current element
            
            // If sum becomes greater, subtract elements from start
            while(sum > target && i < j) {
                sum -= arr[i];
                i++;
            }
            
            // If sum equals target, we found our subarray
            if(sum == target) {
                ans.add(i + 1);  // Adding 1 because question asks for 1-based indexing
                ans.add(j + 1);
                return ans;
            }
            
            j++;
        }
        
        // If no solution found
        ans.add(-1);
        return ans;
    }
}