import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][][] tomatoes = new int[m][n][h];

        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<m;k++){
                    tomatoes[k][j][i] = Integer.parseInt(st.nextToken());
                }
            }
        }

        bfs(tomatoes);

        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(tomatoes[k][j][i] == 0) {
                        System.out.print(-1);
                        return;
                    }
                }
            }
        }

        System.out.print(max);
    }

    static void bfs(int[][][] tomatoes){
        Queue<Tomato> q = new LinkedList<>();
        for(int i=0;i<tomatoes.length;i++){
            for(int j=0;j<tomatoes[0].length;j++){
                for(int k=0;k<tomatoes[0][0].length;k++){
                    if(tomatoes[i][j][k] == 1) q.add(new Tomato(i, j, k, 0));
                }
            }
        }

        while(!q.isEmpty()){
            Tomato now = q.poll();

            max = Math.max(max, now.depth);

            int[] dx = {1, -1, 0, 0, 0, 0};
            int[] dy = {0, 0, 1, -1, 0, 0};
            int[] dz = {0, 0, 0, 0, 1, -1};

            for(int i=0;i<dx.length;i++){
                int newX = now.x + dx[i];
                int newY = now.y + dy[i];
                int newZ = now.z + dz[i];

                if(newX < 0 || newX >= tomatoes.length) continue;
                if(newY < 0 || newY >= tomatoes[0].length) continue;
                if(newZ < 0 || newZ >= tomatoes[0][0].length) continue;
                if(tomatoes[newX][newY][newZ] != 0) continue;

                q.add(new Tomato(newX, newY, newZ, now.depth+1));
                tomatoes[newX][newY][newZ] = 1;

            }
        }
    }

    static class Tomato{
        int x;
        int y;
        int z;
        int depth;

        Tomato(int x, int y, int z, int depth){
            this.x = x;
            this.y = y;
            this.z = z;
            this.depth = depth;
        }
    }
}
