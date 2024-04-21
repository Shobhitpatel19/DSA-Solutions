class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.get(edge[0]).add(edge[1]);
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == destination) {
                return true;
            }
            if (visited.contains(current)) {
                continue;
            }
            visited.add(current);
            for (int neighbor : graph.get(current)) {
                queue.add(neighbor);
            }
        }
        return false;
    }
}