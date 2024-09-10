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
			String input = sc.next();
            int n = input.charAt(input.length()-1) - '0';
            System.out.print("#"+test_case+" ");
            if(n % 2 == 0) System.out.println("Even");
            else System.out.println("Odd");
		}
	}
}