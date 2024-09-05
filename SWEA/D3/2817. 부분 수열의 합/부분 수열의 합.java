import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int k = sc.nextInt();
            int[] input = new int[n+1];
            for(int i=1;i<=n;i++){
            	input[i] = sc.nextInt();
            }
            Arrays.sort(input);
            int[][] dp = new int[n+1][k+1];
            dp[0][0] = 1;
            for(int i=1;i<=n;i++){
            	for(int j=0;j<=k;j++){
                    if(j - input[i] < 0) dp[i][j] = dp[i-1][j];
                	else dp[i][j] = dp[i-1][j] + dp[i-1][j-input[i]];
                }
            }
            System.out.println("#"+test_case+" "+dp[n][k]);
		}
	}
}