import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int m = sc.nextInt();
            int d = sc.nextInt();
            int sum = d;
			for(int i = 1;i<m;i++){
            	sum += days[i];
            }
            
            System.out.println("#"+test_case+" "+((sum+3)%7));
		}
	}
}