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
			dp[i] = input[i];
			for(int j=0;j<i;j++) {
				if(input[j]<input[i]&&dp[i]<dp[j]+input[i]) {
					dp[i] = dp[j]+input[i];
				}
			}
		}
		int max = 0;
		for(int i=0;i<N;i++) {
			if(dp[i]>max)max = dp[i]; 
		}
		System.out.print(max);
	}
}