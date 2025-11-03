import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int height = Integer.parseInt(stringTokenizer.nextToken());
        int width = Integer.parseInt(stringTokenizer.nextToken());
        char[][] map = new char[height][width];
        for (int i = 0; i < height; i++) {
            char[] splitInput = bufferedReader.readLine().toCharArray();
            for (int j = 0; j < width; j++) {
                map[i][j] = splitInput[j];
            }
        }

        int max = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] == 'W') {
                    continue;
                }
                int depth = bfs(map, i, j);
                max = Math.max(depth, max);
            }
        }
        System.out.println(max);
    }

    private static int bfs(char[][] map, int y, int x) {
        boolean[][] isVisited = new boolean[map.length][map[0].length];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x, 0));
        isVisited[y][x] = true;
        int max = 0;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            max = Math.max(max, now.depth);
            for (int i = 0; i < dy.length; i++) {
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];
                if (newY < 0 || newX < 0 || newY >= map.length || newX >= map[0].length) {
                    continue;
                }
                if (isVisited[newY][newX] || map[newY][newX] != 'L') {
                    continue;
                }
                queue.add(new Node(newY, newX, now.depth + 1));
                isVisited[newY][newX] = true;
            }
        }
        return max;
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