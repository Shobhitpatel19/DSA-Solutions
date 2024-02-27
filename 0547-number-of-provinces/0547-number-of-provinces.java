class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                provinces++;
                dfs(isConnected, visited, i);
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int node){
        visited[node] = true;
        for(int nbr=0; nbr<isConnected.length; nbr++){
            if(isConnected[node][nbr] == 1 && !visited[nbr]){
                dfs(isConnected, visited, nbr);
            }
        }
    }
}