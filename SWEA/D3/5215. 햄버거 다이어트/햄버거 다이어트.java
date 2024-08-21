import java.util.Scanner;
import java.io.FileInputStream;

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
            int l = sc.nextInt();
            int[][] resources = new int[n][2];
            for(int i=0;i<n;i++){
            	resources[i][0] = sc.nextInt();
                resources[i][1] = sc.nextInt();
            }
            
            int[][] dp = new int[n+1][l+1];
           for(int i=1;i<=n;i++){
           		for(int j=1;j<=l;j++){
                    dp[i][j] = dp[i-1][j];
                	if(j - resources[i-1][1] >= 0){
                    	dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-resources[i-1][1]] + resources[i-1][0]);
                    }
                }
           }
  
           	System.out.println("#"+test_case+" "+dp[n][l]);
		}
	}
}