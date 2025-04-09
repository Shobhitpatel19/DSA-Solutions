//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.articulationPoints(V, edges);
            Collections.sort(ans);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        boolean[] isAP = new boolean[V]; // To mark articulation points

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);

        // Timer for discovery time
        int time = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, disc, low, parent, isAP, time);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isAP[i]) result.add(i);
        }
        return result.size() == 0 ? new ArrayList<>(Arrays.asList(-1)) : result;
    }

    static void dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited,
                    int[] disc, int[] low, int[] parent, boolean[] isAP, int time) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                dfs(v, adj, visited, disc, low, parent, isAP, time);

                low[u] = Math.min(low[u], low[v]);

                if (parent[u] == -1 && children > 1)
                    isAP[u] = true;

                if (parent[u] != -1 && low[v] >= disc[u])
                    isAP[u] = true;
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
