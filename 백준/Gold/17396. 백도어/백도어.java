import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    private static List<Edge>[] costs;
    private static long[] distances;
    private static boolean[] isVisible;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        isVisible = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (stringTokenizer.nextToken().equals("1")) {
                isVisible[i] = true;
            }
        }
        distances = new long[n];
        for (int i = 1; i < distances.length; i++) {
            distances[i] = Long.MAX_VALUE;
        }
        costs = new List[n];
        for (int i = 0; i < costs.length; i++) {
            costs[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int t = Integer.parseInt(stringTokenizer.nextToken());
            costs[a].add(new Edge(b, t));
            costs[b].add(new Edge(a, t));
        }

        dijkstra();
        System.out.println(distances[n - 1] == Long.MAX_VALUE ? -1 : distances[n - 1]);
    }

    private static void dijkstra() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (Integer o1, Integer o2) -> Long.compare(distances[o1], distances[o2]));
        boolean[] visited = new boolean[distances.length];
        pq.add(0);

        while (!pq.isEmpty()) {
            Integer now = pq.poll();

            if (visited[now]) {
                continue;
            }
            visited[now] = true;

            for (Edge edge : costs[now]) {
                if (isVisible[edge.dest] && edge.dest != isVisible.length - 1) {
                    continue;
                }
                if (distances[edge.dest] > distances[now] + edge.cost) {
                    distances[edge.dest] = distances[now] + edge.cost;
                    pq.add(edge.dest);
                }
            }
        }
    }

    private static class Edge {
        int dest;
        long cost;

        public Edge(int dest, long cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}