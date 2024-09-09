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
            int count = 0;
            for(int i=1;i<=n;i++){
            	for(int j=1;j<=n;j++){
                	if(i*i + j*j <= n*n) count++;
                }
            }
            count *= 4;
            count += 4 * n + 1;
            System.out.println("#"+test_case+" "+count);
		}
	}
}