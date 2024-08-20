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
			int len = sc.nextInt();
            String a = sc.next();
            String b = sc.next();
            int count = 0;
            for(int i=0;i<len;i++){
            	if(a.charAt(i) == b.charAt(i)) count++;
            }
            System.out.println("#"+test_case+" "+count);
		}
	}
}