import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=N;i++){
            if(i-M>=0){
                dp[i] = (dp[i-M]+dp[i-1])%1000000007;
            }else{
                dp[i] = dp[i-1]%1000000007;
            }
        }
        System.out.print(dp[N]);
    }
}