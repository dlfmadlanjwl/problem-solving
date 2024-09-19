import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static long MAX_DISTANCE = (long)100_000 * 100_000 + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] distance = new long[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(distance[i], MAX_DISTANCE);
        }

        for(int i=1;i<=n;i++){
            distance[i][i] = 0;
        }
        int m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            distance[a][b] = Math.min(distance[a][b] , c);
        }

        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(distance[i][j] == MAX_DISTANCE) System.out.print(0 + " ");
                else System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }
}