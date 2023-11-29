import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph, result;
    static boolean[][] visited;
    static int n,m;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];
        int x = 0,y = 0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp==2){
                    x = j;
                    y = i;
                }
                graph[i][j] = tmp;
                if(tmp==0){
                    result[i][j] = -1;
                }
            }
        }
        bfs(x,y);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==y&&j==x){
                    sb.append(0+" ");
                }else if(result[i][j]==-1){
                    sb.append(0+" ");
                }else if(result[i][j]==0){
                    sb.append(-1+" ");
                }else{
                    sb.append(result[i][j]+" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static void bfs(int x,int y){
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        visited[y][x] = true;
        while(!queue.isEmpty()){
            Point now = queue.poll();
            for(int i=0;i<4;i++){
                int newX = now.x + dx[i];
                int newY = now.y + dy[i];
                if(newX>=0&&newX<m&&newY>=0&&newY<n){
                    if(graph[newY][newX]!=0&&!visited[newY][newX]){
                        visited[newY][newX] = true;
                        result[newY][newX] = result[now.y][now.x]+1;
                        queue.add(new Point(newX,newY));
                    }
                }
            }

        }
    }
    static class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
