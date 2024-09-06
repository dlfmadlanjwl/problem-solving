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
        int[][] paper = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        boolean[][] isVisited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                isVisited[i][j] = true;
                max = Math.max(dfs(paper, isVisited,0, i, j, 0), max);
                isVisited[i][j] = false;
            }
        }

        System.out.print(max);
    }

    static int dfs(int[][] graph, boolean[][] isVisited, int depth, int y, int x, int sum){
        if(depth == 4){
            return sum;
        }

        int max = 0;
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,1,-1};
        for(int i=0;i<dy.length;i++){
            int newY = y + dy[i];
            int newX = x + dx[i];

            if(newY < 0 || newY >= graph.length || newX < 0 || newX >= graph[0].length) continue;
            if(isVisited[newY][newX]) continue;

            if(depth == 2){
                isVisited[newY][newX] = true;
                int result = dfs(graph, isVisited, depth+1, y, x, sum + graph[newY][newX]);
                isVisited[newY][newX] = false;
                max = Math.max(max, result);
            }

            isVisited[newY][newX] = true;
            int result = dfs(graph, isVisited, depth+1, newY, newX, sum + graph[newY][newX]);
            isVisited[newY][newX] = false;
            max = Math.max(max, result);
        }

        return max;
    }
}