//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countTriangles(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        int n = arr.length;
        // Sort array in ascending order
        Arrays.sort(arr);
        
        int count = 0;
        
        // Check for all possible combinations
        // We start from the largest possible side
        for (int i = n-1; i >= 2; i--) {
            // Use two pointers for remaining two sides
            int left = 0;
            int right = i-1;
            
            while (left < right) {
                // If sum of two sides is greater than third side
                if (arr[left] + arr[right] > arr[i]) {
                    // All values between left and right will also form triangles
                    count += right - left;
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        
        return count;
    }
}