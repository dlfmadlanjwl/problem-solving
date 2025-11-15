import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int d = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            List<Edge>[] graph = new List[n + 1];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < d; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());
                int s = Integer.parseInt(stringTokenizer.nextToken());
                graph[b].add(new Edge(a, s));
            }

            int[] distances = dijkstra(graph, c);
            int max = Integer.MIN_VALUE;
            int count = 0;
            for (int distance : distances) {
                if (distance == Integer.MAX_VALUE) {
                    continue;
                }
                count++;
                max = Math.max(max, distance);
            }

            stringBuilder.append(count).append(" ").append(max).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int[] dijkstra(List<Edge>[] graph, int start) {
        int[] distances = new int[graph.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> distances[o1] - distances[o2]);
        boolean[] isVisited = new boolean[graph.length + 1];
        pq.add(start);
        isVisited[start] = true;
        while (!pq.isEmpty()) {
            Integer now = pq.poll();
            isVisited[now] = true;
            for (Edge edge : graph[now]) {
                if (isVisited[edge.dest]) {
                    continue;
                }
                if (distances[edge.dest] > distances[now] + edge.cost) {
                    distances[edge.dest] = distances[now] + edge.cost;
                    pq.add(edge.dest);
                }
            }
        }

        return distances;
    }

    private static class Edge {
        int dest;
        int cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}