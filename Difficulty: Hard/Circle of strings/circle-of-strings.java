//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Helper function to perform DFS
    private void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj);
            }
        }
    }

    // Helper function to check if the graph is strongly connected
    private boolean isStronglyConnected(List<List<Integer>> adj, List<List<Integer>> revAdj, int[] inDegree, int[] outDegree) {
        int start = -1;
        // Find the first character with a non-zero degree
        for (int i = 0; i < 26; i++) {
            if (outDegree[i] > 0) {
                start = i;
                break;
            }
        }
        if (start == -1) return true; // No strings, trivial case

        // DFS on the original graph
        boolean[] visited = new boolean[26];
        dfs(start, visited, adj);
        for (int i = 0; i < 26; i++) {
            if (outDegree[i] > 0 && !visited[i]) {
                return false; // If any node with an edge is not visited
            }
        }

        // DFS on the reversed graph
        visited = new boolean[26];
        dfs(start, visited, revAdj);
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] > 0 && !visited[i]) {
                return false; // If any node with an edge is not visited
            }
        }

        return true;
    }

    public int isCircle(String arr[]) {
        int n = arr.length;
        if (n == 0) return 0;

        // Initialize adjacency lists for the graph and reverse graph
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
            revAdj.add(new ArrayList<>());
        }

        // In-degree and out-degree arrays
        int[] inDegree = new int[26];
        int[] outDegree = new int[26];

        // Construct the graph
        for (String s : arr) {
            int first = s.charAt(0) - 'a';
            int last = s.charAt(s.length() - 1) - 'a';
            adj.get(first).add(last);
            revAdj.get(last).add(first);
            outDegree[first]++;
            inDegree[last]++;
        }

        // Check if every vertex with non-zero degree has equal in-degree and out-degree
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] != outDegree[i]) {
                return 0;
            }
        }

        // Check if the graph is strongly connected
        if (isStronglyConnected(adj, revAdj, inDegree, outDegree)) {
            return 1;
        } else {
            return 0;
        }
    }
}
