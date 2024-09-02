//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Cell {
    int i, j, x;

    Cell(int i, int j, int x) {
        this.i = i;
        this.j = j;
        this.x = x;
    }
}

class CellComparator implements Comparator<Cell> {
    @Override
    public int compare(Cell c1, Cell c2) {
        return Integer.compare(c1.x, c2.x);
    }
}

class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<Cell> pq = new PriorityQueue<>(new CellComparator());
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        pq.offer(new Cell(0, 0, grid[0][0]));
        dp[0][0] = grid[0][0];

        while (!pq.isEmpty()) {
            Cell temp = pq.poll();

            for (int[] d : dir) {
                int ni = d[0] + temp.i;
                int nj = d[1] + temp.j;
                if (ni < 0 || nj < 0 || ni >= n || nj >= m) continue;

                int nx = grid[ni][nj] + temp.x;
                if (dp[ni][nj] <= nx) continue;
                if (ni == n - 1 && nj == m - 1) return nx;

                dp[ni][nj] = nx;
                pq.offer(new Cell(ni, nj, nx));
            }
        }

        return 0;
    }
}