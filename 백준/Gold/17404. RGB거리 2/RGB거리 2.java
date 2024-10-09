import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][3];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            int[][] dp = new int[n][3];
            for(int j=0;j<3;j++){
                if(i == j) dp[0][i] = cost[0][i];
                else dp[0][j] = 1001;
            }
            for(int j=1;j<n;j++){
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + cost[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + cost[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + cost[j][2];
            }
            int min = Integer.MAX_VALUE;
            for(int j=0;j<3;j++){
                if(i == j) continue;
                min = Math.min(min, dp[n-1][j]);
            }
            answer = Math.min(answer, min);
        }

        System.out.print(answer);
    }
}