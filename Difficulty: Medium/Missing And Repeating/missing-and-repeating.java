//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        // code here
        int n = arr.length;

        // Step 1: Cyclic sort to place numbers at their correct indices
        for (int i = 0; i < n; i++) {
            while (arr[i] != arr[arr[i] - 1]) {
                // Swap arr[i] with arr[arr[i] - 1] to place arr[i] in the correct position
                int correctIndex = arr[i] - 1;
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
        }

        // Step 2: Identify the repeating and missing number
        int repeatingNumber = -1, missingNumber = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                repeatingNumber = arr[i];
                missingNumber = i + 1;
                break;
            }
        }

        // Step 3: Output the result
        // System.out.println(repeatingNumber + " " + missingNumber);
        return new int[]{repeatingNumber,missingNumber};

    }
}