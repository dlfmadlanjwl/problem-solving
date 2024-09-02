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
        char[][] campers = new char[n][m];
        int startY = 0, startX = 0;
        for(int i=0;i<n;i++){
            String input = br.readLine();
            for(int j=0;j<m;j++){
                campers[i][j] = input.charAt(j);
                if(campers[i][j] == 'I'){
                    startY = i;
                    startX = j;
                }
            }
        }

        int answer = dfs(campers, new boolean[n][m], startY, startX);
        System.out.print(answer != 0 ? answer : "TT");
    }

    static int dfs(char[][] graph, boolean[][] isVisited, int y, int x){
        isVisited[y][x] = true;

        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};

        int count = 0;
        if(graph[y][x] == 'P') count++;

        for(int i=0;i<dy.length;i++){
            int newY = y + dy[i];
            int newX = x + dx[i];

            if(newY < 0 || newY >= graph.length || newX < 0 || newX >= graph[0].length) continue;
            if(isVisited[newY][newX] || graph[newY][newX] == 'X') continue;

            count += dfs(graph, isVisited, newY, newX);
        }

        return count;
    }
}