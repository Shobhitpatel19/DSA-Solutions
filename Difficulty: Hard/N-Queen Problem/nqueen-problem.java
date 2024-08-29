//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // Code Here
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        ArrayList<Integer> board = new ArrayList<>();
        solveNQueens(solutions, board, n);
        return solutions;
    }

    private void solveNQueens(ArrayList<ArrayList<Integer>> solutions, ArrayList<Integer> board, int n) {
        if (board.size() == n) {
            solutions.add(new ArrayList<>(board));
            return;
        }
        
        for (int row = 1; row <= n; row++) {
            if (isSafe(board, row)) {
                board.add(row);
                solveNQueens(solutions, board, n);
                board.remove(board.size() - 1);
            }
        }
    }

    private boolean isSafe(ArrayList<Integer> board, int row) {
        int currentCol = board.size();
        for (int col = 0; col < currentCol; col++) {
            int queenRow = board.get(col);
            // Check if in the same row or on the same diagonal
            if (queenRow == row || Math.abs(queenRow - row) == Math.abs(col - currentCol)) {
                return false;
            }
        }
        return true;
    }
}