//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;
        
        while (left < right) {
            // If left height is smaller, process left side
            if (arr[left] < arr[right]) {
                // If current height is greater than leftMax, update leftMax
                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else {
                    // Add trapped water for current position
                    result += leftMax - arr[left];
                }
                left++;
            }
            // If right height is smaller or equal, process right side
            else {
                // If current height is greater than rightMax, update rightMax
                if (arr[right] >= rightMax) {
                    rightMax = arr[right];
                } else {
                    // Add trapped water for current position
                    result += rightMax - arr[right];
                }
                right--;
            }
        }
        
        return result;
    }
}
