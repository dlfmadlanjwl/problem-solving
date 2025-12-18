import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int r = Integer.parseInt(stringTokenizer.nextToken());
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] depths = bfs(graph, r);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < depths.length; i++) {
            stringBuilder.append(depths[i]).append("\n");
        }
        System.out.println(stringBuilder);
    }

    static int[] bfs(List<Integer>[] graph, int root) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[graph.length];
        queue.add(root);
        isVisited[root] = true;
        int[] depth = new int[graph.length];
        Arrays.fill(depth, -1);
        depth[root] = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < graph[now].size(); i++) {
                int next = graph[now].get(i);
                if (isVisited[next]) {
                    continue;
                }
                isVisited[next] = true;
                queue.add(next);
                depth[next] = depth[now] + 1;
            }
        }

        return depth;
    }


}