class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            if (i < n - 1) {
                graph.get(i).add(new int[] {i + 1, 1});
            }
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            graph.get(u).add(new int[] {v, 1});

            answer[i] = dijkstra(graph, n);
        }

        return answer;
    }

    private int dijkstra(List<List<int[]>> graph, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] {0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > dist[u]) continue;

            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int weight = edge[1];
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[] {v, dist[v]});
                }
            }
        }

        return dist[n - 1];
    }
}