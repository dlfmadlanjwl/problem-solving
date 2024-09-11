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
            double sum = 0;
            for(int i=0;i<n;i++){
            	double p = sc.nextDouble();
                int x = sc.nextInt();
                sum += p * x;
            }
            System.out.println("#"+test_case+" "+sum);
		}
	}
}