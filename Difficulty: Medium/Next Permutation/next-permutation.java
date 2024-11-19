//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    void nextPermutation(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        
        int n = arr.length;
        
        // Step 1: Find the first pair from right where arr[i] < arr[i+1]
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        
        // If such pair exists
        if (i >= 0) {
            // Step 2: Find the smallest element in the right part 
            // that is greater than arr[i]
            int j = n - 1;
            while (j > i && arr[j] <= arr[i]) {
                j--;
            }
            
            // Step 3: Swap elements at positions i and j
            swap(arr, i, j);
        }
        
        // Step 4: Reverse the subarray after position i
        reverse(arr, i + 1, n - 1);
    }
    
    // Helper method to swap elements
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // Helper method to reverse subarray
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}



//{ Driver Code Starts.

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution ob = new Solution();
            ob.nextPermutation(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                out.append(arr[i] + " "); // Corrected: use arr[i] instead of arr.get(i)
            }
            System.out.println(out.toString().trim()); // Print the output

            System.out.println("~");
        }
    }
}
// } Driver Code Ends