//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Directions for 8 possible moves (up, down, left, right and the 4 diagonals)
    private final int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    private final int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    // Function to check if the given cell is within the grid boundaries and is a land (i.e., '1')
    private boolean isValid(int x, int y, char[][] grid, boolean[][] visited) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1' && !visited[x][y];
    }

    // Function to perform BFS to mark the connected land cells
    private void bfs(int x, int y, char[][] grid, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int currX = cell[0];
            int currY = cell[1];

            // Explore all 8 possible directions
            for (int i = 0; i < 8; i++) {
                int newX = currX + dx[i];
                int newY = currY + dy[i];

                if (isValid(newX, newY, grid, visited)) {
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
    }

    // Main function to count the number of islands
    public int numIslands(char[][] grid) {
        int n = grid.length;        // Number of rows
        int m = grid[0].length;     // Number of columns
        
        boolean[][] visited = new boolean[n][m];  // To keep track of visited cells
        int count = 0;  // Island counter

        // Traverse each cell in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the cell is land and not visited, it's part of a new island
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;  // Increment the island count
                    bfs(i, j, grid, visited);  // Perform BFS to mark all connected lands
                }
            }
        }

        return count;  // Return the total number of islands
    }
}


