import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int robotY = Integer.parseInt(stringTokenizer.nextToken());
        int robotX = Integer.parseInt(stringTokenizer.nextToken());
        int[] rawDirections = {0, 3, 2, 1};
        int direction = rawDirections[Integer.parseInt(stringTokenizer.nextToken())];

        int[][] room = new int[n][m];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int count = 0;
        boolean end = false;
        while (!end) {
            if (room[robotY][robotX] == 0) {
                room[robotY][robotX] = 2;
                count++;
            }

            boolean canMove = false;
            for (int i = direction + 1; i < direction + dy.length + 1; i++) {
                int newY = robotY + dy[i % dy.length];
                int newX = robotX + dx[i % dx.length];
                if (newY < 0 || newY >= room.length || newX < 0 || newX >= room[0].length) {
                    continue;
                }
                if (room[newY][newX] == 0) {
                    robotY = newY;
                    robotX = newX;
                    direction = i % dy.length;
                    canMove = true;
                    break;
                }
            }

            if (!canMove) {
                int newY = robotY -= dy[direction];
                int newX = robotX -= dx[direction];
                if (newY < 0 || newY >= room.length || newX < 0 || newX >= room[0].length || room[newY][newX] == 1) {
                    end = true;
                }
            }
        }
        System.out.println(count);
    }
}
