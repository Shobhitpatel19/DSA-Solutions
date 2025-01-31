//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = 9;
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.solveSudoku(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        backtrack(mat, 0, 0);
    }

    private static boolean backtrack(int[][] mat, int row, int col) {
        // If all rows are processed, the Sudoku is solved.
        if (row == 9) {
            return true;
        }
        
        // Calculate next cell's position
        int nextRow = col == 8 ? row + 1 : row;
        int nextCol = (col + 1) % 9;
        
        // If current cell is already filled, proceed to next cell
        if (mat[row][col] != 0) {
            return backtrack(mat, nextRow, nextCol);
        }
        
        // Try all possible numbers from 1 to 9
        for (int num = 1; num <= 9; num++) {
            if (isValid(mat, row, col, num)) {
                mat[row][col] = num;
                if (backtrack(mat, nextRow, nextCol)) {
                    return true;
                }
                mat[row][col] = 0; // backtrack
            }
        }
        return false; // trigger backtracking
    }

    private static boolean isValid(int[][] mat, int row, int col, int num) {
        // Check row
        for (int c = 0; c < 9; c++) {
            if (mat[row][c] == num) {
                return false;
            }
        }
        
        // Check column
        for (int r = 0; r < 9; r++) {
            if (mat[r][col] == num) {
                return false;
            }
        }
        
        // Check sub-box
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (mat[boxRow + r][boxCol + c] == num) {
                    return false;
                }
            }
        }
        
        return true;
    }
}