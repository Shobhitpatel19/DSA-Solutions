//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int[] ans = new int[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int n = arr.length;
        int[] res = new int[n];
        
        // Base case
        if (n < 2) return res;
        
        // Initialize res array with 1s
        res[0] = 1;
        
        // Calculate prefix products
        // res[i] will contain product of all elements to the left of arr[i]
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] * arr[i-1];
        }
        
        // Calculate suffix products and combine with prefix products
        int rightProduct = 1;
        for (int i = n-1; i >= 0; i--) {
            res[i] = res[i] * rightProduct;
            rightProduct *= arr[i];
        }
        
        return res;
    }
}

