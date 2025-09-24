import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] map = new int[n][n];
        StringTokenizer stringTokenizer;
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        boolean answer = bfs(map);
        if (answer) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    private static boolean bfs(int[][] map) {
        Position position = new Position(0, 0);
        Queue<Position> queue = new LinkedList<>();
        queue.add(position);
        while (!queue.isEmpty()) {
            Position now = queue.poll();
            int distance = map[now.y][now.x];
            if (now.y + distance == map.length - 1 && now.x == map.length - 1) {
                return true;
            }
            if (now.y == map.length - 1 && now.x + distance == map.length - 1) {
                return true;
            }
            if (distance == 0) {
                return false;
            }
            if (now.y + distance < map.length) {
                queue.add(new Position(now.y + distance, now.x));
            }
            if (now.x + distance < map.length) {
                queue.add(new Position(now.y, now.x + distance));
            }
        }
        return false;
    }

    private static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}