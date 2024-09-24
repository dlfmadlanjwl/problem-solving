import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        board = new char[r][c];

        for(int i = 0; i < r; i++){
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        int answer = dfs(0, 0, board[0][0]+"");
        System.out.print(answer);
    }

    static int dfs(int y, int x, String str){
        int max = str.length();

        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};

        for(int i=0;i<4;i++){
            int newY = y + dy[i];
            int newX = x + dx[i];

            if(newY >= board.length || newY < 0 || newX >= board[0].length || newX < 0) continue;
            if(str.contains(board[newY][newX]+"")) continue;

            max = Math.max(max, dfs(newY, newX, str + board[newY][newX]));
        }

        return max;
    }
}