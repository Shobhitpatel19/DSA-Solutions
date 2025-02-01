//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    static public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;
        
        // Iterate through each cell in the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the first character matches, start DFS
                if (mat[i][j] == word.charAt(0) && dfs(mat, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean dfs(char[][] mat, int i, int j, String word, int index) {
        // If the entire word is matched
        if (index == word.length()) {
            return true;
        }
        
        // Check boundaries and if the current cell matches the current character in the word
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] != word.charAt(index)) {
            return false;
        }
        
        // Mark the cell as visited by changing its value
        char temp = mat[i][j];
        mat[i][j] = '#';
        
        // Explore all four directions
        boolean found = dfs(mat, i + 1, j, word, index + 1) ||
                        dfs(mat, i - 1, j, word, index + 1) ||
                        dfs(mat, i, j + 1, word, index + 1) ||
                        dfs(mat, i, j - 1, word, index + 1);
        
        // Backtrack: unmark the cell as visited
        mat[i][j] = temp;
        
        return found;
    }
}