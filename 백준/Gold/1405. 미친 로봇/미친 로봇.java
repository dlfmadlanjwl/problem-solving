import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    private static int n;
    private static double sum;
    private static boolean[][] isVisited;
    private static double[] news = new double[4];
    private static int[] dy = {0, 0, 1, -1};
    private static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < 4; i++) {
            news[i] = 0.01 * Integer.parseInt(stringTokenizer.nextToken());
        }
        int[][] map = new int[n * 2 + 1][n * 2 + 1];
        isVisited = new boolean[map.length][map[0].length];

        dfs(map, n, n, 0, 1);
        System.out.printf("%.9f", sum);
    }

    private static void dfs(int[][] map, int y, int x, int depth, double percent) {
        if (depth == n) {
            sum += percent;
            return;
        }

        isVisited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (isVisited[newY][newX]) {
                continue;
            }
            dfs(map, newY, newX, depth + 1, percent * news[i]);
        }
        isVisited[y][x] = false;
    }
}