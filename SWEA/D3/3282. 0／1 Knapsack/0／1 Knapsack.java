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
            int[][] dp = new int[n+1][k+1];
            int[] weights = new int[n+1];
            int[] values = new int[n+1];
            for(int i=1;i<=n;i++){
            	weights[i] = sc.nextInt();
                values[i] = sc.nextInt();
            }
            Arrays.fill(dp[0], 0);
            for(int i=1;i<=n;i++){
            	for(int j=0;j<=k;j++){
                	if(j - weights[i] >= 0){
                    	dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weights[i]] + values[i]);
                    } else {
                    	dp[i][j] = dp[i-1][j];
                    }
                }
            }                                               
			System.out.println("#"+test_case+" "+dp[n][k]);
		}
	}
}