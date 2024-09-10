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
            System.out.print("#"+test_case+" ");
            if(n % 2 == 0) System.out.println("Alice");
            else System.out.println("Bob");
		}
	}
}