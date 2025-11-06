import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    private static char[][] room;
    private static boolean[] isVisited = new boolean[25];
    private static int[] dy = {1, -1, 0, 0};
    private static int[] dx = {0, 0, 1, -1};
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        room = new char[5][5];
        for (int i = 0; i < 5; i++) {
            char[] input = bufferedReader.readLine().toCharArray();
            System.arraycopy(input, 0, room[i], 0, 5);
        }

        combine(0, 0);

        System.out.println(answer);
    }

    private static void combine(int startIndex, int count) {
        if (count == 7) {
            int[][] arr = new int[5][5];
            int sCount = 0;
            int check = 0;
            int y = 0;
            int x = 0;
            for (int i = 0; i < 25; i++) {
                if (isVisited[i]) {
                    arr[i / 5][i % 5] = 1;
                    if (room[i / 5][i % 5] == 'S') {
                        sCount++;
                    }
                    if (check == 0) {
                        y = i / 5;
                        x = i % 5;
                    }
                    check++;
                }
            }
            if (sCount >= 4) {
                bfs(arr, y, x);
            }
            return;
        }

        for (int i = startIndex; i < 25; i++) {
            isVisited[i] = true;
            combine(i + 1, count + 1);
            isVisited[i] = false;
        }
    }

    private static void bfs(int[][] arr, int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x));
        boolean[][] isVisited = new boolean[5][5];
        isVisited[y][x] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (count == 7) {
                answer++;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];
                if (newY < 0 || newY >= 5 || newX < 0 || newX >= 5 || isVisited[newY][newX] || arr[newY][newX] != 1) {
                    continue;
                }
                queue.add(new Node(newY, newX));
                count++;
                isVisited[newY][newX] = true;
            }
        }
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