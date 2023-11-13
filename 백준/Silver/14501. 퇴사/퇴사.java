import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N];
        int[] P = new int[N];
        int[] dp = new int[N+1];
        StringTokenizer st;
        for(int n=0;n<N;n++){
            st = new StringTokenizer(br.readLine());
            T[n] = Integer.parseInt(st.nextToken());
            P[n] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            if(N>=i+T[i]){
                dp[i+T[i]] = Math.max(dp[i+T[i]],dp[i]+P[i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        System.out.print(dp[N]);
    }
}