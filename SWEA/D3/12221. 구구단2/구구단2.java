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
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.print("#"+test_case+" ");
            if(a > 9 || b > 9) System.out.println(-1);
            else System.out.println(a * b);
		}
	}
}