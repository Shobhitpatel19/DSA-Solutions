//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            new Solution().setMatrixZeroes(arr);
            for (int[] row : arr) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean fr = false, fc = false;
        
        // Mark in first row/column and track their status
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    mat[0][j] = mat[i][0] = 0;
                }
            }
        }
        
        // Process all cells except first row/column
        for(int i = m-1; i > 0; i--) {
            for(int j = n-1; j > 0; j--) {
                if(mat[0][j] == 0 || mat[i][0] == 0) {
                    mat[i][j] = 0;
                }
            }
        }
        
        // Set first row/column based on saved states
        if(fc) for(int i = 0; i < m; i++) mat[i][0] = 0;
        if(fr) for(int j = 0; j < n; j++) mat[0][j] = 0;
    }
}