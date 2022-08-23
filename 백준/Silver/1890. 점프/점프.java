import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] input = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		long[][] dp = new long[N+1][N+1];
		dp[1][1] = 1;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==N&&j==N)continue;
				int next = input[i][j];
				if(i+next<=N)dp[i+next][j]+=dp[i][j];
				if(j+next<=N)dp[i][j+next]+=dp[i][j];
			}
		}
		
		System.out.print(dp[N][N]);
	}
}