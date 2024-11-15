import java.util.Scanner;

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
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
            	arr[i] = sc.nextInt();
            }
            int[] dp = new int[n];
            int answer = 0;
            for(int i=0;i<n;i++){
                int max = 0;
            	for(int j=0;j<i;j++){
                	if(arr[i] > arr[j] && max <= dp[j]){
                    	max = dp[j];
                    }
                }
                dp[i] = max + 1;
                answer = Math.max(answer, dp[i]);
            }
            
            System.out.println("#"+test_case+" "+answer);
		}
	}
}