import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int cheeseCount = 0;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheeseCount++;
                }
            }
        }

        int count = 0;
        int lastCheese = 0;
        while (cheeseCount != 0) {
            count++;
            lastCheese = cheeseCount;
            bfs(map);
        }
        System.out.println(count);
        System.out.println(lastCheese);
    }

    static void bfs(int[][] map) {
        boolean[][] isVisited = new boolean[map.length][map[0].length];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));
        isVisited[0][0] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];
                if (newY < 0 || newY >= map.length || newX < 0 || newX >= map[0].length) {
                    continue;
                }
                if (isVisited[newY][newX]) {
                    continue;
                }
                if (map[newY][newX] == 0) {
                    q.add(new Node(newY, newX, now.depth + 1));
                } else {
                    map[newY][newX] = 0;
                    cheeseCount--;
                }
                isVisited[newY][newX] = true;
            }
        }
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