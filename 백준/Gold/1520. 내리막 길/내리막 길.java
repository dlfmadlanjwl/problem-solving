import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

       int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(map, dp, 0, 0));
    }

    static int dfs(int[][] map, int[][] dp, int y, int x){
        if(y == map.length-1 && x == map[0].length-1) return 1;

        if(dp[y][x] != -1){
            return dp[y][x];
        }

        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};

        dp[y][x] = 0;
        for(int i=0;i<dy.length;i++){
            int newY = y + dy[i];
            int newX = x + dx[i];

            if(newY < 0 || newY >= map.length || newX < 0 || newX >= map[0].length) continue;

            if(map[y][x] > map[newY][newX]) {
                dp[y][x] += dfs(map, dp, newY, newX);
            }
        }

        return dp[y][x];
    }
}