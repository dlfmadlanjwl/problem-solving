import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k+1];
        int[] coins = new int[n];
        for(int i=0;i<n;i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for(int i=1;i<=k;i++){
            for(int coin : coins){
                if(i - coin >= 0){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        if(dp[k] == Integer.MAX_VALUE - 1) System.out.println(-1);
        else System.out.print(dp[k]);
    }
}