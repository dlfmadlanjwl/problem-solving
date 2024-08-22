import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];

        for(int i=0;i<n;i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[k+1][n+1];
        for(int i=1;i<=k;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = dp[i][j-1];
                if(i % coins[j-1] == 0) dp[i][j]++;
                int count = 1;
                while(i - coins[j-1] * count > 0){
                    dp[i][j] += dp[i - coins[j-1]*count][j-1];
                    count++;
                }

            }
        }
       
        System.out.print(dp[k][n]);
    }
}

