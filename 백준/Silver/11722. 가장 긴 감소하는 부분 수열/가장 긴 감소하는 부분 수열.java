import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		for(int i=0;i<N;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				if(input[j]>input[i]&&dp[i]<=dp[j]) {
					dp[i] = dp[j]+1;
				}
			}
		}
		int max = 0;
		for(int i=0;i<N;i++) {
			if(max<dp[i])max = dp[i];
		}
		System.out.print(max);
	}
}