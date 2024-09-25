import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int MAX_DISTANCE = 1501;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] distances = new int[n+1][n+1];
        for(int[] distance : distances){
            Arrays.fill(distance, MAX_DISTANCE);
        }
        for(int i=0;i<=n;i++)distances[i][i] = 0;

        int[] items = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            items[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            distances[a][b] = l;
            distances[b][a] = l;
        }

        floydWarshall(distances);

        int max = 0;
        for(int i=1;i<=n;i++){
            int count = 0;
            for(int j=1;j<=n;j++){
                if(distances[i][j] <= m) count += items[j];
            }

            max = Math.max(max, count);
        }

        System.out.print(max);
    }

    static void floydWarshall(int[][] distances){
        for(int k=0;k<distances.length;k++){
            for(int i=0;i<distances.length;i++){
                for(int j=0;j<distances.length;j++){
                    if(distances[i][j] > distances[i][k] + distances[k][j]){
                        distances[i][j] = distances[i][k] + distances[k][j];
                    }
                }
            }
        }
    }
}