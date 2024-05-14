class Solution {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length, goldCellId = 0;
        int[][] state = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    state[i][j] = 1 << goldCellId++;
                    queue.offer(new int[]{i, j, grid[i][j], state[i][j]});
                }
            }
        }
        
        int ans = 0;
        int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            ans = Math.max(ans, curr[2]);
            for (int[] dir : DIRS) {
                int nextRow = curr[0] + dir[0], nextCol = curr[1] + dir[1];
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || grid[nextRow][nextCol] == 0 || (curr[3] & state[nextRow][nextCol]) != 0) {
                    continue;
                }
                queue.offer(new int[]{nextRow, nextCol, curr[2] + grid[nextRow][nextCol], curr[3] | state[nextRow][nextCol]});
            }
        }
        return ans;
    }
}