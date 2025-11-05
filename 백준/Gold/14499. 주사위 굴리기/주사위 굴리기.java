import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    private static int[][] map;
    private static int[] dice = new int[7];
    private static int y;
    private static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        y = Integer.parseInt(stringTokenizer.nextToken());
        x = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int[] commands = new int[k];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < k; i++) {
            commands[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int command : commands) {
            move(command);
        }
    }

    private static void process() {
        if (map[y][x] == 0) {
            map[y][x] = dice[6];
        } else {
            dice[6] = map[y][x];
            map[y][x] = 0;
        }
    }

    private static void move(int command) {
        if (command == 1) {
            if (x == map[0].length - 1) {
                return;
            }
            x++;
            int tmp = dice[3];
            dice[3] = dice[1];
            dice[1] = dice[4];
            dice[4] = dice[6];
            dice[6] = tmp;
        } else if (command == 2) {
            if (x == 0) {
                return;
            }
            x--;
            int tmp = dice[6];
            dice[6] = dice[4];
            dice[4] = dice[1];
            dice[1] = dice[3];
            dice[3] = tmp;
        } else if (command == 3) {
            if (y == 0) {
                return;
            }
            y--;
            int tmp = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[6];
            dice[6] = tmp;
        } else {
            if (y == map.length - 1) {
                return;
            }
            y++;
            int tmp = dice[6];
            dice[6] = dice[5];
            dice[5] = dice[1];
            dice[1] = dice[2];
            dice[2] = tmp;
        }
        System.out.println(dice[1]);
        process();
    }
}
