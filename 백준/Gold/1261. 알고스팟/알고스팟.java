import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    private static int[][] maze;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] input = bufferedReader.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                maze[i][j] = input[j] - '0';
            }
        }

        int[][] costs = bfs();
        System.out.println(costs[costs.length - 1][costs[0].length - 1]);
    }

    private static int[][] bfs() {
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        Queue<Node> queue = new LinkedList<>();
        int[][] costs = new int[maze.length][maze[0].length];
        for (int i = 0; i < costs.length; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }
        queue.add(new Node(0, 0, 0));
        costs[0][0] = 0;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];
                if (newY < 0 || newY >= maze.length || newX < 0 || newX >= maze[0].length) {
                    continue;
                }
                if (costs[newY][newX] > now.depth + maze[newY][newX]) {
                    costs[newY][newX] = now.depth + maze[newY][newX];
                } else {
                    continue;
                }
                if (maze[newY][newX] == 1) {
                    queue.add(new Node(newY, newX, now.depth + 1));
                } else if (maze[newY][newX] == 0) {
                    queue.add(new Node(newY, newX, now.depth));
                }
            }
        }
        return costs;
    }

    private static class Node {
        int y;
        int x;
        int depth;

        public Node(int y, int x, int depth) {
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }
}