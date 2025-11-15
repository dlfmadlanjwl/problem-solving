import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int t = 1;
        while (true) {
            int n = Integer.parseInt(bufferedReader.readLine());
            if (n == 0) {
                break;
            }
            int[][] cave = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j < n; j++) {
                    cave[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            stringBuilder.append("Problem ").append(t++).append(": ").append(dijkstra(cave)).append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static int dijkstra(int[][] cave) {
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        int[][] costs = new int[cave.length][cave[0].length];
        for (int[] cost : costs) {
            Arrays.fill(cost, Integer.MAX_VALUE);
        }
        costs[0][0] = cave[0][0];
        boolean[][] isVisited = new boolean[cave.length][cave[0].length];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> costs[o1.y][o1.x] - costs[o2.y][o2.x]);
        pq.add(new Node(0, 0));
        isVisited[0][0] = true;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            for (int i = 0; i < 4; i++) {
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];
                if (newY < 0 || newX < 0 || newY >= cave.length || newX >= cave[0].length) {
                    continue;
                }
                if (isVisited[newY][newX]) {
                    continue;
                }
                if (costs[newY][newX] > costs[now.y][now.x] + cave[newY][newX]) {
                    costs[newY][newX] = costs[now.y][now.x] + cave[newY][newX];
                    pq.add(new Node(newY, newX));
                    isVisited[newY][newX] = true;
                }
            }
        }

        return costs[cave.length - 1][cave[0].length - 1];
    }

    private static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}