import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] picture = new char[n][n];
        for(int i=0;i<n;i++){
            String input = br.readLine();
            for(int j=0;j<n;j++){
                picture[i][j] = input.charAt(j);
            }
        }

        boolean[][] isVisited = new boolean[n][n];
        int area1 = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isVisited[i][j]) continue;
                dfs(picture, isVisited, i, j);
                area1++;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j] == 'G') picture[i][j] = 'R';
            }
        }

        isVisited = new boolean[n][n];
        int area2 = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isVisited[i][j]) continue;
                dfs(picture, isVisited, i, j);
                area2++;
            }
        }

        System.out.println(area1 + " " + area2);
    }

    static void dfs(char[][] graph, boolean[][] isVisited, int y, int x){
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};

        for(int i=0;i<dy.length;i++){
            int newY = y + dy[i];
            int newX = x + dx[i];

            if(newY < 0 || newY >= graph.length || newX < 0 || newX >= graph.length) continue;
            if(isVisited[newY][newX] || graph[newY][newX] != graph[y][x]) continue;

            isVisited[newY][newX] = true;
            dfs(graph, isVisited, newY, newX);
        }
    }
}