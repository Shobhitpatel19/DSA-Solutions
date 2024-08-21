//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Initialize adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Fill the adjacency list
        for (int[] edge : edges) {
            if (edge[0] != edge[1]) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }
        }
        
        // Distance initialization
        int dist = 0;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        // Queue for BFS
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        
        // Visited array
        boolean[] vis = new boolean[n];
        vis[src] = true;
        
        // BFS
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int cur = q.poll();
                ans[cur] = dist;
                
                for (int neighbor : adj.get(cur)) {
                    if (!vis[neighbor]) {
                        vis[neighbor] = true;
                        q.add(neighbor);
                    }
                }
            }
            dist++;
        }
        
        return ans;
    }
}

