import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[n];
		for(int i=0;i<n;i++) {
			dp[i] = 1;
			for(int j=i-1;j>=0;j--) {
				if(input[i]>input[j]&&dp[j]>=dp[i]) {
					dp[i] = dp[j]+1;
				}
			}
		}
		int max = 0;
		for(int i=0;i<n;i++) {
			if(max<dp[i])max = dp[i];
		}
		System.out.print(max);
	}
}