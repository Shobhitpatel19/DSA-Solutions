//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // Check if the array is empty
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return -1;
        }

        int numRows = arr.length;
        int numCols = arr[0].length;

        int maxRowIndex = -1;
        int maxCount = 0;

        // Initialize starting point
        int j = numCols - 1;

        // Traverse through each row
        for (int i = 0; i < numRows; i++) {
            // Move left while we have 1's
            while (j >= 0 && arr[i][j] == 1) {
                j--;
                maxRowIndex = i;
            }
        }

        return maxRowIndex;
    }
}
