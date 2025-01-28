class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxFish = 0;
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] > 0) {
                    int currentFish = bfs(grid, r, c, m, n);
                    maxFish = Math.max(maxFish, currentFish);
                }
            }
        }
        
        return maxFish;
    }
    
    private int bfs(int[][] grid, int r, int c, int m, int n) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        int sum = grid[r][c];
        grid[r][c] = 0; // Mark as visited
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] > 0) {
                    sum += grid[nx][ny];
                    grid[nx][ny] = 0; // Mark as visited
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        
        return sum;
    }
}