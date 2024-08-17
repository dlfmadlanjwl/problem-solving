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
			int l = sc.nextInt();
            int u = sc.nextInt();
            int x = sc.nextInt();
            System.out.print("#"+test_case+" ");
            if(x > u) System.out.println(-1);
            else if(x <= l) System.out.println(l - x);
            else System.out.println(0);
		}
	}
}