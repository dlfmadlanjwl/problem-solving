import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    private static boolean isEnd = false;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        bfs(board);

        System.out.println(isEnd ? 1 : 0);
    }

    private static void bfs(char[][] board) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(board, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.depth == 10) {
                return;
            }
            for (int i = 0; i < 4; i++) {
                char[][] newBoard = new char[now.board.length][now.board[0].length];
                for (int j = 0; j < now.board.length; j++) {
                    System.arraycopy(now.board[j], 0, newBoard[j], 0, now.board[j].length);
                }
                boolean canMove = move(newBoard, i);
                if (isEnd) {
                    return;
                }
                if (canMove) {
                    queue.add(new Node(newBoard, now.depth + 1));
                }
            }
        }
    }

    private static void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean move(char[][] board, int direction) {
        if (direction == 0) {
            return moveTop(board);
        } else if (direction == 1) {
            return moveLeft(board);
        } else if (direction == 2) {
            return moveRight(board);
        } else {
            return moveBottom(board);
        }
    }

    private static boolean moveTop(char[][] board) {
        boolean redFall = false;
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                int nowY = i;
                int nowX = j;
                if (board[nowY][nowX] == 'R') {
                    while (board[nowY][nowX] == 'R' && board[nowY - 1][nowX] == '.') {
                        board[nowY][nowX] = '.';
                        board[nowY - 1][nowX] = 'R';
                        nowY--;
                    }
                    if (board[nowY - 1][nowX] == 'O') {
                        redFall = true;
                        board[nowY][nowX] = '.';
                    }
                } else if (board[nowY][nowX] == 'B') {
                    while (board[nowY][nowX] == 'B' && board[nowY - 1][nowX] == '.') {
                        board[nowY][nowX] = '.';
                        board[nowY - 1][nowX] = 'B';
                        nowY--;
                    }
                    if (board[nowY - 1][nowX] == 'O') {
                        return false;
                    }
                }
            }
        }
        if (redFall) {
            isEnd = true;
        }
        return true;
    }

    private static boolean moveBottom(char[][] board) {
        boolean redFall = false;
        for (int i = board.length - 2; i >= 1; i--) {
            for (int j = 1; j < board[0].length; j++) {
                int nowY = i;
                int nowX = j;
                if (board[nowY][nowX] == 'R') {
                    while (board[nowY][nowX] == 'R' && board[nowY + 1][nowX] == '.') {
                        board[nowY][nowX] = '.';
                        board[nowY + 1][nowX] = 'R';
                        nowY++;
                    }
                    if (board[nowY + 1][nowX] == 'O') {
                        redFall = true;
                        board[nowY][nowX] = '.';
                    }
                } else if (board[nowY][nowX] == 'B') {
                    while (board[nowY][nowX] == 'B' && board[nowY + 1][nowX] == '.') {
                        board[nowY][nowX] = '.';
                        board[nowY + 1][nowX] = 'B';
                        nowY++;
                    }
                    if (board[nowY + 1][nowX] == 'O') {
                        return false;
                    }
                }
            }
        }
        if (redFall) {
            isEnd = true;
        }
        return true;
    }

    private static boolean moveLeft(char[][] board) {
        boolean redFall = false;
        for (int i = 1; i < board[0].length; i++) {
            for (int j = 1; j < board.length; j++) {
                int nowY = j;
                int nowX = i;
                if (board[nowY][nowX] == 'R') {
                    while (board[nowY][nowX] == 'R' && board[nowY][nowX - 1] == '.') {
                        board[nowY][nowX] = '.';
                        board[nowY][nowX - 1] = 'R';
                        nowX--;
                    }
                    if (board[nowY][nowX - 1] == 'O') {
                        redFall = true;
                        board[nowY][nowX] = '.';
                    }
                } else if (board[nowY][nowX] == 'B') {
                    while (board[nowY][nowX] == 'B' && board[nowY][nowX - 1] == '.') {
                        board[nowY][nowX] = '.';
                        board[nowY][nowX - 1] = 'B';
                        nowX--;
                    }
                    if (board[nowY][nowX - 1] == 'O') {
                        return false;
                    }
                }
            }
        }
        if (redFall) {
            isEnd = true;
        }
        return true;
    }

    private static boolean moveRight(char[][] board) {
        boolean redFall = false;
        for (int i = board[0].length - 2; i >= 0; i--) {
            for (int j = 1; j < board.length; j++) {
                int nowY = j;
                int nowX = i;
                if (board[nowY][nowX] == 'R') {
                    while (board[nowY][nowX] == 'R' && board[nowY][nowX + 1] == '.') {
                        board[nowY][nowX] = '.';
                        board[nowY][nowX + 1] = 'R';
                        nowX++;
                    }
                    if (board[nowY][nowX + 1] == 'O') {
                        redFall = true;
                        board[nowY][nowX] = '.';
                    }
                } else if (board[nowY][nowX] == 'B') {
                    while (board[nowY][nowX] == 'B' && board[nowY][nowX + 1] == '.') {
                        board[nowY][nowX] = '.';
                        board[nowY][nowX + 1] = 'B';
                        nowX++;
                    }
                    if (board[nowY][nowX + 1] == 'O') {
                        return false;
                    }
                }
            }
        }
        if (redFall) {
            isEnd = true;
        }
        return true;
    }


    private static class Node {
        char[][] board;
        int depth;

        public Node(char[][] board, int depth) {
            this.board = board;
            this.depth = depth;
        }
    }
}