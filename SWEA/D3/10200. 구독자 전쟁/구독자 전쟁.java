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
            int a = sc.nextInt();
            int b = sc.nextInt();

            int max = Math.min(a,b);
            int min = a + b > n ? a + b - n : 0;
            System.out.println("#"+test_case+" "+max+" "+min);
		}
	}
}